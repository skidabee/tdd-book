public class Money {

    Money(int amount, String currency) {
        this.currency = currency;
        this.amount = amount;
    }

    protected int amount;
    protected String currency;

    public static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    @Override
    public boolean equals(Object object) {
        Money money = (Money) object;
        return this.amount == money.amount
                && currency().equals(money.currency());
    }

    public String currency() {
        return currency;
    }

    @Override
    public String toString() {
        return amount + " " + currency;
    }

    Money times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }
}
