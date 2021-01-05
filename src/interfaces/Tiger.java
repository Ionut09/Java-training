package interfaces;

public class Tiger extends Animal implements Feline {


    public Tiger() {
        super("Tiger", "meat");
    }

    @Override
    public void hunt() {
        System.out.println("Tiger hunts");
    }

    static void run() {
        System.out.println("All felines run");
    }

    public boolean nightVision() {
        return true;
    }

    public static void main(String... args) {
        Tiger tiger = new Tiger();
        Feline.run();

        tiger.run(); //bad usage

        Tiger.run();
    }
}
