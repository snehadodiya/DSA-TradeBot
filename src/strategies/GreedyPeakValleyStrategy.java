package strategies;

import java.util.ArrayList;
import java.util.List;

public class GreedyPeakValleyStrategy implements Strategy {

    @Override
    public List<String> generateSignals(List<Double> prices) {
        List<String> signals = new ArrayList<>();
        int n = prices.size();

        for (int i = 0; i < n; i++) {
            boolean isValley = i > 0 && i < n - 1 &&
                    prices.get(i) < prices.get(i - 1) && prices.get(i) < prices.get(i + 1);
            boolean isPeak = i > 0 && i < n - 1 &&
                    prices.get(i) > prices.get(i - 1) && prices.get(i) > prices.get(i + 1);

            if (isValley) {
                signals.add("BUY");
            } else if (isPeak) {
                signals.add("SELL");
            } else {
                signals.add("HOLD");
            }
        }

        // Handle first and last days safely
        if (n >= 1) signals.set(0, "HOLD");
        if (n >= 2) signals.set(n - 1, "HOLD");

        return signals;
    }
}
