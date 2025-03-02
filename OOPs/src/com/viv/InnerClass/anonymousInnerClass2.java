// Creating anonymous inner class as an implementer of specified interface

package OOPs.src.com.viv.InnerClass;

interface Greeting {
    void sayHello();
}

public class anonymousInnerClass2 {
    public static void main(String[] args) {
        // Creating an anonymous inner class that implements the Greeting interface
        Greeting greeting = new Greeting() {
            @Override
            public void sayHello() {
                System.out.println("Hello from the anonymous inner class!");
            }
        };

        // Calling the method
        greeting.sayHello();
    }
}
