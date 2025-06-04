// Java does not support multiple inheritance with class.
// It can only be done through interfaces.
// The primary reason is to avoid the "diamond problem," where a class inherits from two classes that have a common ancestor.
// Imagine a class D inheriting from both class B and class C, and both B and C inherit from class A. If A has a method that B and C override, which version of the method should D inherit? This ambiguity makes the code difficult to understand and maintain.

package OOPs.src.com.viv.INHERITANCE;

interface Coder {
    void writeCode();
}

interface Tester {
    void testCode();
}

class JavaDeveloper implements Coder, Tester {
    @Override
    public void writeCode() {
        System.out.println("Java Dev writes code in Java!");
    }

    @Override
    public void testCode() {
        System.out.println("Java Devs tests for bugs and fixes!");
    }

    public void deploy() {
        System.out.println("Java Devs deploys code to cloud or application server!");
    }
}

public class multipleInherit {
    public static void main(String[] args) {
        JavaDeveloper dev = new JavaDeveloper();
        dev.writeCode();
        dev.testCode();
        dev.deploy();
    }
}
