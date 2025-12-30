// A Function<T, R> is another functional interface
// It represents a mapping from a value of type T (input) to type R (output)

package FunctionalProgramming.Function;

import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class FunctionDemo {
    public static void main(String[] args) {
        Function<Integer, Integer> square = x -> x*x;
        System.out.println(square.apply(5));
        System.out.println(square.apply(10));

        Function<Integer, Integer> doubleIt = x -> x*2;
        Function<Integer, Integer> addTen = x -> x+10;

        Function<Integer, Integer> combined = doubleIt.andThen(addTen); //andThen() → performs another function after the current one
        System.out.println(combined.apply(5));  // (5*2) + 10 = 20

        Function<Integer, Integer> composed = doubleIt.compose(addTen); //compose() → performs another function before the current one
        System.out.println(combined.apply(5));  // (5+10)*2 = 30

        List<String> names = List.of("Vivek", "Anita", "Bob", "Arjun");
        Function<String, String> toUpper = String::toUpperCase;
        Function<String, Integer> length = String::length;
        List<Integer> lengths = names.stream().map(toUpper.andThen(length)).collect(Collectors.toList());
        System.out.println(lengths); // [5, 5, 3, 5]

        Function<Integer, Function<Integer, Integer>> adder = x -> (y -> x+y);
        Function<Integer, Integer> add5 = adder.apply(5);
        System.out.println(add5.apply(10));

        // UnaryOperator represents an operation on a single operand that returns a result of the same type.
        // It’s a special case of the Function<T, R> interface, where T and R are the same type.
        UnaryOperator<Integer> uSquare = x -> x * x;
        System.out.println(uSquare.apply(5));  // Output: 25

        UnaryOperator<String> uToUpper = s -> s.toUpperCase();
        System.out.println(uToUpper.apply("hello"));  // Output: HELLO
    }
}
