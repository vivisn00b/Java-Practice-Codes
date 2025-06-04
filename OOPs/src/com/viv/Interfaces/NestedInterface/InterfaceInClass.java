class Outer {
    // Nested interface
    public interface NestedInterface {
        void greet();
    }
}

class Inner implements Outer.NestedInterface {
    public void greet() {
        System.out.println("Hello from nested interface!");
    }
}

public class InterfaceInClass {
    public static void main(String[] args) {
        Outer.NestedInterface obj = new Inner();
        obj.greet();  // Output: Hello from nested interface!
    }
}
