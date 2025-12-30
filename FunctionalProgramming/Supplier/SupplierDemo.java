package FunctionalProgramming.Supplier;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class SupplierDemo  {
    public static void main(String[] args) {
        Supplier<String> helloWorld = () -> "Hello World!";
        System.out.println(helloWorld.get());

        Supplier<Double> randomSupplier = () -> Math.random();
        System.out.println(randomSupplier.get());

        Supplier<String> nameSupplier = () -> "Vivek";
        Consumer<String> greeter = name -> System.out.println("Hello, " + name);
        greeter.accept(nameSupplier.get());

        //combined example
        Predicate<Integer> predicate = x -> x % 2 == 0;
        Function<Integer, Integer> function = x -> x * x;
        Consumer<Integer> consumer = x -> System.out.println(x);
        Supplier<Integer> supplier = () -> 100;

        if (predicate.test(supplier.get())) {
            consumer.accept(function.apply(supplier.get()));
        }
    }
}
