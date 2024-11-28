package hospital;

import java.time.LocalDateTime;

public class Schedule {
    private Patient patient;
    private LocalDateTime date;
    private Speciality disease;
    private boolean processed;

    public Schedule(Patient patient, LocalDateTime date, Speciality disease, boolean processed) {
        this.patient = patient;
        this.date = date;
        this.disease = disease;
        this.processed = processed;
    }


    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Speciality getDisease() {
        return disease;
    }

    public void setDisease(Speciality disease) {
        this.disease = disease;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }


    @Override
    public String toString() {
        return "Schedule{" +
                "patient=" + patient +
                ", date=" + date +
                ", disease='" + disease + '\'' +
                ", processed=" + processed +
                '}';
    }
}
