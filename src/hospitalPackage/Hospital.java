package hospitalPackage;

import java.util.ArrayList;

public class Hospital {
    private String name;
    private String address;
    private String emailAddress;
    private ArrayList<Doctor> doctors;
    private ArrayList<Patient> patients;

    public Hospital(String name, String address, String emailAddress) {
        this.name = name;
        this.address = address;
        this.emailAddress = emailAddress;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", doctors=" + doctors +
                ", patients=" + patients +
                '}';
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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(ArrayList<Doctor> doctors) {
        this.doctors = doctors;
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
        System.out.println("Доктор добавлен: " + doctor.getFullName());
    }

    public void removeDoctor(String fullName) {
        doctors.removeIf(d -> d.getFullName().equals(fullName));
        System.out.println("Доктор удален: " + fullName);
    }

    public void listDoctors() {
        for (Doctor doctor : doctors) {
            System.out.println(doctor.getFullName() + " - " + doctor.getSpeciality());
        }
    }
}
