package Methods;
//linked with methodoverriding.java & animal.java
public class overriding extends methodoverriding {
    @Override void move() {
        System.out.println("A dog which is an animal is moving");
    }
    void bark() {
        System.out.println("Dog is barking");
    }
    public static void main(String[] args) {
        methodoverriding dog = new methodoverriding();
        dog.move();
        overriding obj = new overriding();
        obj.move();
        obj.bark();
        obj.eat();
    }
}

