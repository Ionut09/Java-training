package junit_testing;

import java.util.Optional;

import lombok.Data;

import static java.util.Objects.isNull;

@Data
public class Calculator {

    public static final String OPERATION_REGEX = "[\\+\\*\\-\\\\]";

    private ArithmeticCalculator arithmeticCalculator;

    /**
     * Performs the given arithmetical operation
     * 1+2+3 or 1-2-3 or 1*2*3
     */
    public int operation(String input) {
        if (isNull(input)) {
            return 0;
        }

        String[] numbers = input.split(OPERATION_REGEX);

        var optionalResult = getResult(input, numbers);

        if (optionalResult.isPresent()) {
            return optionalResult.get();
        }

        throw new IllegalArgumentException("Unsuported operation");
    }

    private Optional<Integer> getResult(String input, String[] numbers) {
        if (input.contains("+")) {
            return Optional.of(arithmeticCalculator.sum(numbers));
        }

        if (input.contains("*")) {
            return Optional.of(arithmeticCalculator.multiply(numbers));
        }

        if (input.contains("/")) {
            return Optional.of(arithmeticCalculator.division(numbers));
        }

        if (input.contains("-")) {
            return Optional.of(arithmeticCalculator.substraction(numbers));
        }
        return Optional.empty();
    }

}
