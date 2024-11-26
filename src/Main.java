import hospitalPackage.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Random r = new Random();
    public static void main(String[] args) {

        Hospital hospital = new Hospital("Городская больница", "ул. Мира, 10", "info@hospital.com");


        ArrayList<Speciality> specialities = new ArrayList<>();
        specialities.add(new Speciality("Кардиология", 1500));
        specialities.add(new Speciality("Терапия", 1000));
        specialities.add(new Speciality("Неврология", 1800));
        specialities.add(new Speciality("Офтальмология", 1200));
        specialities.add(new Speciality("Дерматология", 1300));


        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Иван Иванов", specialities.get(0).getName(), 10, 3000, new BankAccount("1234567812345678", "123", "Иван Иванов", 10000)));
        doctors.add(new Doctor("Петр Петров", specialities.get(1).getName(), 5, 2000, new BankAccount("2345678923456789", "234", "Петр Петров", 8000)));
        doctors.add(new Doctor("Анна Смирнова", specialities.get(2).getName(), 8, 2500, new BankAccount("3456789034567890", "345", "Анна Смирнова", 12000)));
        doctors.add(new Doctor("Сергей Сергеев", specialities.get(3).getName(), 12, 3500, new BankAccount("4567890145678901", "456", "Сергей Сергеев", 15000)));
        doctors.add(new Doctor("Мария Иванова", specialities.get(4).getName(), 7, 2200, new BankAccount("5678901256789012", "567", "Мария Иванова", 9000)));


        for (Doctor doctor : doctors) {
            int random = r.nextInt(100, 10000000);
            hospital.addDoctor(doctor);
            doctor.createAcc("Crempor" + random);
        }


        ArrayList<Patient> patients = new ArrayList<>();
        patients.add(new Patient("Анна Смирнова", 30, new BankAccount("8765432187654321", "321", "Анна Смирнова", 5000)));
        patients.add(new Patient("Олег Васильев", 45, new BankAccount("7654321076543210", "432", "Олег Васильев", 3000)));
        patients.add(new Patient("Елена Кузнецова", 25, new BankAccount("6543210987654321", "543", "Елена Кузнецова", 7000)));


        Schedule appointment1 = new Schedule(patients.get(0), LocalDate.of(2024, 12, 1), "Боли в сердце");
        Schedule appointment2 = new Schedule(patients.get(1), LocalDate.of(2024, 12, 2), "Общий осмотр");
        Schedule appointment3 = new Schedule(patients.get(2), LocalDate.of(2024, 12, 3), "Проблемы со зрением");


        patients.get(0).bookAppointment(appointment1, doctors.get(0)); // Анна к Ивану Иванову
        patients.get(1).bookAppointment(appointment2, doctors.get(1)); // Олег к Петру Петрову
        patients.get(2).bookAppointment(appointment3, doctors.get(3)); // Елена к Сергею Сергееву

        for (Patient patient : patients) {
            int random = r.nextInt(100, 10000000);
            patient.createAcc("ets" + random);
        }


        System.out.println("Список докторов в больнице:");
//        hospital.listDoctors();


        System.out.println("Записи у докторов:");
        for (Doctor doctor : doctors) {
            System.out.println("Доктор " + doctor.getFullName() + ":");
            doctor.viewSchedules();
            System.out.println();
        }


//        System.out.println("Отмена записи пациента:");
//        patients.get(1).cancelAppointment(appointment2, doctors.get(1));
//        System.out.println();


//        System.out.println("Обновленные записи:");
//        for (Doctor doctor : doctors) {
//            System.out.println("Доктор " + doctor.getFullName() + ":");
//            doctor.viewSchedules();
//            System.out.println();
//        }


        System.out.println("Начисление зарплаты:");
        for (Doctor doctor : doctors) {
            doctor.receiveSalary();
        }


//        System.out.println("\nБаланс банковских счетов докторов:");
//        for (Doctor doctor : doctors) {
//            System.out.println("Доктор " + doctor.getFullName() + " - Баланс: " + doctor.getBankAccount().getBalance());
//        }




    }
}

