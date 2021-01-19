package concurrency;

public class Mutables {

    public static void main(String... args) {
        String str = new String("qwertyui"); //object immutability
        str.toUpperCase();

        System.out.println(str);
        final String immutableReference = "aa"; //immutable references
//        immutableReference = "123";
        var upperCase = immutableReference.toUpperCase();
        System.out.println("upperCase = " + upperCase);
    }
}
