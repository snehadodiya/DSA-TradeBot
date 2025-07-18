package strategies;

import java.util.List;

public interface Strategy {
    List<String> generateSignals(List<Double> prices);
}
