package pharmacy.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pharmacy.DAO.UserDAO;
import pharmacy.shop.*;
import pharmacy.shop.medicine_decorator.AspirinPackLarge;
import pharmacy.shop.medicine_decorator.AspirinPackSmall;
import pharmacy.shop.medicine_decorator.IbuprofenPackLarge;
import pharmacy.shop.medicine_decorator.IbuprofenPackSmall;
import pharmacy.shop.strategyadapter.*;

import java.util.Scanner;

@Component
public class App {
    private final UserDAO userDAO;
    private String loggedInUsername = null;
@Autowired
    public App(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int choice = 1;
        double totalCost = 0;

        outerLoop:
        while (choice != 0) {
            if (loggedInUsername == null) {
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Delete Account");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        signUp(scanner);
                        break;
                    case 2:
                        signIn(scanner);
                        break;
                    case 3:
                        deleteUser(scanner);
                        break;
                }
            } else {
                while (true) {
                    System.out.println("1. Buy aspirin");
                    System.out.println("2. Buy ibuprofen");
                    /////////////////////////////////////




                    System.out.println("3. Go to pay"); // здесь выведет общую стоимость заказа и вот отсюда надо потом начинать оплату




                    /////////////////////////////////////
                    System.out.println("0. Cancel");
                    System.out.print("Enter your choice: ");
                    Medicine medicine = null;

                    int choice_buy = scanner.nextInt();

                    if (choice_buy == 0) {
                        loggedInUsername = null;
                        break;
                    }


                    switch (choice_buy) {
                        case 1:
                            medicine = new Aspirin();
                            break;
                        case 2:
                            medicine = new Ibuprofen();
                            break;
                        case 3:
                            System.out.println("Total cost: " + totalCost + " KZT");
                            payment(totalCost);
                            totalCost = 0;
                            break;
                        default:
                            continue;
                    }
                    if (medicine != null) {
                        // Добавим выбор декоратора после выбора товара
                        System.out.println("Choose a pack:");
                        System.out.println("1. Large Pack");
                        System.out.println("2. Small Pack");
                        System.out.println("0. Exit");
                        System.out.print("Enter your choice: ");

                        int packChoice = scanner.nextInt();

                        switch (packChoice) {
                            case 1:
                                if(medicine instanceof Aspirin)
                                    medicine = new AspirinPackLarge(medicine);
                                else if(medicine instanceof Ibuprofen)
                                    medicine = new IbuprofenPackLarge(medicine);
                                break;
                            case 2:
                                if(medicine instanceof Aspirin)
                                    medicine = new AspirinPackSmall(medicine);
                                else if(medicine instanceof Ibuprofen)
                                    medicine = new IbuprofenPackSmall(medicine);
                                break;
                            case 0:
                                break;
                            default:
                                continue;
                        }

                        totalCost += medicine.cost();
                        System.out.println("You have chosen: " + medicine.getDescription());
                    }
                    break;
                }
            }
        }
    }

    private void signUp(Scanner scanner){
        System.out.println("Enter login: ");
        String username = scanner.next();
        if (userDAO.isUserExists(username)) {
            System.out.println("Username already exists. Please choose another username.");
        } else {
            System.out.print("Enter password: ");
            String password = scanner.next();
            userDAO.signUp(username, password);
            System.out.println("Registration successful!");
        }
    }

    private void signIn(Scanner scanner){
        System.out.println("Enter login: ");
        String username = scanner.next();
        System.out.println("Enter password: ");
        String password = scanner.next();
        if(userDAO.signIn(username,password)){
            loggedInUsername = username;
            System.out.println("Logged in successfully\n "+"---------------------");
            System.out.println("Hello, " + loggedInUsername);
            System.out.println("Welcome to our Pharmacy!\n "+"---------------------");

            // obs and factory shows available products
            MedicineFactory medicineFactory = new MedicineFactory();
            Medicine ibuprofen = medicineFactory.createMedicine("Ibuprofen");
            Medicine aspirin = medicineFactory.createMedicine("Aspirin");
            PharmacyObserver observer = new PharmacyObserver();
            ibuprofen.addObserver(observer);
            aspirin.addObserver(observer);
            //

            ibuprofen.notifyObservers("Ibuprofen");
            aspirin.notifyObservers("Aspirin");
        }
        else{
            System.out.println("Incorrect login or password");
        }
    }

    private void deleteUser(Scanner scanner){
        System.out.println("WARNING! You are gonna delete your account");
        System.out.println("Enter login: ");
        String username = scanner.next();
        System.out.println("Enter password: ");
        String password = scanner.next();

        if(userDAO.signIn(username,password)){
            userDAO.deleteUser(username,password);
            System.out.println("Account deleted successfully");
        }
        else{
            System.out.println("Account not found");
        }
    }

    private void payment(double totalCost) {
        if(totalCost == 0){
            System.out.println("First select the product");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 1 to pay by Visa/Master card");
        System.out.println("Enter 2 to pay by Cryptocurrency");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter card number:");
                String cardNum = scanner.next();
                System.out.println("Enter expiration date:");
                String expiration = scanner.next();
                System.out.println("Enter full name:");
                String fullName = scanner.next();
                System.out.println("Enter secret code:");
                String secretCode = scanner.next();

                Payment card = new VisaMasterCardPayment(cardNum, expiration, fullName, secretCode);
                card.PaymentProcess(totalCost);
                break;
            case 2:
                System.out.println("Enter 1 to choose BNB");
                System.out.println("Enter 2 to choose ETH");
                System.out.println("Enter 3 to choose WAX");

                choice = scanner.nextInt();

                Payment cryptocurrencypayment = null;
                String address = null;
                switch (choice) {
                    case 1:
                        System.out.println("Enter Address: ");
                        address = scanner.next();

                        cryptocurrencypayment = new CryptocurrencyPayment(new BNB(address));
                        cryptocurrencypayment.PaymentProcess(totalCost);
                        break;
                    case 2:
                        System.out.println("Enter Address: ");
                        address = scanner.next();

                        cryptocurrencypayment = new CryptocurrencyPayment(new ETH(address));
                        cryptocurrencypayment.PaymentProcess(totalCost);
                        break;
                    case 3:
                        System.out.println("Enter Address: ");
                        address = scanner.next();
                        System.out.println("Enter Address: ");
                        String memo = scanner.next();

                        cryptocurrencypayment = new CryptocurrencyPayment(new WAX(address, memo));
                        cryptocurrencypayment.PaymentProcess(totalCost);
                        break;
                }

                break;
        }

    }
}
