public class Sum implements Expression {

    Sum(Money augend, Money addend) {
        this.augend = augend;
        this.addend = addend;
    }

    Money augend;
    Money addend;

    public Money reduce(Bank bank, String to) {
        int amount = this.augend.amount + this.addend.amount;
        return new Money(amount, to);
    }
}
