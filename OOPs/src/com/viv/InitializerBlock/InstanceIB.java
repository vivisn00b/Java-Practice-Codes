class Person {
    String name;

    // Instance initializer block
    // Runs everytime an object is created
    {
        System.out.println("Instance Initializer Block: Object is being created.");
    }

    // Constructor
    public Person(String name) {
        this.name = name;
        System.out.println("Constructor: Name is " + name);
    }
}

public class InstanceIB {
    public static void main(String[] args) {
        Person p1 = new Person("Alice");
        Person p2 = new Person("Bob");
    }
}
