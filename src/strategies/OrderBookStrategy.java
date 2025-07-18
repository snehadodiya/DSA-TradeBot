package strategies;

import java.util.*;

public class OrderBookStrategy implements Strategy {

    private static class Order {
        double price;
        int day;

        Order(double price, int day) {
            this.price = price;
            this.day = day;
        }
    }

    @Override
    public List<String> generateSignals(List<Double> prices) {
        PriorityQueue<Order> buyOrders = new PriorityQueue<>((a, b) -> Double.compare(b.price, a.price)); // MaxHeap
        PriorityQueue<Order> sellOrders = new PriorityQueue<>(Comparator.comparingDouble(a -> a.price)); // MinHeap

        List<String> signals = new ArrayList<>(Collections.nCopies(prices.size(), "HOLD"));

        for (int i = 0; i < prices.size(); i++) {
            double marketPrice = prices.get(i);

            // Simulate alternating BUY/SELL orders (for demonstration)
            if (i % 2 == 0) {
                buyOrders.offer(new Order(marketPrice - 2, i));
            } else {
                sellOrders.offer(new Order(marketPrice + 2, i));
            }

            // Try to match orders
            while (!buyOrders.isEmpty() && !sellOrders.isEmpty()
                    && buyOrders.peek().price >= sellOrders.peek().price) {

                Order buy = buyOrders.poll();
                Order sell = sellOrders.poll();

                signals.set(buy.day, "BUY");
                signals.set(sell.day, "SELL");
            }
        }

        return signals;
    }
}
