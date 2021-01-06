package streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

    public static void main(String... args) {
        List<String> words = List.of("monkey", "cat", "lion");

        Function<String[], Stream<String>> flatMapFunction = charArray -> Arrays.stream(charArray);

        List<String> charcters = words.stream()                             //Stream<String>
                                      .map(word -> word.split(""))     //Stream<String[]>
                                      .flatMap(flatMapFunction)             //Stream<String>
                                      .distinct()                           //Stream<String>
                                      .collect(Collectors.toList());

        System.out.println(charcters);
//        charcters.forEach(arr -> System.out.println(Arrays.toString(arr)));

        long numberOfChars = words.stream()                             //Stream<String>
                                  .map(word -> word.split(""))     //Stream<String[]>
                                  .flatMap(flatMapFunction)             //Stream<String>
                                  .distinct()                           //Stream<String>
                                  .count();

    }


    static void print(Collection<?> set) {
        for (Object o : set) {
            System.out.println(o);
        }
    }
}
