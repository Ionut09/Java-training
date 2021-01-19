package concurrency;

import java.util.ArrayList;
import java.util.List;

import lombok.ToString;

@ToString
public final class ImmutableHousehold {

    private final String name; //immutable

    private final List<String> animals = new ArrayList<>(); //mutable

    public ImmutableHousehold(String name) {
        this.name = name;
//        animals = List.of("cat", "dog");//...
        animals.add("cat");
        animals.add("dog");
        animals.add("pig");
        animals.add("mouse");
    }

    public String getName() {
        return name;
    }

    public List<String> getAnimals() {
        return new ArrayList<>(animals);
    }
}
