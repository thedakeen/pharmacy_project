package pharmacy.shop;

public class Ibuprofen extends Medicine{
    public Ibuprofen(){
        description = "Ibuprofen ";
    }


    @Override
    public double cost() {
        return 0;
    }
}
