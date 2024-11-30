import hospital.*;

import javax.print.Doc;
import java.time.LocalDate;
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
        hospital.setEmail("inf@gmail.com");

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



//        Random random = new Random();
//        for (Patient patient : patients) {
//            patient.setHospital(hospital);
//            Doctor assignedDoctor = doctors[random.nextInt(doctors.length)];
//            LocalDateTime appointmentTime = LocalDateTime.now().plusDays(random.nextInt(7));
////
//            Schedule schedule = new Schedule(patient, appointmentTime, assignedDoctor.getSpeciality(), false);
//
//            patient.setSchedules(new Schedule[]{schedule});
//            assignedDoctor.setSchedules(new Schedule[]{schedule});
//        }

        Random random = new Random();
        for (Patient patient : patients) {
            Doctor assignedDoctor = doctors[random.nextInt(doctors.length)];
            LocalDateTime appointmentTime = LocalDateTime.now().plusDays(random.nextInt(7));

            Schedule schedule = new Schedule(patient, appointmentTime, assignedDoctor.getSpeciality(), false);
            patient.setSchedules(new Schedule[]{schedule});
            assignedDoctor.setSchedules(new Schedule[]{schedule});
        }

//        --------------------------------------------------------------------------------------------------------------
        boolean isTrue = true;

        do {



            firstMenu();
            int choice = scanner.nextInt();
            switch (choice){
                case 1:

                    String[] dataAsDoctor = signUp(); // функиця для ввода имени, логин и пароль

                    boolean isTrueDataDoc = checkingProfileDoctor(dataAsDoctor, hospital.getDoctors());// проверка этих переменных
                    Doctor yourProileDoc = null;


                    if (isTrueDataDoc) {

                        for (int i = 0; i < doctors.length; i++) {
                            if (doctors[i].getFullName().equals(dataAsDoctor[0])) {
                                yourProileDoc = doctors[i];
                            }
                        }

                        System.out.println(yourProileDoc);

                        menuAsDoctor();
                        int choiceDoctor = scanner.nextInt();

                        isTrue = false;
                        boolean isTrueFirst = false;

                        do {
                            switch (choiceDoctor) {
                                case 1:
                                    Schedule[] scheduleAll = yourProileDoc.getAllSchedules();
                                    System.out.println(Arrays.toString(scheduleAll));
                                    break;
                                case 2:
                                    System.out.println("Введите дату по которому хотите посмотреть ");
                                    int year = scanner.nextInt();
                                    int month = scanner.nextInt();
                                    int day = scanner.nextInt();

                                    LocalDate data = LocalDate.of(year, month, day);
                                    Schedule[] allScheduleByData = yourProileDoc.getAllSchedulesByDate(data);
                                    System.out.println(allScheduleByData);
                                    break;
                                case 3:
                                    System.out.println("создать запись на прием");
                                    System.out.println("Введите данные пациента");
                                    String fullName = scanner.nextLine();
                                    int age = scanner.nextInt();
                                    Patient newPatient = new Patient(fullName, age);

                                    System.out.println("Дата на которую хотите создать запись ");
                                    int yearForNewSh = scanner.nextInt();
                                    int monthForNewSh = scanner.nextInt();
                                    int dayForNewSh = scanner.nextInt();
                                    LocalDateTime dataForNewSh = LocalDateTime.of(
                                            yearForNewSh,
                                            monthForNewSh,
                                            dayForNewSh,
                                            LocalDateTime.now().getHour() + random.nextInt(12),
                                            LocalDateTime.now().getMinute() + random.nextInt(60));

                                    yourProileDoc.addNewSchedule(
                                            newPatient,
                                            dataForNewSh,
                                            yourProileDoc.getSpeciality(),
                                            false);
                                    break;
                                case 4:
                                    System.out.println("Введите фио пациента");
                                    String fullNameCancel = scanner.nextLine();


                                    System.out.println("Введите время записи");
                                    int yearCan = scanner.nextInt();
                                    int monthCan = scanner.nextInt();
                                    int dayCan = scanner.nextInt();
                                    int hourCan = scanner.nextInt();
                                    int miniteCan = scanner.nextInt();
                                    LocalDateTime dateCan = LocalDateTime.of(yearCan, monthCan, dayCan, hourCan, miniteCan);

                                    String cancel = yourProileDoc.cancelSchedule(fullNameCancel, dateCan);
                                    System.out.println(cancel);
                                    break;
                                case 5:
                                    System.out.println("Введите фио паицента которого хотите перенести");
                                    String fullNamePatinet = scanner.nextLine();

                                    System.out.println("Введите время записи");
                                    int yearOld = scanner.nextInt();
                                    int monthOld = scanner.nextInt();
                                    int dayOld = scanner.nextInt();
                                    int hourOld = scanner.nextInt();
                                    int miniteOld = scanner.nextInt();
                                    LocalDateTime dateOld = LocalDateTime.of(yearOld, monthOld, dayOld, hourOld, miniteOld);

                                    System.out.println("Введите дату на которую хотите перенести запись");
                                    int yearNew = scanner.nextInt();
                                    int monthNew = scanner.nextInt();
                                    int dayNew = scanner.nextInt();
                                    int hourNew = scanner.nextInt();
                                    int miniteNew = scanner.nextInt();
                                    LocalDateTime dateNew = LocalDateTime.of(yearNew, monthNew, dayNew, hourNew, miniteNew);

                                    yourProileDoc.reschedule(fullNamePatinet, dateOld, dateNew);
                                    break;
    
                            }
                        } while(isTrueFirst);

                    }

                    break;


                case 2:
                    String[] dataAsPatient = signUp();
                    Patient yourProilePat = null;
                    boolean isTrueDataPat = checkingProfilePatient(dataAsPatient, patients);

                    if (isTrueDataPat) {

                        for (int i = 0; i < patients.length; i++) {
                            if (patients[i].getFullName().equals(dataAsPatient[0])) {
                                yourProilePat = patients[i];
                            }
                        }

                        menuAsPatient();

                        int choicePat = scanner.nextInt();

                        isTrue = false;
                        switch (choicePat) {
                            case 1:
                                System.out.println("Введите дату на которую хотите записаться");
                                int year = scanner.nextInt();
                                int month = scanner.nextInt();
                                int day = scanner.nextInt();
                                int hour = scanner.nextInt();
                                int minute = scanner.nextInt();
                                LocalDateTime date = LocalDateTime.of(year,month, day,hour, minute);

                                System.out.println("Напишите болезнь в индексе");
                                System.out.println(Arrays.toString(specialities));
                                int speciality = scanner.nextInt();

                                yourProilePat.bookAppointment(
                                        yourProilePat,
                                        date,
                                        specialities[speciality],
                                        false,
                                        doctors[random.nextInt(doctors.length)]);
                                break;
                            case 2:
                                System.out.println("Выберите запись которую хотите отменть ");
                                Schedule[] allSchedule = yourProilePat.getSchedules();
                                System.out.println();
                                int infdexOfSchedule = scanner.nextInt();
                                yourProilePat.cancelAppointment(allSchedule[infdexOfSchedule]);
                                break;
                            case 3:
                                break;
                            case 4:
                                System.out.println("Введите время записи");
                                int yearOld = scanner.nextInt();
                                int monthOld = scanner.nextInt();
                                int dayOld = scanner.nextInt();
                                int hourOld = scanner.nextInt();
                                int miniteOld = scanner.nextInt();
                                LocalDateTime dateOld = LocalDateTime.of(yearOld, monthOld, dayOld, hourOld, miniteOld);

                                System.out.println("Введите дату на которую хотите перенести запись");
                                int yearNew = scanner.nextInt();
                                int monthNew = scanner.nextInt();
                                int dayNew = scanner.nextInt();
                                int hourNew = scanner.nextInt();
                                int miniteNew = scanner.nextInt();
                                LocalDateTime dateNew = LocalDateTime.of(yearNew, monthNew, dayNew, hourNew, miniteNew);

                                yourProilePat.reschedule(dateOld, dateNew);
                                break;
                            case 5:
                                System.out.println(Arrays.toString(doctors));
                                System.out.println("Выберите старую доктор");
                                int indexOldDoctor = scanner.nextInt();
                                Doctor oldDoctor =  doctors[indexOldDoctor];


                                System.out.println("Введите дату записи");
                                int yearSc = scanner.nextInt();
                                int monthSc = scanner.nextInt();
                                int daySc = scanner.nextInt();
                                int hourSc = scanner.nextInt();
                                int miniteSc = scanner.nextInt();
                                LocalDateTime dateSc = LocalDateTime.of(yearSc, monthSc, daySc, hourSc, miniteSc);


                                System.out.println(Arrays.toString(doctors));
                                System.out.println("Выберите старую доктор");
                                int indexNewDoctor = scanner.nextInt();
                                Doctor newDoctor =  doctors[indexNewDoctor];


                                Schedule[] schedule = yourProilePat.getSchedules();
                                System.out.println("Выбериет запись у котого хотите перенести врача");
                                int indexSchedule = scanner.nextInt();

                                String res = yourProilePat.changeDoctor(oldDoctor,newDoctor, dateSc,schedule[indexSchedule]);
                                System.out.println(res);
                                break;
                        }
                    }


                    break;


                case 3:
                    menuAsDirector();
                    int choiceDir = scanner.nextInt();
                    isTrue = false;
                    switch (choiceDir){
                        case 1:
                            System.out.println(hospital.getName());
                            System.out.println(hospital.getAddress());
                            System.out.println(hospital.getEmail());
                            break;
                        case 2:
                            System.out.println("Введите специализацию");
                            String speciality = scanner.nextLine();
                            hospital.getByAllSpecialities(speciality);
                            break;
                        case 3:
                            System.out.println("Введите фио");
                            String fullName = scanner.nextLine();
                            hospital.getDoctorByFullName(fullName);
                            break;
                        case 4:
                            String[] result = hospital.getDoctorsAndPatientsQuantity();
                            System.out.println(Arrays.toString(result));
                            break;
                        case 5:
                            System.out.println(Arrays.toString(doctors));
                            System.out.println("Выберите врача");
                            int choiceDoctor = scanner.nextInt();
                            Schedule[] resultSchedule =  hospital.getAllSchedulesDoctorByFullName(choiceDoctor);
                            System.out.println(resultSchedule);
                            break;
                        case 6:
                            System.out.println("Выберите врача");
                            int indexDeleted = scanner.nextInt();
                            String resultString = hospital.deleteDoctor(indexDeleted);
                            System.out.println(resultString);
                            break;
                        case 7:
                            System.out.println("ФИО");
                            String fullNameOfNewDoc = scanner.nextLine();
                            System.out.println(Arrays.toString(specialities));
                            System.out.println("Выберите специальность ");
                            int indexOf = scanner.nextInt();
                            System.out.println("опыт работы");
                            int experienct = scanner.nextInt();

                            System.out.println("Введите логин и пароль");
                            String userName = scanner.nextLine();
                            String password = scanner.nextLine();


                            System.out.println("Введите опыт работы");
                            int salary = scanner.nextInt();


                            Doctor newDoc = new Doctor(fullNameOfNewDoc, specialities[indexOf],experienct, new Schedule[0],  "user01", "passsss111", salary,null);
                            String resultAdd = hospital.addNewDoctor(newDoc);
                            System.out.println(resultAdd);

                            break;
                        case 8:
                            System.out.println(Arrays.toString(doctors));
                            System.out.println("Выбериет индекс");
                            int indexOfDoctor = scanner.nextInt();

                            System.out.println("Введите новую зп ");
                            int salaryNex = scanner.nextInt();


                            System.out.println("Введите специальность");
                            String specialityNew = scanner.nextLine();
                            String resultUpdate = hospital.updateDoctor(indexOfDoctor, salaryNex, specialityNew);
                            System.out.println(resultUpdate);
                            break;
                        case 9:
                            String resultSalary = hospital.transferSalary();
                            System.out.println(resultSalary);
                            break;

                    }

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

                """);
    }

    public static void menuAsPatient () {
        System.out.println("""
                1. Записаться к врачу
                2. Отмена записи
                3. Просмотр записи 
                4. Перенести запись 
                5. Смена врачи

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
                """);
    }

//    public static void menuBank() {
//        System.out.println("""
//                1.Просмотр баланса
//                2.Пополнение баланса
//                3.Вывод средства
//                4.Перевод по карте
//                0. Назад
//                """);
//    }

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

    public static Boolean checkingProfileDoctor(String[] inputData, Doctor[] doctors){
        for (Doctor doctor : doctors) {
            if (inputData[0].equalsIgnoreCase(doctor.getFullName())) {
                if(inputData[1].equals(doctor.getUserName())) {
                    if(inputData[2].equals(doctor.getPassword())) {
                        System.out.println("Вы успешно зашли как:  " + doctor.getFullName());
                        return true;
                    }
                }
            }
        }
        System.out.println("Something is incorrect try again");
        return false;
    }

    public static boolean  checkingProfilePatient(String[] inputData, Patient[] patients){
        for (Patient patient : patients) {
            if (inputData[0].equalsIgnoreCase(patient.getFullName())) {
                if(inputData[1].equals(patient.getUserName())) {
                    if(inputData[2].equals(patient.getPassword())) {
                        System.out.println("Вы успешно зашли как:  " + patient.getFullName());
                        return true;
                    }
                }
            }
        }
        System.out.println("Something is incorrect try again");
        return false;
    }


//    public static  BankAccount createBankAccount(Doctor doctor, Patient patient) {
//        Random random = new Random();
//        int cardNumber = random.ints().sum();
//        System.out.println(cardNumber);
//        doctor.getBankAccount().setCardNumber();
//    }

}