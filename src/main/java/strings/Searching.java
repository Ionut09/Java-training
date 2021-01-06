package strings;

public class Searching {

    public static void main(String... args) {
        String s = "Returns a new string that is a substring of this string. The substring begins " +
                "at the specified beginIndex and extends to the character at index endIndex - 1.";

        int indexOf = s.indexOf("specified"); //-1 if it doesn't find it, first ocurrence index if does

        int indexOfT = s.indexOf('T', 10);

        int lastIndexOf = s.lastIndexOf("at");////-1 if it doesn't find it, last ocurrence index if does
        System.out.println("lastIndexOf = " + lastIndexOf);

        boolean contains = s.contains("character");//true


    }
}
