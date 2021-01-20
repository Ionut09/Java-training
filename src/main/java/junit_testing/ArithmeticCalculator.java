package junit_testing;

public class ArithmeticCalculator {

    public int division(String... numbers) {
        int result = 1;

        for (int i = 0; i < numbers.length - 1; i++) {
            validateNumber(numbers[i]);
            result = Integer.parseInt(numbers[i]) / Integer.parseInt(numbers[i + 1]);
        }

        return result;
    }

    public int multiply(String... numbers) {
        int result = 1;

        for (int i = 0; i < numbers.length - 1; i++) {
            validateNumber(numbers[i]);
            result = Integer.parseInt(numbers[i]) * Integer.parseInt(numbers[i + 1]);
        }

        return result;
    }

    public int substraction(String... numbers) {
        int result = 0;

        for (int i = 0; i < numbers.length - 1; i++) {
            validateNumber(numbers[i]);
            result = Integer.parseInt(numbers[i]) - Integer.parseInt(numbers[i + 1]);
        }

        return result;
    }

    public int sum(String... numbers) {
        int result = 0;

        for (int i = 0; i < numbers.length - 1; i++) {
            validateNumber(numbers[i]);
            result = Integer.parseInt(numbers[i]) + Integer.parseInt(numbers[i + 1]);
        }

        return result;
    }

    private void validateNumber(String number) {
        if(!number.matches("[0-9]+")){
            throw new IllegalArgumentException("Bad number");
        }
    }
}
