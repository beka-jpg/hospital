package hospital;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class Doctor {
    private String fullName;
    private int experience;
    private String userName;
    private String password;
    private double salary ;
    private Speciality speciality;
    private Schedule[] schedules;
    private BankAccount bankAccount;


    public Doctor(
            String fullName,
            Speciality speciality,
            int experience,
            Schedule[] schedules,
            String userName,
            String password,
            double salary,
            BankAccount bankAccount) {
        this.fullName = fullName;
        this.experience = experience;
        this.userName = userName;
        this.password = password;
        this.salary = salary;
        this.speciality = speciality;
        this.schedules = schedules;
        this.bankAccount = bankAccount;
    }

    public Doctor() {
    }

    public String reschedule(String fio, LocalDateTime localDateTime, LocalDateTime newDateTime){
        for (Schedule schedule : schedules) {
            if(schedule.getDate().equals(localDateTime) && schedule.getPatient().getFullName().equalsIgnoreCase(fio)){
                schedule.setDate(newDateTime);
            }
        }
        return "Успешно перенесли запись";
    }

    public String cancelSchedule(String fullName, LocalDateTime localDateTime){
        Schedule[] allSchedules = Arrays.copyOf(schedules, schedules.length-1);
        boolean found = false;
        for (int i = 0; i < schedules.length; i++) {
            if(schedules[i].getDate().equals(localDateTime) && schedules[i].getPatient().getFullName().equalsIgnoreCase(fullName)){
                found = true;
                continue;
            }

            if(!found){
                allSchedules[i] =schedules[i];
            }else {
                i--;
                allSchedules[i] = schedules[i];
            }
        }
        schedules = allSchedules;
        return "Запись успешно отменена!";
    }

        public String addNewSchedule(Patient patient, LocalDateTime localDateTime, Speciality disease, boolean processed){
        Schedule schedule = new Schedule(patient, localDateTime, disease, processed);
        Schedule[] allSchedules = Arrays.copyOf(schedules, schedules.length+1);
        allSchedules[allSchedules.length -1] = schedule;
        schedules = allSchedules;
        patient.addNewSchedule(schedule);
        return "Успешно добавлена запись!";
    }

    public Schedule[] getAllSchedulesByDate(LocalDate date) {
        int counter=0;
        for (Schedule schedule : schedules) {
            if(schedule.getDate().toLocalDate().equals(date)){
                counter++;
            }
        }
        Schedule[] allSchedules = new Schedule[counter];
        int index =0;
        for (Schedule schedule : schedules) {
            if(schedule.getDate().toLocalDate().equals(date)){
                allSchedules[index] = schedule;
                index++;
            }
        }
        return allSchedules;
    }

//    public Schedule[] getAllSchedules(Boolean processed) {
//        int counter=0;
//        int index=0;
//        if(processed) {
//            for (int i = 0; i < schedules.length; i++) {
//                if(schedules[i].isProcessed()){
//                    counter++;
//                }
//            }
//            Schedule[] allSchedules = new Schedule[counter];
//            for (int i = 0; i < schedules.length; i++) {
//                if(schedules[i].isProcessed()){
//                    allSchedules[index]=schedules[i];
//                    index++;
//                }
//            }
//            return allSchedules;
//        }else if(!processed){
//            for (int i = 0; i < schedules.length; i++) {
//                if(!schedules[i].isProcessed()){
//                    counter++;
//                }
//            }
//            Schedule[] allSchedules = new Schedule[counter];
//            for (int i = 0; i < schedules.length; i++) {
//                if(!schedules[i].isProcessed()){
//                    allSchedules[index]=schedules[i];
//                    index++;
//                }
//            }
//            return allSchedules;
//        }
//        return schedules;
//    }

    public Schedule[] getAllSchedules () {
        int counter = 0 ;
        int index = 0 ;
        for (int i = 0 ; i < schedules.length; i++){
            if (! schedules[i].equals(null)) {
                if (schedules[i].isProcessed()) {

                    if (schedules[i].isProcessed()) {
                        counter++;
                    }

                    Schedule[] allSchedules = new Schedule[counter];
                    for (int j = 0; j < schedules.length; j++) {
                        if (schedules[j].isProcessed()) {
                            allSchedules[index] = schedules[j];
                            index++;
                        }
                    }
                    return allSchedules;
                } else if (!schedules[i].isProcessed()) {
                    for (int k = 0; k < schedules.length; k++) {
                        if (!schedules[k].isProcessed()) {
                            counter++;
                        }
                    }
                    Schedule[] allSchedules = new Schedule[counter];
                    for (int l = 0; l < schedules.length; l++) {
                        if (!schedules[l].isProcessed()) {
                            allSchedules[index] = schedules[l];
                            index++;
                        }
                    }
                    return allSchedules;
                }
            }
        }
        return schedules;
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public Schedule[] getSchedules() {
        return schedules;
    }

    public void setSchedules(Schedule[] schedules) {
        this.schedules = schedules;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "fullName='" + fullName + '\'' +
                ", experience=" + experience +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", salary=" + salary +
                ", speciality=" + speciality +
                ", schedules=" + Arrays.toString(schedules) +
                ", bankAccount=" + bankAccount +
                '}';
    }
}
