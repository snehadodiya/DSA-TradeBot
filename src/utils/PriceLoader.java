package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PriceLoader {

    public static List<Double> loadPrices(String filePath) {
        List<Double> prices = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                try {
                    prices.add(Double.parseDouble(line.trim()));
                } catch (NumberFormatException e) {
                    System.err.println("Skipping invalid price: " + line);
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return prices;
    }
}
