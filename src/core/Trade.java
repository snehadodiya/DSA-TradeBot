package core;

public class Trade {
    private final int day;
    private final double price;
    private final Signal signal;

    public Trade(int day, double price, Signal signal) {
        this.day = day;
        this.price = price;
        this.signal = signal;
    }

    public int getDay() {
        return day;
    }

    public double getPrice() {
        return price;
    }

    public Signal getSignal() {
        return signal;
    }

    @Override
    public String toString() {
        return String.format("Day %d\t%.2f\t%s", day + 1, price, signal);
    }
}
