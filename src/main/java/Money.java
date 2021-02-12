public class Money implements Expression {

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

    @Override
    public Expression times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    @Override
    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }

    @Override
    public Money reduce(Bank bank, String to) {
        int rate = bank.rate(currency, to);
        return new Money(amount / rate, to);
    }
}
