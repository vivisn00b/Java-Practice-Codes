package Generics;

// The type parameter T is restricted to subclasses of Number, so only numeric types like Integer, Double, etc., can be used.
public class BoundedTypeParameter<T extends Number> {
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public static void main(String[] args) {
        BoundedTypeParameter<Integer> parameter = new BoundedTypeParameter<>();
        parameter.setValue(10);
        System.out.println(parameter.getValue());

        //BoundedTypeParameter<String> argument = new BoundedTypeParameter<>();
        // will give error because it's bounded to only Number
    }
}