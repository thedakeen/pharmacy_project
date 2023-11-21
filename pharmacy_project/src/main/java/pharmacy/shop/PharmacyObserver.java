package pharmacy.shop;

public class PharmacyObserver implements Observer{

    @Override
    public void update(String medicine) {
        System.out.println("Available medicine: " + medicine);
    }
}
