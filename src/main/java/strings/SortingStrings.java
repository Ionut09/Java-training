package strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortingStrings {

    public static void main(String... args) {
        String srt = "Returns a new string that is a substring of this string. The substring begins " +
                "at the specified beginIndex and extends to the character at index endIndex - 1.";

        List<String> stringList = putWordIntoAList(srt);

        Collections.sort(stringList);

        System.out.println(stringList);


    }

    public static List<String> putWordIntoAList(String srt) {
        return Arrays.stream(srt.split("\\s+"))
                     .map(String::toLowerCase)//String
                     .collect(Collectors.toList());
    }
}
