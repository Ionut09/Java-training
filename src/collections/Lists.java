package collections;

import java.util.ArrayList;
import java.util.List;

public class Lists {

    public static void main(String... args) {
        List<String> strings = new ArrayList<>(100);//size of the internal array
        //add more than 100 elements
        //a new array is created with size initialCapacity*2
        // and previous elements are copied into the new array
        //adding it's O(n)

        int[] arr = new int[10000000];

        arr[9] = 1000; //arr has the memory address of array object (the starting point) O(1)
        //startingMemAddress + 32 * 10 -> memory address (location) of arr[9]

        arr[6] = 1000; //arr has the memory address of array object (the starting point) O(1)
        //startingMemAddress + 32 * 7 -> memory address (location) of arr[6]

        for (int i : arr) {
            System.out.println();//O(n)
        }

        strings.get(8); //O(1)
    }
}