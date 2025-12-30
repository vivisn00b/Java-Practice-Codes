package FunctionalProgramming.Predicate;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateDemo {
    public static void main(String[] args) {
        // checks if a number is even
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println(isEven.test(10)); // true
        System.out.println(isEven.test(7));  // false
        Predicate<Integer> isPositive = n -> n > 0;

        Predicate<Integer> isPositiveEven = isPositive.and(isEven);
        System.out.println(isPositiveEven.test(4));  // true
        System.out.println(isPositiveEven.test(-2)); // false
        System.out.println(isPositiveEven.negate().test(-2)); // true (negated)

        List<String> names = List.of("Vivek", "Anita", "Bob", "Arjun", "Alex");
        Predicate<String> startsWithA = name -> name.startsWith("A");
        Predicate<String> longName = name -> name.length() > 4;
        List<String> filtered = names.stream().filter(startsWithA.and(longName)).collect(Collectors.toList());
        System.out.println(filtered); // [Anita, Arjun]
    }
}
