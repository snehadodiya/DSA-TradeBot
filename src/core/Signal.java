package core;

public enum Signal {
    BUY,
    SELL,
    HOLD;

    @Override
    public String toString() {
        return name();  // Ensures uppercase string
    }
}
