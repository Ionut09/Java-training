package lambdas;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

import collections.User;

public class Lambdas {

    public static void main(String... args) {
        BiFunction<String, String, String> bf = (a, b) -> a + b; //
        BiFunction<String, String, Integer> bf2 = (a, b) -> a.length() + b.length(); //

        BinaryOperator<String> bo = (a, b) -> a + b;

        Function<User, String> keyExtractor = user -> user.getName();
        Function<User, String> keyExtractor1 = User::getName;

        Comparator<User> comparing = Comparator.comparing(keyExtractor);
    }


}

class Anonymous implements BiFunction<String, String, String> {

    @Override
    public String apply(String a, String b) {
        return a + b;
    }
}

@FunctionalInterface
interface TriFunction<T, U, V, R> {

    R apply(T t, U u, V v);
}
