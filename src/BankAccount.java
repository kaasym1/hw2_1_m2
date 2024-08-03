public class BankAccount {
    private double amount;

    public double getAmount() {
        return amount;
    }

    public void deposit(double sum) {
        amount += sum;
    }

    public void withdraw(int sum) throws LimitException{
        if (sum > amount){
            throw new LimitException("Запрашиваемая сумма на снятие больше," +
                    "Чем остаток на вашем счете. На вашем счете осталось: " + this.amount +
                    " сом. " + this.amount );
        }
        amount -= sum;
    }
}