package pharmacy.shop.medicine_decorator;

import pharmacy.shop.Medicine;

public class AspirinPackSmall extends MedicineDecorator{

    public AspirinPackSmall(Medicine medicine) {
        super(medicine);
    }

    @Override
    public String getDescription() {
        return "Aspirin small package | 8 tablets | ₸"+cost();
    }

    @Override
    public double cost() {
        return 900;
    }

}
