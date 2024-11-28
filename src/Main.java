import hospital.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Hospital hospital = new Hospital();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        hospital.setAddress("проспект мира 57");
        hospital.setName("Hospital");
        hospital.setEmailDoctors("inf@gmail.com");

        Speciality[] specialities = {
                new Speciality("Кардиология", 1200),
                new Speciality("Неврология", 1000),
                new Speciality("Офтальмология", 900),
                new Speciality("Онкология", 1300),
                new Speciality("Педиатрия", 800),
                new Speciality("Хирургия", 1500),
                new Speciality("Травматология", 1100),
                new Speciality("Гастроэнтерология", 950),
                new Speciality("Дерматология", 850),
                new Speciality("Эндокринология", 1200)
        };
        hospital.setSpecialities(specialities);

        Doctor[] doctors = {
                new Doctor("Иван Иванов", specialities[0], 10, new Schedule[1], "ivan_01", "pass123", 3000, null),
                new Doctor("Анна Смирнова", specialities[1], 8, new Schedule[1], "anna_02", "pass456", 2800, null),
                new Doctor("Олег Петров", specialities[2], 15, new Schedule[1], "oleg_03", "pass789", 3500, null),
                new Doctor("Мария Кузнецова", specialities[3], 12, new Schedule[1], "maria_04", "pass321", 4000, null),
                new Doctor("Сергей Сидоров", specialities[4], 5, new Schedule[1], "sergey_05", "pass654", 2200, null),
                new Doctor("Елена Орлова", specialities[5], 20, new Schedule[1], "elena_06", "pass987", 5000, null),
                new Doctor("Алексей Павлов", specialities[6], 9, new Schedule[1], "alexey_07", "pass111", 3100, null),
                new Doctor("Ирина Васильева", specialities[7], 6, new Schedule[1], "irina_08", "pass222", 2500, null),
                new Doctor("Дмитрий Новиков", specialities[8], 7, new Schedule[1], "dmitry_09", "pass333", 2700, null),
                new Doctor("Ольга Морозова", specialities[9], 10, new Schedule[1], "olga_10", "pass444", 2900, null)
        };
        hospital.setDoctors(doctors);

        Patient[] patients = {
                new Patient("Дмитрий Соколов", 25, "dmitry01", "pass01"),
                new Patient("Екатерина Белова", 30, "ekaterina02", "pass02"),
                new Patient("Максим Орлов", 40, "maxim03", "pass03"),
                new Patient("Ольга Павлова", 22, "olga04", "pass04"),
                new Patient("Алексей Иванов", 35, "alexey05", "pass05")
        };


        System.out.println(Arrays.toString(hospital.getDoctors()));
        System.out.println(Arrays.toString(patients));

        Random random = new Random();
        for (Patient patient : patients) {
            patient.setHospital(hospital);
            Doctor assignedDoctor = doctors[random.nextInt(doctors.length)];
            LocalDateTime appointmentTime = LocalDateTime.now().plusDays(random.nextInt(7));
//
            Schedule schedule = new Schedule(patient, appointmentTime, assignedDoctor.getSpeciality(), false);

            patient.setSchedules(new Schedule[]{schedule});
            assignedDoctor.setSchedules(new Schedule[]{schedule});
        }

        System.out.println(Arrays.toString(hospital.getDoctors()));
        System.out.println(Arrays.toString(patients));
        System.out.println(patients);

//        --------------------------------------------------------------------------------------------------------------
        boolean isTrue = true;

        do {
            firstMenu();
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    isTrue = false;
                    String[] dataAsDoctor = signUp();
                    System.out.println(Arrays.toString(dataAsDoctor));

                    Doctor yourProfileDoc = checkingProfileDoctor(dataAsDoctor, hospital.getDoctors());
                    System.out.println(yourProfileDoc);

                    break;


                case 2:
                    String[] dataAsPatient = signUp();
                    System.out.println(Arrays.toString(dataAsPatient));

                    Patient yourProfilePat = checkingProfilePatient(dataAsPatient, patients);
                    System.out.println(yourProfilePat);

                    isTrue = false;
                    break;


                case 3:
                    menuAsDirector();
                    isTrue = false;
                    break;

            }

        } while (isTrue);






    }


    public static void firstMenu() {
        System.out.println("""
                1. Войти как врач
                2. Войти как пациент
                3. Войти как директор
                """);
    }

    public static void menuAsDoctor () {
        System.out.println("""
                1.Посмотреть все записи
                2.Посмотреть записи по дате
                3.Создать запись на прием
                4.Отменить запись 
                5.Перенести запись 
                6. Вызвать данные про карту 
                0. Назад 
                """);
    }

    public static void menuAsPatient () {
        System.out.println("""
                1. Записаться к врачу
                2. Отмена записи
                3. Просмотр записи 
                4. Перенести запись 
                5. Смена врачи
                6. Вызвать данные про карту 
                0. Назад
                """);
    }

    public static void menuAsDirector () {
        System.out.println("""
                1.Вывод данные больницы
                2.Вывод докторов по спецу
                3.Вывод докторов по ФИО
                4.Кол-во докторо и их пациентов 
                5.Вывод всех записей врача 
                6.Уволить доктороа
                7.Добавить доктора
                8.Отредоктировать данные врача
                9.Начисление зарплаты
                0.Назад
                """);
    }

    public static void menuBank() {
        System.out.println("""
                1.Просмотр баланса
                2.Пополнение баланса
                3.Вывод средства
                4.Перевод по карте 
                0. Назад
                """);
    }

    public static String[] signUp () {
        System.out.println("Введите фио");

        scanner.nextLine();
        String fullName = scanner.nextLine();

        System.out.println("Введите логин");
        String userName = scanner.nextLine();

        System.out.println("Введите пароль");
        String password = scanner.nextLine();

        return new String[]{
                fullName, userName, password
        };
    }

    public static Doctor checkingProfileDoctor(String[] inputData, Doctor[] doctors){
        for (Doctor doctor : doctors) {
            if (inputData[0].equalsIgnoreCase(doctor.getFullName())) {
                if(inputData[1].equals(doctor.getUserName())) {
                    if(inputData[2].equals(doctor.getPassword())) {
                        System.out.println("Вы успешно зашли как:  " + doctor.getFullName());
                        return doctor;
                    }
                }
            }
        }
        System.out.println("Something is incorrect try again");
        return null;
    }

    public static Patient checkingProfilePatient(String[] inputData, Patient[] patients){
        for (Patient patient : patients) {
            if (inputData[0].equalsIgnoreCase(patient.getFullName())) {
                if(inputData[1].equals(patient.getUserName())) {
                    if(inputData[2].equals(patient.getPassword())) {
                        System.out.println("Вы успешно зашли как:  " + patient.getFullName());
                        return patient;
                    }
                }
            }
        }
        System.out.println("Something is incorrect try again");
        return null;
    }


//    public static  BankAccount createBankAccount(Doctor doctor, Patient patient) {
//        Random random = new Random();
//        int cardNumber = random.ints().sum();
//        System.out.println(cardNumber);
//        doctor.getBankAccount().setCardNumber();
//    }

}