import java.util.LinkedHashMap;
import java.util.Map;

public class Purse {
    private final Map<Denomination, Integer> cash = new LinkedHashMap<>();

    public Map<Denomination, Integer> getCash() {
        return cash;
    }

    public void add(Denomination type, int num) {
        cash.put(type, cash.getOrDefault(type, 0) + num);
    }

    public double remove(Denomination type, int num) {

        cash.put(type, cash.get(type) - num);
        if (cash.get(type) == 0) {
            cash.remove(type);
        }
        return type.amt() * num;
    }

    public double getValue() {
        return cash.entrySet().stream().mapToDouble(entry -> entry.getKey().amt() * entry.getValue()).sum();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Purse contents:\n");
        cash.forEach((denomination, count) -> sb.append(count)
                .append(" x ")
                .append(denomination.name())
                .append(" ($")
                .append(String.format("%.2f", denomination.amt()))
                .append(")\n"));
        sb.append("Total value: $").append(String.format("%.2f", getValue()));
        return sb.toString();
    }
}
