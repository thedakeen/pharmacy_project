package pharmacy.shop;

public class MedicineFactory {
    public Medicine createMedicine(String medicine){
        if(medicine.equalsIgnoreCase("Ibuprofen")){
            return new Ibuprofen();

        }
        else if(medicine.equalsIgnoreCase("Aspirin")){
            return new Aspirin();
        }
        else{
            throw new RuntimeException("No options for "+medicine);
        }

    }
}
