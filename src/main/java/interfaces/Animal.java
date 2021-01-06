package interfaces;

public abstract class Animal { //we'll not be allowed to instantiated

    private String species;

    private String food;

    public Animal(String species, String food) {
        this.species = species;
        this.food = food;
    }
}
