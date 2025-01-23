import java.util.LinkedHashMap;
import java.util.Map;

public class Purse {
    private final Map<Denomination, Integer> cash = new LinkedHashMap<>();

    public void add(Denomination type, int num) {
        if (num <= 0) {
            throw new IllegalArgumentException("Cannot add zero or negative quantity.");
        }
        cash.put(type, cash.getOrDefault(type, 0) + num);
    }

    public double remove(Denomination type, int num) {
        if (num <= 0) {
            throw new IllegalArgumentException("Cannot remove zero or negative quantity.");
        }
        if (!cash.containsKey(type)) {
            throw new IllegalArgumentException("The denomination is not present in the purse.");
        }
        if (cash.get(type) < num) {
            throw new IllegalArgumentException("Insufficient quantity of " + type.name() + " in the purse.");
        }

        cash.put(type, cash.get(type) - num);
        if (cash.get(type) == 0) {
            cash.remove(type);
        }
        return type.amt() * num;
    }

    public double getValue() {
        return cash.entrySet()
                .stream()
                .mapToDouble(entry -> entry.getKey().amt() * entry.getValue())
                .sum();
    }

    @Override
    public String toString() {
        if (cash.isEmpty()) {
            return "Purse is empty.";
        }

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
