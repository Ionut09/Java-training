package strings;

public class ReplacingStrings {

    public static void main(String... args) {
        String[] input = {
                "()",
                "[()]", //--> []
                "{{[]()}}",
                "{}}",
                "abc{}", //unbalanced
                ")))((({}"
        };

        for (String s : input) {
            System.out.println(isBalanced(s) + "-->" + s);
        }

    }

    private static boolean isBalanced(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

//        String[] chars = s.split("");
//        for (String ch : chars) {
//
//        }
        //while I have pairs () or [] or {}
        //I replace them with nothing
        //I check wheter the string is empty or not

        while (s.contains("()") || s.contains("[]") || s.contains("{}")) {

            s = s.replaceAll("\\{\\}", "")
                 .replaceAll("\\(\\)", "")
                 .replaceAll("\\[\\]", "");

        }

        return s.isEmpty();
    }
}
