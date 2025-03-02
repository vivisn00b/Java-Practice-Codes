package OOPs.src.com.viv.InnerClass;

public class InnerClassExample {
    private int outerVar;

    public InnerClassExample(int var) {
        outerVar = var;
    }

    public void outerMethod() {
        System.out.println("This is an outer method");
    }

    // Inner class
    public class InnerClass {
        private int innerVar;

        public InnerClass(int var) {
            innerVar = var;
        }

        public void innerMethod() {
            System.out.println("This is an inner method");
        }

        public void accessOuterVar() {
            System.out.println("Outer variable from inner class: " + outerVar);
        }
    }

    public static void main(String[] args) {
        // Create an instance of the outer class
        InnerClassExample outer = new InnerClassExample(10);

        // Create an instance of the inner class
        InnerClassExample.InnerClass inner = outer.new InnerClass(20);

        // Access the inner class methods
        inner.innerMethod();
        inner.accessOuterVar();
    }
}
