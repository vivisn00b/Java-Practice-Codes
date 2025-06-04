// Default and static methods in interface

interface MyInterface {
    void show();  // abstract

    default void greet() {
        System.out.println("Hello from default method!");
    }

    static void info() {
        System.out.println("Static method in interface");
    }
}

class MyClass implements MyInterface {
    public void show() {
        System.out.println("Implemented show()");
    }
}

public class InterfaceEx {
    public static void main(String[] args) {
        MyInterface obj = new MyClass();
        obj.show();     // Output: Implemented show()
        obj.greet();    // Output: Hello from default method!
        MyInterface.info(); // Output: Static method in interface
    }
}
