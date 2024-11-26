package hospitalPackage;

import java.util.ArrayList;

public class Doctor {
    private String fullName;
    private String speciality;
    private int experience;
    private ArrayList<Schedule> schedules;
    private String username;
    private String password;
    private double salary;
    private BankAccount bankAccount;


    public Doctor(
            String fullName,
            String speciality,
            int experience,
            double salary,
            BankAccount bankAccount) {
        this.fullName = fullName;
        this.speciality = speciality;
        this.experience = experience;
        this.schedules = new ArrayList<>();
        this.salary = salary;
        this.bankAccount = bankAccount;
    }

    public void createAcc (String password){
        this.username = this.fullName + "03f8";
        this.password = password;
    }


    @Override
    public String toString() {
        return "Doctor{" +
                "fullName='" + fullName + '\'' +
                ", speciality='" + speciality + '\'' +
                ", experience=" + experience +
                ", schedules=" + schedules +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salary=" + salary +
                ", bankAccount=" + bankAccount +
                '}';
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

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getFullName() {
        return fullName;
    }

    public ArrayList<Schedule> getSchedules() {
        return schedules;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public void setSchedules(ArrayList<Schedule> schedules) {
        this.schedules = schedules;
    }

    public void addSchedule(Schedule schedule) {
        schedules.add(schedule);
    }

    public void viewSchedules() {
        for (Schedule s : schedules) {
            System.out.println(s);
        }
    }

    public void receiveSalary() {
        bankAccount.deposit(salary);
        System.out.println("Зарплата " + salary + " начислена доктору " + fullName);
    }
}
