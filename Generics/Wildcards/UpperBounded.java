// Upper-bounded wildcards are useful when you want to read data from a generic structure but you don’t need to modify it

package Generics.Wildcards;

import java.util.ArrayList;
import java.util.List;

public class UpperBounded {
    public static double sum(List<? extends Number> number) {
        double total = 0.0;
        for (Number num : number)
            total += num.doubleValue();
        return total;
    }

    public static void main(String[] args) {
        List<Integer> integerList = List.of(1, 2, 3);
        List<Double> doubleList = List.of(0.1, 0.2, 0.3);
        System.out.println("Sum of integers: " + sum(integerList));
        System.out.println("Sum of doubles: " + sum(doubleList));

//        Limitation: You can’t add anything (except null) to list because the compiler doesn’t know what type it’s safe to insert.
//
//        List<?> list = new ArrayList<>();
//        list.add("Hello");  // compile error
//        list.add(null);  // null is allowed

//        Covariance allows a generic type to be assigned to another generic type with a broader bound.
        List<? extends Number> numbers;
        numbers = List.of(10, 20, 30);
        numbers = List.of(1.0, 2.0, 3.0);
//        numbers.add(null);  // Error: You can't add elements, because it doesn't know the exact type
//        numbers.add(10);  // Valid
    }
}
