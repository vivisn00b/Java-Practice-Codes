package OOPs.src.com.viv.InnerClass;

class OuterClass {
    private String outerField = "I’m an outer class field!";

    // Inner class
    public class InnerClass {
        private String innerField = "I'm a inner class field!";
        // Nested inner class inside inner class
        class NestedInner {
            public void display() {
                System.out.println("Printing from nested inner class");
                System.out.println("Accessing outer field: " + outerField);
                System.out.println("Accessing inner field: " + innerField);
            }
        }
    }

}

public class NestedInnerClass {
    public static void main(String[] args) {
        // Create an instance of the outer class
        //OuterClass outer = new OuterClass();

        // Create an instance of the inner class
        //OuterClass.InnerClass inner = outer.new InnerClass();

        // Another way of creating inner class object
        //OuterClass.InnerClass inner = new OuterClass().new InnerClass();

        OuterClass.InnerClass.NestedInner nested = new OuterClass().new InnerClass().new NestedInner();
        
        // Call the inner class method
        nested.display();
    }
}
