package Generics;

interface Printable {
    void print();
}

//class MyNumber extends Number implements Printable {
//    private final int value;
//
//    public MyNumber(int value) {
//        this.value = value;
//    }
//    @Override
//    public void print() {
//        System.out.println("My number is " + value);
//    }
//
//    @Override
//    public int intValue() {
//        return value;
//    }
//
//    @Override
//    public long longValue() {
//        return value;
//    }
//
//    @Override
//    public float floatValue() {
//        return value;
//    }
//
//    @Override
//    public double doubleValue() {
//        return value;
//    }
//}

//T extends Number → Restricts the type parameter so it’s numeric.
//extends Number (on MyNumber) → Makes MyNumber itself behave like a Number (or else overridden methods can't be implemented).
//
//They solve different problems:
//1. what kind of input values MyNumber can wrap.
//2. what kind of object MyNumber itself is.

class MyNumber<T extends Number> extends Number implements Printable { // It can now accept all numeric types
    private final T value;

    public MyNumber(T value) {
        this.value = value;
    }

    @Override
    public void print() {
        System.out.println("My number is " + value);
    }

    public T getValue() {
        return value;
    }

    // Implementing abstract methods of Number
    @Override
    public int intValue() {
        return value.intValue();
    }

    @Override
    public long longValue() {
        return value.longValue();
    }

    @Override
    public float floatValue() {
        return value.floatValue();
    }

    @Override
    public double doubleValue() {
        return value.doubleValue();
    }
}

// always put class first (Number) and then interface(Printable) because java doesn't support multiple inheritance
class BoundedContainer<T extends Number & Printable> {
    private T item;

    public BoundedContainer(T item) {
        this.item = item;
    }

    public void display() {
        item.print();
    }

    public T getItem() {
        return item;
    }
}

public class MultipleBounded {
    public static void main(String[] args) {
        MyNumber num = new MyNumber(50);
        BoundedContainer<MyNumber> bContain = new BoundedContainer<>(num);
        bContain.display();
    }
}