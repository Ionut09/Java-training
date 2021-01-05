package strings;

public class StringBuilderOps {

    public static void main(String... args) {
        String s = "abc"; // is immutable
        s.concat("def");
        System.out.println("s = " + s);

        StringBuilder sb = new StringBuilder("abc"); // is mutable
        sb.append("def");
        System.out.println("sb = " + sb);

        System.out.println(isPalindrom("abc1cba"));

    }

    private static boolean isPalindrom(String input) {
        return new StringBuilder(input)
                .reverse()
                .toString()
                .equals(input);
    }
}
