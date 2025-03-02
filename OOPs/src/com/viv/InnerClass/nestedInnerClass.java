package OOPs.src.com.viv.InnerClass;

class OuterClass {
    private String outerField = "I’m an outer class field!";

    // Inner class
    public class InnerClass {
        public void display() {
            System.out.println("Accessing outer field: " + outerField);
        }
    }

}

public class nestedInnerClass {
    public static void main(String[] args) {
        // Create an instance of the outer class
        //OuterClass outer = new OuterClass();

        // Create an instance of the inner class
        //OuterClass.InnerClass inner = outer.new InnerClass();

        // Another way of creating inner class object
        OuterClass.InnerClass inner = new OuterClass().new InnerClass();

        // Call the inner class method
        inner.display();
    }
}
