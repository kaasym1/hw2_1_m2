public class Main {
    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount();

        bankAccount.deposit(15000);

        System.out.println("У вас на счете: " + bankAccount.getAmount() + " сом. ");

        while (true) {
            try {
                bankAccount.withdraw(6000);
                System.out.println("Снять 6000.0 сом");
                System.out.println("Указанная вами сумма успешно снята со счета! \nУ вас на счете: " +
                        bankAccount.getAmount() + " сом. ");
            } catch (LimitException e) {
                System.out.println(e.getMessage());
                try {
                    bankAccount.withdraw((int) bankAccount.getAmount());
                } catch (LimitException ex) {
                    throw new RuntimeException(ex);
                }
                System.out.println("Снять оставшуюсю сумму");
                System.out.println("Указанная вами запрос успешно снята со счета! \nУ вас на счете:");
                System.out.println("Остаток на счете: " + bankAccount.getAmount() + " сом. ");
                break;
            }
        }
    }
}