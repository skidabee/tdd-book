public class Sum implements Expression {

    Sum(Expression augend, Expression addend) {
        this.augend = augend;
        this.addend = addend;
    }

    Expression augend;
    Expression addend;

    public Money reduce(Bank bank, String to) {
        int amount = this.augend.reduce(bank, to).amount + this.addend.reduce(bank, to).amount;
        return new Money(amount, to);
    }

    @Override
    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }

    @Override
    public Expression times(int multiplier){
        return new Sum(augend.times(multiplier), addend.times(multiplier));
    }
}
