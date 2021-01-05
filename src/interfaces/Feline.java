package interfaces;

public interface Feline {


//   public abstract void hunt(); //abstract method
   void hunt(); //abstract method



    default boolean nightVision(){
        doesHaveNIghtVision();
        return see();
    }

    private void doesHaveNIghtVision() {
        System.out.println("does it have night vision");
    }

    static void run(){
        System.out.println("All felines run");
    }

    private boolean see(){
        return true;
    }
}
