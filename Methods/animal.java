package Methods;
//linked with methodoverriding.java & overriding.java
public class animal {
    public static void main(String[] args) {
        overriding ovrd = new overriding();
        ovrd.move();
        ovrd.eat(); //will print from methodoverriding class as it inherits its properties
        ovrd.bark();
    }
}
