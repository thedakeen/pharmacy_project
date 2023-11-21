package pharmacy.shop;


// aspirin и ibuprofen 2 класса для обсервера, будут еще и выполнять функцию в декораторе, продолжение в ->
// -> package medicine.decorator
public class Aspirin extends Medicine{

    public Aspirin(){
        description = "Aspirin ";
    }


    @Override
    public double cost() {
        return 0;
    }
}
