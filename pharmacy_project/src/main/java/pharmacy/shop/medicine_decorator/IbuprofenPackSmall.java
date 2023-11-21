package pharmacy.shop.medicine_decorator;

import pharmacy.shop.Medicine;

public class IbuprofenPackSmall extends MedicineDecorator{
    public IbuprofenPackSmall(Medicine medicine) {
        super(medicine);
    }

    @Override
    public String getDescription() {
        return "Ibuprofen small package | 10 tablets | ₸"+cost();
    }

    @Override
    public double cost() {
        return 1200;
    }
}
