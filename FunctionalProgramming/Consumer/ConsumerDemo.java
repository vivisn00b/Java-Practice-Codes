// Consumer<T> is a functional interface from java.util.function that takes one input and returns nothing

package FunctionalProgramming.Consumer;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<Integer> print = x -> System.out.println(x);
        print.accept(5);

        List<Integer> list = Arrays.asList(1, 2, 3);
        Consumer<List<Integer>> printList = x -> {
            for (int i : x) {
                System.out.println(i);
            }
        };
        printList.accept(list);

        Consumer<String> printUpper = s -> System.out.println(s.toUpperCase());
        Consumer<String> printLength = s -> System.out.println("Length: " + s.length());
        Consumer<String> combined = printUpper.andThen(printLength);
        combined.accept("Vivek");
    }
}
