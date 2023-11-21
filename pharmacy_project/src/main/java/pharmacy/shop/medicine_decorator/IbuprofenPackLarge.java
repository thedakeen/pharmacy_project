package pharmacy.shop.medicine_decorator;

import pharmacy.shop.Medicine;

public class IbuprofenPackLarge extends MedicineDecorator{

    public IbuprofenPackLarge(Medicine medicine) {
        super(medicine);
    }

    @Override
    public String getDescription() {
        return "Ibuprofen small package | 20 tablets | ₸"+cost();
    }

    @Override
    public double cost() {
        return 2000;
    }
}
