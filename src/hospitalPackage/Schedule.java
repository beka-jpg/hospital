package hospitalPackage;
import java.time.LocalDate;

public class Schedule {
    private Patient patient;
    private LocalDate date;
    private String disease;

    public Schedule(Patient patient, LocalDate date, String disease) {
        this.patient = patient;
        this.date = date;
        this.disease = disease;
    }




    @Override
    public String toString() {
        return
                "Запись: Пациент "
                + patient.getFullName()
                + ", Дата: " + date + ", Диагноз: " + disease;
    }
}

