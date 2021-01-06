package static_vs_instance;


public class InstanceVariables {

    public static void main(String... args) {
        Cat kitty  = new Cat("Kitty");
        Cat fluffy  = new Cat("Fluffy");

        System.out.println(kitty.getName());
        System.out.println(fluffy.getName());
    }
}

class Cat {

    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
