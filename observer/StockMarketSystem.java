import java.util.ArrayList;

// Observer interface
interface StockObserver {
    void update(String stockName, double price);
}

// Concrete Observers
class Investor implements StockObserver {
    private String name;

    public Investor(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockName, double price) {
        System.out.println("Investor " + name + " notified: " + stockName + " price changed to $" + price);
    }
}

// Subject interface
interface StockSubject {
    void addObserver(StockObserver observer);
    void removeObserver(StockObserver observer);
    void notifyObservers();
}

// Concrete Subject
class Stock implements StockSubject {
    private String stockName;
    private double price;
    private ArrayList<StockObserver> observers = new ArrayList<>();

    public Stock(String stockName, double price) {
        this.stockName = stockName;
        this.price = price;
    }

    @Override
    public void addObserver(StockObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(StockObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (StockObserver observer : observers) {
            observer.update(stockName, price);
        }
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }
}

// Driver class to test the implementation
public class StockMarketSystem {
    public static void main(String[] args) {
        Stock apple = new Stock("Apple", 150.00);

        StockObserver investor1 = new Investor("John");
        StockObserver investor2 = new Investor("Emma");

        apple.addObserver(investor1);
        apple.addObserver(investor2);

        System.out.println("Apple stock price updated to $155.00...");
        apple.setPrice(155.00);

        System.out.println("Apple stock price updated to $160.00...");
        apple.setPrice(160.00);
    }
}
