package oop;

public class PassByReference {

    public static void main(String[] args) {
        House greenHouse = new House();
        System.out.println(greenHouse.getColor());

        greenHouse.setColor("green");
        greenHouse.getColor();
        printHouseColor(greenHouse);
    }

    private static void printHouseColor(House house) {
        System.out.println(house.getColor());
    }
}
