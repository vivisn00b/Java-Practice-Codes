package Generics;

class GenericConContainer {
    private Object value;
    public <T> GenericConContainer(T value) {
        this.value = value;
        System.out.println("Stored value: " + value + " (type: " + value.getClass().getSimpleName() + ")");
    }

    public Object getValue() {
        return value;
    }
}

class Test<T> {
    private T value;

    // Generic constructor
    <U> Test(U input) {
        System.out.println(input.getClass().getName());
    }
}

class ConPair {
    // Generic constructor with two type parameters
    <A, B> ConPair(A first, B second) {
        System.out.println("First: " + first + ", Second: " + second);
    }
}

class ConPrinter {
    <T extends Number> ConPrinter(T number) {
        System.out.println("Number: " + number);
    }
}

public class GenericConstructor {
    public static void main(String[] args) {
        GenericConContainer c1 = new GenericConContainer(42);
        GenericConContainer c2 = new GenericConContainer("Hello");
        GenericConContainer c3 = new GenericConContainer(3.14);

        Test<Integer> test = new Test<>(12.34);

        new ConPair(10, "Ten");  // Integer and String
        new ConPair(3.14, 42);   // Double and Integer

        new ConPrinter(100);  // Integer is a subclass of Number
        new ConPrinter(3.14);  // Double is a subclass of Number
    }
}
