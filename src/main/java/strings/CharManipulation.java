package strings;

public class CharManipulation {

    public static void main(String... args) {
        String srt = "Returns a new string that is a substring of this string. The substring begins " +
                "at the specified beginIndex and extends to the character at index endIndex - 1.";

        String substring = srt.substring(0, 7);
        String substringTotal = srt.substring(7);
        String substringTotal1 = srt.substring(7, srt.length());
        System.out.println(substring);

        for (String word : srt.split("\\s+")) {
            System.out.print(word + ", ");
        }
        System.out.println();
        System.out.println("    jsnjsn     ".trim());

        substring = substring.toLowerCase();
        String auxiliaryRef = substring.toLowerCase();
        System.out.println("substring = " + substring);//returns



    }
}
