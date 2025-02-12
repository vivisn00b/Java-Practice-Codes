// Pretty-printing refers to formatting data or code in a way that is easy for humans to read and understand.
// It typically involves adding whitespace, indentation, and line breaks to structure the content in a visually organized manner.

import java.util.Arrays;
import java.util.List;

public class PrettyPrint {
    public static void main(String[] args) {
        // Sample list
        List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry");

        // Pretty-print list
        System.out.println("Fruits list:");
        fruits.forEach(fruit -> System.out.println("- " + fruit));

        // Pretty-print custom objects
        Person person = new Person("John", "Doe", 30);
        System.out.println("Person details:");
        System.out.println(person);

//        float a = 453.1274f;
//        System.out.printf("Formatted number is %.2f", a);
//        System.out.printf("Pie: %.3f", Math.PI);
//        System.out.printf("Hello my name is %s and I am %s", "Viv", "cool");
    }

    static class Person {
        private String firstName;
        private String lastName;
        private int age;

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        @Override
        public String toString() {
            return String.format("Person[firstName='%s', lastName='%s', age=%d]", firstName, lastName, age);
        }
    }
}
