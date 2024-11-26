package hospitalPackage;

public class BankAccount {
    private String cardNumber;
    private String cvv;
    private String fullName;
    private double balance;


    public BankAccount(String cardNumber, String cvv, String fullName, double balance) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.fullName = fullName;
        this.balance = balance;
    }


    @Override
    public String toString() {
        return "BankAccount{" +
                "cardNumber='" + cardNumber + '\'' +
                ", cvv='" + cvv + '\'' +
                ", fullName='" + fullName + '\'' +
                ", balance=" + balance +
                '}';
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Баланс пополнен на " + amount);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Снятие средств на сумму: " + amount);
        } else {
            System.out.println("Недостаточно средств!");
        }
    }

    public void transfer(BankAccount target, double amount) {
        if (balance >= amount) {
            this.withdraw(amount);
            target.deposit(amount);
            System.out.println("Перевод на " + amount + " выполнен.");
        } else {
            System.out.println("Перевод невозможен: недостаточно средств.");
        }
    }
}
