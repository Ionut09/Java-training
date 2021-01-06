package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class Lists {

    public static void main(String... args) {
        List<String> strings = new ArrayList<>(1000);//size of the internal array
        //add more than 100 elements
        //a new array is created with size initialCapacity*2
        // and previous elements are copied into the new array //O(n)
        //adding it's O(n)

        int[] arr = new int[100];//it's not resizable

        arr[9] = 1000; //arr has the memory address of array object (the starting point) O(1)
        //startingMemAddress + 32 * 10 -> memory address (location) of arr[9]

        arr[6] = 1000; //arr has the memory address of array object (the starting point) O(1)
        //startingMemAddress + 32 * 7 -> memory address (location) of arr[6]

//        for (int i : arr) {
//            System.out.println();//O(n)
//        }

//        strings.get(8); //O(1) --> IndexOutOfBoundsException
//        strings.set(8, "234567"); //O(1) --> IndexOutOfBoundsException

        strings.add("12345"); //lastAvailableIndex

        strings.size();//1 the number of elements in the ArrayList
//      strings.capacity();//1000
        strings.add(0, "8732");

//        strings.removeIf(string -> string.length() > 4);

//        LinkedList


        //creating lists
        List<String> list = new ArrayList<>();//size of the internal array

        List<String> listImmutable = List.of("1", "2", "3");
        String[] strArray = {"1", "2", "3"};
        List<String> listImmutableFromArray = Arrays.asList(strArray);

        for (int i = 0; i < strArray.length; i++) {
            int parsedElement = Integer.parseInt(strArray[i]);
            double pow = Math.pow(parsedElement, 2);
            strArray[i] = String.valueOf((int) pow);
        }

        System.out.println(listImmutable);
        System.out.println(Arrays.toString(strArray));

        //ADD  -> CRUD
        List<String> langs = new ArrayList<>();//size of the internal array

        langs.add("Java");
        langs.add("SQL");
        langs.add("PHP");
        langs.addAll(List.of("Javascript", "Scala"));
        langs.add(0, "C++");
        System.out.println(langs);         //[C++, Java, SQL, PHP, Javascript, Scala]

        //READ
        String php = langs.get(3);
        System.out.println(php); //PHP

        boolean hasPhp = langs.contains("PHP");
        langs.indexOf("PHP");
        langs.lastIndexOf("PHP");


        //UPDATE
        langs.set(0, "Python");
        System.out.println(langs);//[Python, Java, SQL, PHP, Javascript, Scala]


        //DELETE
        langs.remove("Scala");
        langs.remove(4);

        //this is the implementation of the test() method
        Predicate<String> stringPredicate1 = lang -> lang.equals("Java") || lang.length() < 4;
        boolean test = stringPredicate1.test("Java");

//        boolean methodName(String name);
//        Predicate stringPredicate = (Object lang) -> lang.equals("Java") || lang.length() < 4;

//        List<String> you cannot assign it to a List<Object>

        //boolean test(String t);
        Predicate<String> stringPredicate = lang -> lang.equals("Java") || lang.length() < 4;
        //lambda expresion can be created only for functional interfaces (interfaces with a single abstract method)
        langs.removeIf(stringPredicate);
        langs.removeIf(new MyPredicate());
        System.out.println(langs);

        FunctionalInterfaceCustom myLambda = () -> System.out.println("abcdef");
        myLambda.abstractMethod();


        langs.addAll(List.of("Javascript", "Scala"));

        // int compare(String o1, String o2); //same contract as compareTo from Comparable,
        Collections.sort(langs, (str1, str2) -> str2.compareTo(str1)); //elements from langs need to be Comparable
        Collections.sort(langs, Comparator.reverseOrder());

        //all collections are mutable objects
        System.out.println(langs);
    }
}

//DO NOT DO THIS AT HOME !!!
class MyPredicate implements Predicate<String> {

    @Override
    public boolean test(String lang) {
        return lang.equals("Java") || lang.length() < 4;
    }
}
