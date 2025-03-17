// 2. Using this() to invoke current class constructor

package OOPs.src.com.viv.ThisExample;

class Animal {
    private String species;
    private int age;

    Animal() {
        this("Dog", 5);
        System.out.println("Inside default constructor");
    }

    Animal(String species, int age) {
        this.species = species;
        this.age = age;
        System.out.println("Inside parameterized constructor");
        //System.out.println(species + " " + age);
    }

    void display() {
        System.out.println("Animal specie: " + species);
        System.out.println(species + "'s age: " + age);
    }
}

public class ThisConstructor {
    public static void main(String[] args) {
        Animal animal = new Animal();
        //Animal animal1 = new Animal("Cat", 3);
        animal.display();
        //animal1.display();
    }
}
