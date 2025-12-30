// A BiPredicate takes two inputs and returns a boolean.
// A BiFunction takes two inputs and returns a result.
// A BiConsumer takes two inputs and returns nothing — it’s all about performing an action with a pair of values.
//
// There’s no BiSupplier in Java because a Supplier doesn’t take inputs. A Supplier’s purpose is to produce, not consume or test.
//
package FunctionalProgramming;

import java.util.function.*;

public class BiInterfaceDemo {
    public static void main(String[] args) {
        BiPredicate<Integer, Integer> isSumEven = (a, b) -> (a + b) % 2 == 0;
        System.out.println(isSumEven.test(2, 4)); // true
        System.out.println(isSumEven.test(3, 5)); // false

        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        BiFunction<String, Integer, String> repeat = (str, count) -> str.repeat(count);
        System.out.println(add.apply(5, 10));        // 15
        System.out.println(repeat.apply("Hi", 3));   // HiHiHi

        // BinaryOperator represents an operation upon two operands of the same type, producing a result of that same type.
        // It’s a special case of the BiFunction<T, U, R> interface where all types are the same.
        BinaryOperator<Integer> bAdd = (a, b) -> a + b;
        System.out.println(bAdd.apply(10, 20));  // Output: 30

        BinaryOperator<String> bConcat = (s1, s2) -> s1 + s2;
        System.out.println(bConcat.apply("Hello ", "World"));  // Output: Hello World

        BiConsumer<String, Integer> print = (name, age) -> System.out.println(name + " is " + age);
        BiConsumer<String, Integer> log = (name, age) -> System.out.println("Logged: " + name);
        print.andThen(log).accept("Arjun", 30);
    }
}

class BiFam {
    public static void main(String[] args) {

        // BiPredicate: test two inputs (marks and pass mark)
        BiPredicate<Integer, Integer> hasPassed = (marks, passMark) -> marks >= passMark;

        // BiFunction: calculate total marks with bonus
        BiFunction<Integer, Integer, Integer> addBonus = (marks, bonus) -> marks + bonus;

        // BiConsumer: consume two inputs (student name, final marks) and print
        BiConsumer<String, Integer> printResult =
                (name, finalMarks) -> System.out.println(name + " scored " + finalMarks + " marks.");

        // Data
        String student = "Vivek";
        int marks = 72;
        int passMark = 40;
        int bonus = 5;

        // Use Supplier to simulate a data source
        Supplier<Integer> marksSupplier = () -> marks;

        // The functional flow
        int actualMarks = marksSupplier.get();

        if (hasPassed.test(actualMarks, passMark)) {
            int finalMarks = addBonus.apply(actualMarks, bonus);
            printResult.accept(student, finalMarks);
        } else {
            System.out.println(student + " has failed the exam.");
        }
    }
}