package generics;

import java.util.List;

public class Bounds {

    public static void main(String... args) {
        wildMethod(List.of(1, 2));
        wildMethod(List.of("1", 2));
        wildMethod(List.of("1", "2"));
    }

    private static void methodWithWildcard(List<? super Integer> numbers) {
        for (Object number : numbers) {
            System.out.println(number);
        }
    }

    private static <T> void genericMethod(List<? super T> numbers) {
        for (Object number : numbers) {
            System.out.println(number);
        }
    }

//    private static void wildMethod(List<?> numbers) {
//        for (Object number : numbers) {
//            System.out.println(number);
//        }
//    }

    private static <T> void wildMethod(List<T> numbers) {
        for (Object number : numbers) {
            System.out.println(number);
        }
    }
}
