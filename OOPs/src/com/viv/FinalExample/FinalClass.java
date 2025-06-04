// This class cannot be extended
final class Vehicle {
    public void startEngine() {
        System.out.println("Engine started.");
    }
}

// Attempting to extend this will result in a compilation error
/*
class Car extends Vehicle {  // Error: Cannot inherit from final class 'Vehicle'
    public void playMusic() {
        System.out.println("Playing music...");
    }
}
*/

public class FinalClass {
    public static void main(String[] args) {
        Vehicle v = new Vehicle();
        v.startEngine();  // Output: Engine started.
    }
}
