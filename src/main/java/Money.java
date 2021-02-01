public abstract class Money {

    Money(int amount, String currency) {
        this.currency = currency;
        this.amount = amount;
    }

    protected int amount;
    protected String currency;

    public static Money dollar(int amount) {
        return new Dollar(amount, "USD");
    }

    static Money franc(int amount) {
        return new Franc(amount, "CHF");
    }

    @Override
    public boolean equals(Object object) {
        Money money = (Money) object;
        return this.amount == money.amount
                && getClass().equals(money.getClass());
    }

    abstract Money times(int i);

    public String currency() {
        return currency;
    }
}
