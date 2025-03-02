package OOPs.src.com.viv.InnerClass;

class OutClass {
    public void outerMethod() {
        System.out.println("Inside outer method");

        // Defining an inner class inside a method
        class MethodLocalInner {
            void display() {
                System.out.println("Hello from method-local inner class!");
            }
        }

        // Creating an instance of the inner class
        MethodLocalInner inner = new MethodLocalInner();
        inner.display();
    }
}


public class methodLocalinnerClass {
    public static void main(String[] args) {
        OutClass outer = new OutClass();
        outer.outerMethod();
    }
}
