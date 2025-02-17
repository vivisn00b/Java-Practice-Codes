package OOPs.src.com.viv.StaticExample;

public class StaticExample {

    // Static variable
    static int staticVariable = 10;

    // Non-static variable
    int nonStaticVariable = 5;

    public static void main(String[] args) {
        // Local variable in main method
        int localMainVariable = 100;

        // Accessing static method and variable inside main
        System.out.println("Static Variable (in main): " + StaticClass.staticVariable);
        StaticClass.staticMethod();

        // Accessing local variable inside main method
        System.out.println("Local Variable in main: " + localMainVariable);

        // Creating an instance of StaticClass to access non-static methods
        StaticClass staticClassInstance = new StaticClass();
        staticClassInstance.nonStaticMethod();

        // Modifying static variable through class name
        StaticClass.staticVariable = 20;
        System.out.println("Updated Static Variable: " + StaticClass.staticVariable);

        // Accessing non-static method of outer class
        StaticExample outerClassInstance = new StaticExample();
        outerClassInstance.nonStaticMethodInOuterClass();
    }

    // Static method in outer class
    static void staticMethodInOuterClass() {
        // Local variable inside the static method
        int localStaticMethodVariable = 200;
        System.out.println("This is a static method in the outer class.");

        // Accessing local variable
        System.out.println("Local Variable in staticMethodInOuterClass: " + localStaticMethodVariable);
    }

    // Non-static method in outer class
    void nonStaticMethodInOuterClass() {
        // Local variable inside the non-static method
        int localNonStaticMethodVariable = 300;
        System.out.println("This is a non-static method in the outer class.");
        System.out.println("Non-static variable in outer class: " + nonStaticVariable);

        // Accessing local variable
        System.out.println("Local Variable in nonStaticMethodInOuterClass: " + localNonStaticMethodVariable);
    }

    // Static inner class
    static class StaticClass {

        // Static variable in the static inner class
        static int staticVariable = 30;

        // Non-static variable in the static inner class
        int nonStaticVariable = 50;

        // Static method inside the static inner class
        static void staticMethod() {
            // Local variable inside the static method
            int localStaticInnerMethodVariable = 400;
            System.out.println("This is a static method inside the static inner class.");

            // Accessing local variable
            System.out.println("Local Variable in staticMethod inside StaticClass: " + localStaticInnerMethodVariable);
        }

        // Non-static method inside the static inner class
        void nonStaticMethod() {
            // Local variable inside the non-static method
            int localNonStaticInnerMethodVariable = 500;
            System.out.println("This is a non-static method inside the static inner class.");
            System.out.println("Non-static variable in static inner class: " + nonStaticVariable);

            // Accessing local variable
            System.out.println("Local Variable in nonStaticMethod inside StaticClass: " + localNonStaticInnerMethodVariable);
        }
    }
}
