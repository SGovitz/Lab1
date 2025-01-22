import java.util.HashMap;
import java.util.Map;

class Purse {
    private final Map<Denomination, Integer> cash = new HashMap<>();
    public void add(Denomination type, int num) {
        cash.put(type, num);
    }
    public double remove(Denomination type, int num) {
        if (!cash.containsKey(type) || cash.get(type) < num) {
            throw new IllegalArgumentException("Not enough of the specified denomination.");
        }
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
        cash.forEach((denomination, count) -> sb.append(count).append(" x ").append(denomination).append("\n"));
        sb.append("Total value: $").append(String.format("%.2f", getValue()));
        return sb.toString();
    }

}