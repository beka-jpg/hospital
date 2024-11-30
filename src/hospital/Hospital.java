package hospital;

import javax.print.Doc;
import java.security.PublicKey;
import java.util.Arrays;

public class Hospital {
    private String name;
    private String address;
    private String email;
    private Doctor[] doctors;
    private Speciality[] specialities;
    private BankAccount bankAccount;


    public Hospital(
            String name,
            String address,
            String email,
            Doctor[] doctors,
            Speciality[] specialities,
            BankAccount bankAccount) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.doctors = doctors;
        this.specialities = specialities;
        this.bankAccount = bankAccount;
    }

    public Hospital() {

    }

    public Doctor[] getByAllSpecialities (String speciality) {
        int counter = 0 ;
        for (int i = 0 ; i < doctors.length ; i++) {
            if (doctors[i].getSpeciality().getSpeciality().equalsIgnoreCase(speciality)) {
                counter++;
            }
        }
        Doctor[] newArrDoctors = new Doctor[counter];
        int index = 0 ;

        for (int i = 0 ; i < doctors.length ; i++) {
            if (doctors[i].getSpeciality().getSpeciality().equalsIgnoreCase(speciality)) {
                newArrDoctors[index] = doctors[i];
                index++;
            }
        }
        return newArrDoctors;
    }

    public Doctor getDoctorByFullName (String fullName) {
        for (Doctor doctor : doctors) {
            if (doctor.getFullName().equalsIgnoreCase(fullName)) {
                return doctor;
            }
        }
        return null;
    }

    public String[] getDoctorsAndPatientsQuantity () {
        int doctorsQuantity = doctors.length;;
        int patientQuantity = 0 ;
        for (Doctor doctor : doctors) {
            patientQuantity += doctor.getSchedules().length;
        }
        return new String[] {
                "Количество докторов больницы :" + doctorsQuantity,
                "Количество пациентов больницы :" + patientQuantity
        };
    }

    public Schedule[] getAllSchedulesDoctorByFullName(int index) {
        for (int i = 0; i < doctors.length; i++) {
            if (i == index) {
                return doctors[i].getSchedules();
            }
        }
        return null;
    }

    public String deleteDoctor(int doctorIndex) {
        Doctor[] newDoctors = new Doctor[doctors.length - 1];
        boolean found = false;
        for (int i = 0; i < doctors.length; i++) {
            if (i == doctorIndex) {
                found = true;
                continue;
            }
            if (found) {
                i--;
                newDoctors[i] = doctors[i];
            } else {
                newDoctors[i] = doctors[i];
            }
        }
        doctors = newDoctors;
        return "Успешно удален доктор!";
    }

    public String addNewDoctor(Doctor doctor) {
        Doctor[] newDoctors = Arrays.copyOf(doctors, doctors.length + 1);
        newDoctors[newDoctors.length - 1] = doctor;
        doctors = newDoctors;
        return "Успешно добавили доктора!";
    }
    public String updateDoctor(int doctorIndex, int salary, String speciality){
        Doctor doctor = doctors[doctorIndex];
        doctor.setSalary(salary);
        if(speciality != null) {
            for (Speciality speciality1 : specialities) {
                if (speciality1.getSpeciality().equalsIgnoreCase(speciality)) {
                    doctor.setSpeciality(speciality1);
                }
            }
        }
        doctors[doctorIndex] = doctor;
        return "Успешно обновлен доктор по фио: " + doctor.getFullName();
    }

    public String transferSalary(){
        for (int i = 0; i < doctors.length; i++) {
            doctors[i].getBankAccount().deposit(doctors[i].getSalary());
            System.out.println(bankAccount.withdraw(doctors[i].getSalary(), this.bankAccount.getCvv()));
        }
        return "Успешно начислены зарплаты!";
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail (String emailDoctors) {
        this.email = emailDoctors;
    }

    public Doctor[] getDoctors() {
        return doctors;
    }

    public void setDoctors(Doctor[] doctors) {
        this.doctors = doctors;
    }

    public Speciality[] getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Speciality[] specialities) {
        this.specialities = specialities;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }


    @Override
    public String toString() {
        return "Hospital{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", emailDoctors='" + email + '\'' +
                ", doctors=" + Arrays.toString(doctors) +
                ", specialities=" + Arrays.toString(specialities) +
                ", bankAccount=" + bankAccount +
                '}';
    }
}
