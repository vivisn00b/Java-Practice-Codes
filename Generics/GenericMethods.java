package Generics;

class Utils {
    // <T> before void declares a type parameter.
    // It’s not a return type, it’s a kind of placeholder.
    public static <T> void printArray(T[] array) {
        for (T element : array)
            System.out.println(element + " ");
        System.out.println();
    }

    public static <T> T getFirst(T[] array) {
        return array[0];
    }

    public static <K, V> void printValue(K key, V value) {
        System.out.println("Key: " + key + " Value: " + value);
    }
}

public class GenericMethods {
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4};
        String[] strArray = {"A", "B", "C"};
        int firstNum = Utils.getFirst(intArray);
        String firstWord = Utils.getFirst(strArray);
        System.out.println(firstNum + ", " + firstWord +"\n");
        Utils.printArray(intArray);
        Utils.printArray(strArray);
        Utils.printValue(101, "Alice");
        Utils.printValue("Age", 25);
    }
}
