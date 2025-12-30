/*
*Functions are treated as data — you can store them in variables, pass them as arguments, and return them from other functions.
*You prefer immutability — avoid changing data once created.
*You avoid side effects — a function’s output depends only on its input (no sneaky changes to global state or class fields).
*You use declarative style — say what you want done, not how to do it step by step.
*/

package FunctionalProgramming;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class FunctionalDemo {
    public static void main(String[] args) {

        // 1. Sample data (Immutable List)
        List<Employee> employees = List.of(
                new Employee("Alice", 30, 50000),
                new Employee("Bob", 45, 80000),
                new Employee("Charlie", 25, 40000),
                new Employee("Diana", 35, 70000)
        );

        // 2. Predicate: filter employees older than 30
        Predicate<Employee> olderThan30 = e -> e.age() > 30;

        // 3. Function: convert salary to new salary after 10% hike
        Function<Employee, Employee> giveRaise = e ->
                new Employee(e.name(), e.age(), e.salary() * 1.10);

        // 4. Consumer: print employee info
        Consumer<Employee> printEmp = System.out::println;

        // 5. Stream pipeline: filter, map, sort, collect
        List<Employee> updatedList = employees.stream()
                .filter(olderThan30)
                .map(giveRaise)
                .sorted(Comparator.comparing(Employee::salary))
                .toList();

        // 6. Print updated employees
        updatedList.forEach(printEmp);

        // 7. Reduce: find total payroll after raises
        double totalSalary = updatedList.stream()
                .map(Employee::salary)
                .reduce(0.0, Double::sum);

        System.out.println("\nTotal payroll: " + totalSalary);

        // 8. Optional: find highest earner safely
        Optional<Employee> richest = updatedList.stream()
                .max(Comparator.comparing(Employee::salary));

        richest.ifPresentOrElse(
                e -> System.out.println("Richest: " + e.name()),
                () -> System.out.println("No employees found")
        );

        // 9. Higher-order function: build a bonus calculator generator
        Function<Double, Function<Employee, Double>> bonusCalculator = rate ->
                emp -> emp.salary() * rate;

        Function<Employee, Double> bonus10Percent = bonusCalculator.apply(0.10);

        System.out.println("\nBonuses:");
        updatedList.forEach(e ->
                System.out.println(e.name() + " -> " + bonus10Percent.apply(e))
        );
    }
}

// Immutable record class for Employee (since Java 16+)
record Employee(String name, int age, double salary) {}
