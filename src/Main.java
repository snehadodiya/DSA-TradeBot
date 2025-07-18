import core.*;
import strategies.*;
import utils.*;

import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("📊 Select a Trading Strategy:");
        System.out.println("1. Moving Average (3-day vs 5-day)");
        System.out.println("2. Greedy Peak-Valley");
        System.out.println("3. Order Book Matching (Heap)");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();

        Strategy strategy;
        switch (choice) {
            case 1 -> strategy = new MovingAverageStrategy(3, 5);
            case 2 -> strategy = new GreedyPeakValleyStrategy();
            case 3 -> strategy = new OrderBookStrategy();
            default -> {
                System.out.println("Invalid choice. Exiting.");
                return;
            }
        }

        List<Double> prices = PriceLoader.loadPrices("data/prices.txt");
        if (prices.isEmpty()) {
            System.out.println("No price data found.");
            return;
        }

        TradeEngine engine = new TradeEngine(strategy);
        List<Trade> trades = engine.execute(prices);

        System.out.println("\nDay\tPrice\tSignal");
        trades.forEach(System.out::println);

        double profit = ProfitCalculator.calculateProfit(
            prices, trades.stream().map(t -> t.getSignal().toString()).collect(Collectors.toList())
        );
        System.out.printf("\nTotal Profit: ₹%.2f\n", profit);

        exportToCSV(trades);  // Call export function
    }

    private static void exportToCSV(List<Trade> trades) {
        try (PrintWriter pw = new PrintWriter(new File("trade_report.csv"))) {
            pw.println("Day,Price,Signal");
            for (Trade trade : trades) {
                pw.printf("%d,%.2f,%s\n", trade.getDay() + 1, trade.getPrice(), trade.getSignal());
            }
            System.out.println("✅ Trade report saved to 'trade_report.csv'");
        } catch (IOException e) {
            System.err.println("❌ Failed to write CSV: " + e.getMessage());
        }
    }
}
