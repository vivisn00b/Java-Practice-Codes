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

interface SuperContainer<K, V> {
    K getKey();
    V getValue();
}

// Implementing with a specific type
class StringContainer implements Container<String> {
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

//Generic Interfaces with Multiple Type Parameters
class KeyValuePair<K, V> implements SuperContainer<K, V> {
    private K key;
    private V value;

    public KeyValuePair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }
}

public class GenericTypesInterface {
    public static void main(String[] args) {
        Container<String> sc = new StringContainer();
//        StringContainer sc = new StringContainer();
        sc.set("implemented with specific type");
        System.out.println(sc.get());

        GenericContainer<String> gc = new GenericContainer<>();
        gc.set("implemented with generics");
        System.out.println(gc.get());

        KeyValuePair<String, Long> pair = new KeyValuePair<>("User ID", Thread.currentThread().getId());
//        SuperContainer<String, Integer> pair = new KeyValuePair<>("Age", 30);
        System.out.println(pair.getKey() + ": " + pair.getValue());
    }
}
