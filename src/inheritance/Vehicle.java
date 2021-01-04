package inheritance;

public class Vehicle {

    private String brand;

    private int wheels;

    private String fuel;

    public Vehicle(String brand, int wheels, String fuel) {
        this.brand = brand;
        this.wheels = wheels;
        this.fuel = fuel;
    }

    public void moves(){
        System.out.println("Vehicle moves");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }
}
