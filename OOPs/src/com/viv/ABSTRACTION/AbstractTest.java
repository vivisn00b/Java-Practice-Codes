package OOPs.src.com.viv.ABSTRACTION;

abstract class Animals {
    private String type;
    private String name;

    public Animals(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public abstract void makeSound();

    public void getDesc() {
        System.out.println("Animal type: " + type + ", name: " + name);
    }
}

class Dogs extends Animals {
    public Dogs(String type, String name) {
        super(type, name);
    }

    //@Override
    //public String getDesc() {
    //    return super.getDesc();
    //}

    public void makeSound() {
        getDesc();
        System.out.println("It barks!!!");
    }
}

public class AbstractTest {
    public static void main(String[] args) {
        Animals myDog = new Dogs("Doggy", "Max");
        myDog.makeSound();
    }
}
