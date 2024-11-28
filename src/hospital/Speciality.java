package hospital;

public class Speciality {
    private String speciality;
    private int price;

    public Speciality(String speciality, int price) {
        this.speciality = speciality;
        this.price = price;
    }







    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Speciality{" +
                "speciality='" + speciality + '\'' +
                ", price=" + price +
                '}';
    }
}
