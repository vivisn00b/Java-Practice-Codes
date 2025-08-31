//Type Parameter Naming Conventions:
//T: Type
//E: Element (used in collections)
//K: Key (used in maps)
//V: Value (used in maps)
//N: Number

package Generics;

interface Container<T> {
    void set(T item);
    T get();
}

// Implementing with a specific type
class StringCointainer implements Container<String> {
    private String item;

    @Override
    public void set(String item) {
        this.item = item;
    }

    @Override
    public String get() {
        return item;
    }
}

//Implementing a generic interface generically
class GenericContainer<T> implements Container<T> {
    private T item;

    @Override
    public void set(T item) {
        this.item = item;
    }

    @Override
    public T get() {
        return item;
    }
}

public class GenericTypesInterface {
    public static void main(String[] args) {
        StringCointainer sc = new StringCointainer();
        sc.set("implemented with specific type");
        System.out.println(sc.get());

        GenericContainer<String> gc = new GenericContainer<>();
        gc.set("implemented with generics");
        System.out.println(gc.get());
    }
}
