package hospitalPackage;

public class Speciality {
    private String name;
    private double price;


    public Speciality(String name, double price) {
        this.name = name;
        this.price = price;
    }


    @Override
    public String toString() {
        return "Speciality{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
