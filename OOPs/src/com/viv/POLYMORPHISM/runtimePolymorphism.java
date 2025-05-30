// Runtime Polymorphism in Java known as Dynamic Method Dispatch.
// It is a process in which a function call to the overridden method is resolved at Runtime.

package OOPs.src.com.viv.POLYMORPHISM;

class Parent {
    void Print() {
        System.out.println("parent class");
    }
}

class subclass1 extends Parent {
    void Print() {
        System.out.println("subclass1");
    }
}

class subclass2 extends Parent {
    void Print() {
        System.out.println("subclass2");
    }
}

public class runtimePolymorphism {
    public static void main(String[] args) {

        // Creating object of class 1
        Parent a;

        // Now we will be calling print methods
        // inside main() method
        a = new subclass1();
        a.Print();

        a = new subclass2();
        a.Print();
    }
}