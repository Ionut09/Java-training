package inheritance;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class VehicleTests {

    public static void main(String... args) {
        Vehicle vehicle = new Vehicle("Panzer", 0, "gasoline");

        Vehicle bmw = new Automobile("V8", "BMW", "gasoline");
        Vehicle anotherBmw = new Automobile("V8", "BMW", "gasoline");
        vehicle = bmw;
        //now new Vehicle("Panzer", 0, "gasoline") will be considered to be Garbage collected
        System.gc();

        Automobile vehicleAuto = (Automobile) bmw;

        vehicle.moves();
        bmw.moves(); //the compiler sees the moves() from Vehicle

        System.out.println(vehicleAuto);//toString() is called by default
        //    ===
        System.out.println(vehicleAuto.toString());

        System.out.println(vehicleAuto == bmw); //compares if the 2 references point to the same object
        System.out.println(bmw.equals(anotherBmw)); //always use equals for comparing objects

        Class<? extends Vehicle> vehicleClass = vehicle.getClass();

        //A Class object is associated with every class in Java, and is created after classloading
        System.out.print("Fields: ");
        for (Field declaredField : vehicleClass.getDeclaredFields()) {
            System.out.print(declaredField.getName() + ", ");
        }

        System.out.println();
        System.out.print("Methods: ");
        for (Method method : vehicleClass.getDeclaredMethods()) {
            System.out.print(method.getName() + ", ");
        }
    }
}
