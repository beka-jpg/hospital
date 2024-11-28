package hospital;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Patient {
    private String fullName;
    private int age;
    private String userName;
    private String password;
    private BankAccount bankAccount;
    private Hospital hospital;
    private Schedule[] schedules;

    public Patient(
            String fullName,
            int age,
            String userName,
            String password,
            BankAccount bankAccount) {
        this.fullName = fullName;
        this.age = age;
        this.userName = userName;
        this.password = password;
        this.bankAccount = bankAccount;
    }

    public Patient(String fullName,  int age, String userName, String password ) {
        this.password = password;
        this.userName = userName;
        this.age = age;
        this.fullName = fullName;
    }



    public void addNewSchedule(Schedule schedule) {
        Schedule[] allSchedules = Arrays.copyOf(schedules, schedules.length + 1);
        allSchedules[allSchedules.length - 1] = schedule;
        schedules = allSchedules;
    }

    public String bookAppointment(Patient patient, LocalDateTime date, Speciality disease, boolean processed, Doctor doctor) {
        doctor.addNewSchedule(this, date, disease,  processed);
        return "Запись успешно создан ! Ваш врач " + doctor.getFullName() + " " + "Будет ждать вас в " + date;
    }

    public String cancelAppointment(Schedule schedule) {
        int counter = 0;
        int index = 0;
        boolean found = false;
        Schedule[] newArr = new Schedule[counter];

        for (int i = 0; i < schedules.length; i++) {
            if (schedules[i].equals(schedule)) {
                found = true;
                continue;
            }
            if (found) {
                i--;
                newArr[i] = schedules[i];
            } else {
                newArr[i] = schedules[i];
            }

        }
        schedules = newArr;
        return "Запись успешно отменился";
    }

    public String reschedule(LocalDateTime localDateTime, LocalDateTime newDateTime) {
        for (Schedule schedule : schedules) {
            if (schedule.getDate().equals(localDateTime)) {
                schedule.setDate(newDateTime);
            }
        }
        return "Успешно перенесли запись";
    }

    public String changeDoctor(
            Doctor oldDoctor,
            Doctor newDoctor,
            LocalDateTime localDateTime,
            Schedule schedule){
        oldDoctor.cancelSchedule(this.fullName,localDateTime);
        newDoctor.addNewSchedule(this,localDateTime, schedule.getDisease(), false);
        return "Успешно сменили доктора  " + newDoctor.getFullName() + " " + "Будет ждать вас в " + localDateTime;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Schedule[] getSchedules() {
        return schedules;
    }

    public void setSchedules(Schedule[] schedules) {
        this.schedules = schedules;
    }


    @Override
    public String toString() {
        return "Patient{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", bankAccount=" + bankAccount +
                ", hospital=" + hospital +
                ", schedules=" + Arrays.toString(schedules) +
                '}';
    }
}
