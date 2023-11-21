package pharmacy.shop.strategyadapter;

public class WAX implements CryptoCurrency{
    String address;
    String memo;
    double Amount;
    public WAX(String address, String memo) {
        this.address = address;
        this.memo = memo;
    }

    @Override
    public void convert(double Amount) {
        this.Amount = Amount / 29;
    }

    @Override
    public void pay() {
        System.out.println("Amount: " + Amount + " WAX");
        System.out.println("Address: " + address + "/" + memo);
        System.out.println("The payment was successful!!!");
    }
}
