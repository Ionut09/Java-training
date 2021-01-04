package methods;

public class Example {

    public static void main(String... args) {
        methodWithVarargs(1);
        System.out.println("===============");
        methodWithVarargs(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println("===============");
        methodWithVarargs(0, new int[]{3, 4, 5, 6, 7});
//        methodWithArrayArg(3, 4, 5, 6, 7);
    }

    private static void methodWithVarargs(int a, int... ints) {
        int length = ints.length;
        for (int anInt : ints) {
            System.out.println("anInt = " + anInt);
        }
    }

    private static void methodWithArrayArg(int[] ints) {
        for (int anInt : ints) {
            System.out.println("anInt = " + anInt);
        }
    }
}
