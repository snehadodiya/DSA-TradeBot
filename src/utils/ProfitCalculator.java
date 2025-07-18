package utils;

import java.util.List;

public class ProfitCalculator {

    public static double calculateProfit(List<Double> prices, List<String> signals) {
        boolean holding = false;
        double buyPrice = 0.0;
        double profit = 0.0;

        for (int i = 0; i < prices.size(); i++) {
            String signal = signals.get(i);
            double price = prices.get(i);

            if (signal.equals("BUY") && !holding) {
                buyPrice = price;
                holding = true;
            } else if (signal.equals("SELL") && holding) {
                profit += (price - buyPrice);
                holding = false;
            }
        }

        // Optional: If still holding at end, assume we sell at last price
        if (holding) {
            profit += (prices.get(prices.size() - 1) - buyPrice);
        }

        return profit;
    }
}
