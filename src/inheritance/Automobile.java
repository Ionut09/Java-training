package inheritance;

import java.util.Objects;

import static java.util.Objects.hash;

public class Automobile extends Vehicle {

    private String engine;

    public Automobile(String engine, String brand, String fuel) {
        super(brand, 4, fuel);
        this.engine = engine;
    }

    @Override
    public void moves() {
//        super.moves();
        System.out.println("Automobile moves");
    }

    public void startEngine() {
        System.out.println("Starting engine...");
    }

    @Override
    public String toString() {
        return "Automobile{" +
                "brand='" + getBrand() + '\'' +
                ", wheels=" + getWheels() +
                ", fuel='" + getFuel() + '\'' +
                "engine='" + engine + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Automobile)) return false;

        Automobile that = (Automobile) o;

        return engine.equals(that.engine)
                && this.getWheels() == that.getWheels()
                && this.getFuel().equals(that.getFuel())
                && this.getBrand().equals(that.getBrand());
    }

    @Override
    public int hashCode() {
        return hash(engine, getWheels(), getFuel(), getBrand());
    }
}