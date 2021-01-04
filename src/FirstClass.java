import java.math.*;
import java.util.List;

public class FirstClass {

    public static void main(String... args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello Java");
        }

        //I can use any class that is on the classpath
        char aChar = 'a';
        String aString = "a";

        System.out.println(aChar); //echo
        System.out.println('a' + 1); //ASCII code of 'a' char + 1 ==> always java does the arithemtic operation fro chars
        System.out.println((char) ('a' + 1)); //ASCII code of 'a' char + 1

        System.out.println(aString + 1); //a1
        System.out.println("aString" + 1); //aString1 ==> always java does concatenation for Strings, not point operator for concatenation

        //any class that is on the classpath outside from java.lang package needs to be imported
        System.out.println(valueOf(10));

        int count = 0;
        for (String arg : args) {
            System.out.println("arg " + (++count) + "= " + arg);
        }
    }

    private static int valueOf(int a){
        System.out.println("a = " + a);
        return 1;
    }
}


//
//class FirstClass1 {
//
//
//}

