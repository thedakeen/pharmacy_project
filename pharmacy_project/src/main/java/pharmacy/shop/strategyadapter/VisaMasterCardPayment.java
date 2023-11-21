package pharmacy.shop.strategyadapter;

public class VisaMasterCardPayment implements Payment{
    String cardNum;
    String expiration;
    String fullName;
    String secretCode;

    public VisaMasterCardPayment(String cardNum, String expiration, String fullName, String secretCode) {
        this.cardNum = cardNum;
        this.expiration = expiration;
        this.fullName = fullName;
        this.secretCode = secretCode;
    }

    @Override
    public void PaymentProcess(double amount) {
        System.out.println("The payment was successful");
    }
}
