//import java.util.ArrayList;
//
//public class Main {
//    public static void main(String[] args) {
//        ArrayList list = new ArrayList();
//        list.add("Hello");
//        list.add(123);
//        list.add(3.14);
//
//        String str = (String) list.get(0);
//        String str1 = (String) list.get(1);
//
//    }
//}
//
//Above code has 3 major issues:
//1. No Type safety
//2. Manual casting
//3. No Compile Time checking
//
//Generic type is a class or interface parameterized over types. Generic types allow you to define a class, interface, or method with placeholders (type parameters) for the data types they will work with.
//This enables code reusability and type safety, as it allows you to create classes, interfaces, or methods that can operate on various types without needing to rewrite the code for each type.

package Generics;

class Person<T> {
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

class Account<K, V> {
    private K acc;
    private V pass;

    public Account(K acc, V pass) {
        this.acc = acc;
        this.pass = pass;
    }

    public K getAcc() {
        return acc;
    }

    public V getPass() {
        return pass;
    }
}

public class GenericTypesClass {
    public static void main(String[] args) {
        Person<Integer> age = new Person<>();  //Box is now type safe
        age.setValue(21);
        int a = age.getValue();
        Person<String> name = new Person<>();
        name.setValue("Viv");
        String n = name.getValue();
        System.out.println("Name: " + n + '\n' + "Age: " + a);

        Account<String, Integer> acc = new Account<>("viv1", 634792);
        System.out.println("Username: " + acc.getAcc());
        System.out.println("Password: " + acc.getPass());
    }
}