package hospital;

public class BankAccount {
    private String cardNumber;
    private int cvv;
    private String fullName;
    private double balance;

    public BankAccount(String cardNumber, int cvv, String fullName, double balance) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.fullName = fullName;
        this.balance = balance;
    }

    public BankAccount() {
    }


    public String deposit (double amount){
        if (amount > 0) {
            balance += amount;
        }
        return "Баланс успешно пополнен на " + amount;
    }
    public String withdraw(double amount, int cvv) {
        if(cvv == this.cvv && balance >= amount){
            this.balance -= amount;
        }else {
            return "Недостаточно средств либо неправильный cvv";
        }
        return "Успешно сняты деньги " + amount ;
    }


    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "cardNumber='" + cardNumber + '\'' +
                ", cvv=" + cvv +
                ", fullName='" + fullName + '\'' +
                ", balance=" + balance +
                '}';
    }
}
