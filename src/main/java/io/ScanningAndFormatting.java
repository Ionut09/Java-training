package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;

public class ScanningAndFormatting {

    public static void main(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("First number: ");
//        double first = scanner.nextDouble();
//        System.out.println("Second number: ");
//        double second = scanner.nextDouble();
//        String op = scanner.next();
//        System.out.println(first + " + " + second + " = " + (first + second));
//        System.out.println("Operation: " + op);


        Scanner sc = new Scanner(new BufferedReader(new FileReader("./src/main/resources/io/input.txt")));
        sc.useDelimiter("[^0-9a-zA-Z]+");
        double sum = 0;
        while (sc.hasNext()) {
            sc.useLocale(Locale.US);// 20.24 -> double
            sc.useLocale(Locale.getDefault());// Locale = Romania-> 20,24 -> double
            if (sc.hasNextDouble()) {
                sum += sc.nextDouble();
            } else {
                System.out.println(sc.next());
            }
        }
        System.out.println("sum = " + sum);
    }
}
