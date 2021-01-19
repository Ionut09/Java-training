package concurrency;

import java.util.List;

public class CountryHousehold {

    public static void main(String... args) {
        ImmutableHousehold household = new ImmutableHousehold("Johnny's household");
        System.out.println(household);
        String newHousholdName = household.getName().concat(" from Romania");
        System.out.println(household);
        System.out.println(newHousholdName);

        List<String> aNewReferenceToTheAnimalsArraylist = household.getAnimals();
        aNewReferenceToTheAnimalsArraylist.add("rat"); //mutable
        System.out.println(aNewReferenceToTheAnimalsArraylist);
        System.out.println(household);
    }
}
