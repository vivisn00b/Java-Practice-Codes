package OOPs.src.com.viv.INHERITANCE;

// Parent class
class inheritExample {
    String name;

    // Constructor
    public inheritExample(String name) {
        this.name = name;
    }

    // Method to display name
    public void display() {
        System.out.println("Name: " + name);
    }
}

// Child class inheriting from inheritExample
class childExample extends inheritExample {
    int age;

    // Constructor
    public childExample(String name, int age) {
        super(name); // Call parent class constructor
        this.age = age;
    }

    // Overriding display method
    @Override
    public void display() {
        //System.out.println("Name: " + name);
        super.display(); // Call parent class method
        System.out.println("Age: " + age);
    }
}

class Main {
    public static void main(String[] args) {
        childExample obj = new childExample("John", 25);
        obj.display();
    }
}
