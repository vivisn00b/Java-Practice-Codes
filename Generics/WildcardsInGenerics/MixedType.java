package Generics.WildcardsInGenerics;

import java.util.ArrayList;
import java.util.List;

class Printer {
    // Upper bound: accepts List of any subtype of Number
    public static void printNumbers(List<? extends Number> list) {
        for (Number n : list) {
            System.out.println(n);
        }
    }

    // Lower bound: accepts List of Integer or its supertypes
    public static void addIntegers(List<? super Integer> list) {
        list.add(42);
        list.add(100);
    }
}

public class MixedType {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>(List.of(1, 2, 3));
        List<Double> doubleList = new ArrayList<>(List.of(3.14, 2.71));

        Printer.printNumbers(intList);    // works (Integer extends Number)
        Printer.printNumbers(doubleList); // works (Double extends Number)

        List<Number> numList = new ArrayList<>();
        Printer.addIntegers(numList);     // can add Integers into Number list
        System.out.println(numList);      // [42, 100]
    }
}
