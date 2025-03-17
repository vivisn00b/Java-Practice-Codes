// 3. Use of super with constructors

package OOPs.src.com.viv.SuperExample;


class Bird {
    String name;

    // Constructor of the superclass
    public Bird(String name) {
        this.name = name;
        System.out.println("Bird constructor: " + name);
    }
}

class Parrot extends Bird {
    // Constructor of the subclass
    public Parrot(String name) {
        // Call the superclass constructor using 'super'
        super(name);
        System.out.println("Parrot constructor: " + name);
    }
}

public class SuperConstructors {
    public static void main(String[] args) {
        Parrot parrot = new Parrot("Buddy");

        // System.out.println(parrot);
    }
}
