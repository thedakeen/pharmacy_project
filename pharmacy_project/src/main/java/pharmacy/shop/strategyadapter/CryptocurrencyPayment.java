package pharmacy.shop.strategyadapter;

public class CryptocurrencyPayment implements Payment{
    CryptoCurrency cryptoCurrency;
    public CryptocurrencyPayment(CryptoCurrency cryptoCurrency) {
        this.cryptoCurrency = cryptoCurrency;
    }

    @Override
    public void PaymentProcess(double amount) {
        cryptoCurrency.convert(amount);
        cryptoCurrency.pay();
    }
}
