package pharmacy.shop.medicine_decorator;

import pharmacy.shop.Medicine;

public abstract class MedicineDecorator extends Medicine {
    public Medicine medicine;

    public MedicineDecorator(Medicine medicine) {
        this.medicine = medicine;
    }


    @Override
    public abstract double cost();
}
