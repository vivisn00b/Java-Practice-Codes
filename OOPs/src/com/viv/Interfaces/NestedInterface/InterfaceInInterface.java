package OOPs.src.com.viv.Interfaces.NestedInterface;

interface Outer {
    void display();

    interface Nested {
        void message();
    }
}

class Demo implements Outer.Nested {
    public void message() {
        System.out.println("Nested Interface inside Interface");
    }
}

public class InterfaceInInterface {
    public static void main(String[] args) {
        Outer.Nested obj = new Demo();
        obj.message();  // Output: Nested Interface inside Interface
    }
}
