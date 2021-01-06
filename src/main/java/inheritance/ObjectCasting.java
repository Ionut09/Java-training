package inheritance;

public class ObjectCasting {

    public static void main(String... args) {
        Vehicle bmw = new Automobile("V8", "BMW", "gasoline");

        bmw.moves(); //bmw can only see methods from Vehicle
        //casting a reference you transform that reference
        if (bmw instanceof Automobile) {
            Automobile automobile = (Automobile) bmw;
            automobile.startEngine();
        }
        Vehicle bike = new Bicicle("Merida");

        if (bike instanceof Automobile) {
            ((Automobile) bike).startEngine();
        }

        Automobile mercedes = new Automobile("V8", "Mercedes", "gasoline");
        Vehicle vehicleMercedes =  mercedes;
    }
}
