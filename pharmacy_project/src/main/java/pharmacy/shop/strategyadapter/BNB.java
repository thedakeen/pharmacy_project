package pharmacy.shop.strategyadapter;

public class BNB implements CryptoCurrency{

    String address;
    double Amount;
    public BNB(String address) {
        this.address = address;
    }

    @Override
    public void convert(double Amount) {
        this.Amount = Amount / 113740;
    }

    @Override
    public void pay() {
        System.out.println("Amount: " + Amount + " BNB");
        System.out.println("Address: " + address);
        System.out.println("The payment was successful!!!");
    }
}
