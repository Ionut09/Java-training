package primitives;

public class Operators {

    public static void main(String... args) {
        //boolean operators do shortcircuiting

        String s = null;
        if (s != null && s.length() == 5) {
            System.out.println("String has length 5");
        }
//         4 >= 2;

        //= is for assignment
        //for equality we always use double =, = =

        //= = only for primitives !!!!

        String str1 = "Io";
        String str2 = "Jo";

        //for objects use equals
        boolean areEqual = str1.equals(str2);

        //=== type checking ??
        if (str1 instanceof String) {
            System.out.println(str1 + " is of type String");
        }

        if (str1 instanceof CharSequence) {
            System.out.println(str1 + " is instanceof CharSequence");
        }

    }
}
