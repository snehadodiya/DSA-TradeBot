package strategies;

import java.util.ArrayList;
import java.util.List;

public class MovingAverageStrategy implements Strategy {

    private int fastWindow; // e.g. 3 days
    private int slowWindow; // e.g. 5 days

    public MovingAverageStrategy(int fastWindow, int slowWindow) {
        this.fastWindow = fastWindow;
        this.slowWindow = slowWindow;
    }

    private double getAverage(List<Double> prices, int endIndex, int window) {
        if (endIndex - window + 1 < 0) return 0.0;

        double sum = 0.0;
        for (int i = endIndex - window + 1; i <= endIndex; i++) {
            sum += prices.get(i);
        }
        return sum / window;
    }

    @Override
    public List<String> generateSignals(List<Double> prices) {
        List<String> signals = new ArrayList<>();
        String prevSignal = "HOLD";

        for (int i = 0; i < prices.size(); i++) {
            double fastAvg = getAverage(prices, i, fastWindow);
            double slowAvg = getAverage(prices, i, slowWindow);

            if (i < slowWindow - 1) {
                signals.add("HOLD"); // not enough data
                continue;
            }

            if (fastAvg > slowAvg && !prevSignal.equals("BUY")) {
                signals.add("BUY");
                prevSignal = "BUY";
            } else if (fastAvg < slowAvg && !prevSignal.equals("SELL")) {
                signals.add("SELL");
                prevSignal = "SELL";
            } else {
                signals.add("HOLD");
            }
        }

        return signals;
    }
}
