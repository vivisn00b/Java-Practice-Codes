// Abstraction is the process of hiding the implementation details.
// It only shows the essential details or features to the user.

package OOPs.src.com.viv.ABSTRACTION;

abstract class Electionic {
    // Abstract methods declared without implementation.
    abstract void turnOn();
    abstract void turnOff();
}

// Concrete class
class TVremote extends Electionic {
    @Override
    void turnOn() {
        System.out.println("TV is turned ON");
    }

    @Override
    void turnOff() {
        System.out.println("TV is Turned OFF");
    }
}

public class AbstractEx {
    public static void main(String[] args) {
        // There can be no object of an abstract class.
        // That is, an abstract class can't be directly instantiated with the new operator.
        Electionic remote = new TVremote();
        remote.turnOn();
        remote.turnOff();
    }
}
