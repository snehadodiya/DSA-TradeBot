package core;

import strategies.Strategy;
import java.util.ArrayList;
import java.util.List;

public class TradeEngine {
    private final Strategy strategy;

    public TradeEngine(Strategy strategy) {
        this.strategy = strategy;
    }

    public List<Trade> execute(List<Double> prices) {
        List<String> signals = strategy.generateSignals(prices);  // "BUY", "SELL", "HOLD"
        List<Trade> trades = new ArrayList<>();

        for (int i = 0; i < prices.size(); i++) {
            Signal signal = Signal.valueOf(signals.get(i).toUpperCase());
            trades.add(new Trade(i, prices.get(i), signal));
        }

        return trades;
    }
}
