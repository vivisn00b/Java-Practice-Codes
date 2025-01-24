package Methods;

public class shadowing {
    static int x = 90; // this will be shadowed at line 8
    public static void main(String[] args) {
        System.out.println(x); // 90
        int x; // the class variable at line 4 is shadowed by this
        // System.out.println(x); //will throw error, scope will begin when value is initialised
        x = 40;
        System.out.println(x); // 40
        show();
    }

    static void show() {
        System.out.println(x);
    }
}
