package pharmacy.shop;

public interface Observed {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String country);
}
