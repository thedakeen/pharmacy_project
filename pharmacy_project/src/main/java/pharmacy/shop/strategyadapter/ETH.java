package pharmacy.shop.strategyadapter;

public class ETH implements CryptoCurrency{

    String address;
    double Amount;
    public ETH(String address) {
        this.address = address;
    }

    @Override
    public void convert(double Amount) {
        this.Amount = Amount / 915560;
    }

    @Override
    public void pay() {
        System.out.println("Amount: " + Amount + " ETH");
        System.out.println("Address: " + address);
        System.out.println("The payment was successful!!!");
    }
}
