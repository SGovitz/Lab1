import java.util.Scanner;

public class Register {
    private static final Denomination[] denominations = {
            new Denomination("Hundred Note", 100.00, "bill", "Images/Hundred_Bill.jpg"),
            new Denomination("Fifty Note", 50.00, "bill", "Images/Fifty_Bill.jpg"),
            new Denomination("Twenty Note", 20.00, "bill", "Images/Twenty_Bill.jpg"),
            new Denomination("Ten Note", 10.00, "bill", "Images/Ten_Bill.jpg"),
            new Denomination("Five Note", 5.00, "bill", "Images/Five_Bill.jpg"),
            new Denomination("One Note", 1.00, "bill", "Images/One_Bill.jpg"),
            new Denomination("Quarter", 0.25, "coin", "Images/Quarter_Coin.jpeg"),
            new Denomination("Dime", 0.10, "coin", "Images/Dime_Coin.png"),
            new Denomination("Nickel", 0.05, "coin", "Images/Nickel_Coin.jpeg"),
            new Denomination("Penny", 0.01, "coin", "Images/Penny_Coin.png")
    };

    public Purse makeChange(double amt) {
        Purse money = new Purse();

        for (Denomination denom : denominations) {
            int count = (int) (amt / denom.amt());
            if (count > 0) {
                money.add(denom, count);
                amt -= count * denom.amt();
                amt = Math.round(amt * 100.0) / 100.0; // Round to avoid precision errors
            }
        }

        if (amt > 0) {
            throw new IllegalArgumentException("Cannot make exact change for the specified amount.");
        }

        return money;
    }
}
