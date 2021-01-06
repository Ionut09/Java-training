package static_vs_instance;


public class StaticVariables {

    public static void main(String... args) {
        Dog labrador  = new Dog("labrador");
        Dog amstaf  = new Dog("amstaf");

        Dog.breed = "buldog";
        amstaf.breed = "amstaf";

        System.out.println(labrador.getBreed());
        System.out.println(amstaf.getBreed());
    }
}

class Dog {

    static String breed;


    public Dog(String breed) {
        this.breed = breed;
    }

    public static String getBreed() {
        return breed;
    }

    public static void setBreed(String breed) {
        Dog.breed = breed;
    }
}
