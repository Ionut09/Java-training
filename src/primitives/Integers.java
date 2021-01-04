package primitives;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Integers {

    public static void main(String... args) {

        //ranges
        int sum = 2 + 3;

        System.out.println(sum / 2); //2,  the result of an operation is always the biggest type of the operands
        System.out.println(sum / 2.0); //2.5

        //literals like 3, 1019 are ints by default

        long aLong = 81271899999L;

        //ranges for primitives, you use MAX_VALUE or MIN_VALUE variables from the associated wrapper types
        System.out.println(Byte.MAX_VALUE);
        System.out.println(Byte.MIN_VALUE);

        System.out.println(Short.MAX_VALUE);
        System.out.println(Short.MIN_VALUE);

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        System.out.println(Long.MAX_VALUE);
        System.out.println(Long.MIN_VALUE);

        System.out.println(Character.MAX_VALUE);
        System.out.println(Character.MIN_VALUE);

        Integer iOld = new Integer(5);
        Integer i = 5; //boxing = conversion between primitve and object
        int i1 = i; //unboxing

        String input = "123";
        int parsedInt = Integer.parseInt(input);
        long parsedLong = Long.parseLong(input);

        boolean parsedBoolean = Boolean.parseBoolean("True"); //true

        //working with java.math.BigDecimal
        BigDecimal fromString = new BigDecimal("10.5");
        BigDecimal fromIntegers = BigDecimal.valueOf(21);

        BigDecimal aNewBigDecimalSum = fromString.add(fromIntegers);
        System.out.println(aNewBigDecimalSum); //31.5 --> the result will the bigger scale of the 2
        System.out.println(fromString); //10.5 --> because they are immutable, once created is never modified

        System.out.println(fromIntegers.subtract(fromString)); //10.5

        System.out.println(fromIntegers.divide(fromString)); //
        System.out.println(fromIntegers.signum());
        System.out.println(fromString.setScale(2, RoundingMode.UP));
        System.out.println(fromString.negate());
        System.out.println(fromString);


        //casting
        long a = 12;
        int b = (int) a; //cast
        long sum1 = b;

        //always need a cast when converting from floating point numbers to integers
        float f = 3.5F;
        double d = 3.5;  //literals like 3.5, 12.6 are doubles by default

        d = f;
        f = (float) d;

        a = (long) d; //truncation to 3
        System.out.println("a = " + a);

        int bigSum = Integer.MAX_VALUE + 2; //overflow -> Integer.MIN_VALUE + 2
        System.out.println("bigSum with overflow = " + bigSum);

        char c = '\u0041';
        System.out.println(c); //'A'

        System.out.println("abdc\nsdksnd");
    }
}
