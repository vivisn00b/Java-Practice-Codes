package Methods;
//linked with methodoverriding.java & animal.java
public class overriding extends methodoverriding {
    @Override void move() {
        System.out.println("A dog which is an animal is moving");
    }
    void bark() {
        System.out.println("Dog is barking");
    }
}

