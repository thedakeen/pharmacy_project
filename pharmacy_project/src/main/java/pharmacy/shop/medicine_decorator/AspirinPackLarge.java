package pharmacy.shop.medicine_decorator;

import pharmacy.shop.Medicine;

public class AspirinPackLarge extends MedicineDecorator{
    public AspirinPackLarge(Medicine medicine) {
        super(medicine);
    }

    @Override
    public String getDescription() {
        return "Aspirin large package | 16 tablets | ₸"+cost();
    }

    @Override
    public double cost() {
        return 1700;
    }
}
