class Database {

    //Runs once when the class is loaded
    static {
        System.out.println("Static Initializer Block: Connecting to database...");
    }

    public static void connect() {
        System.out.println("Database connected.");
    }
}

public class Main {
    public static void main(String[] args) {
        Database.connect();
        Database.connect();  // Static block doesn't run again
    }
}
