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

public class GenericConstructor {
    public static void main(String[] args) {
        GenericConContainer c1 = new GenericConContainer(42);
        GenericConContainer c2 = new GenericConContainer("Hello");
        GenericConContainer c3 = new GenericConContainer(3.14);
    }
}
