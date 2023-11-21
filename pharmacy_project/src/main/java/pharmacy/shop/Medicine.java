package pharmacy.shop;

import java.util.ArrayList;
import java.util.List;


public abstract class Medicine implements Observed{
    private List<Observer> clients = new ArrayList<>();

    // decorator logic

    protected String medicine;
    public String description;


    public String getDescription() {
        return description;
    }

    public abstract double cost();

    //

    // observer logic

    @Override
    public void addObserver(Observer observer) {
        clients.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        clients.remove(observer);
    }

    @Override
    public void notifyObservers(String medicine) {
        this.medicine = medicine;
        for(Observer observer : clients){
            observer.update(medicine);
        }
    }

    //

}
