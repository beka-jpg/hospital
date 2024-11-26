package hospitalPackage;

public class Patient {
    private String fullName;
    private int age;
    private String username;
    private String password;
    private BankAccount bankAccount;

    public Patient(String fullName, int age, BankAccount bankAccount) {
        this.fullName = fullName;
        this.age = age;
        this.bankAccount = bankAccount;
    }

    public void createAcc (String password){
        this.username = this.fullName + "03f8";
        this.password = password;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", bankAccount=" + bankAccount +
                '}';
    }



    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    // Методы
    public void bookAppointment(Schedule schedule, Doctor doctor) {
        doctor.addSchedule(schedule);
        System.out.println("Запись на прием добавлена для пациента " + fullName);
    }

    public void cancelAppointment(Schedule schedule, Doctor doctor) {
        doctor.getSchedules().remove(schedule);
        System.out.println("Запись отменена для пациента " + fullName);
    }
}

