package OOPs.src.com.viv.TypesOfClasses;

// A class that is marked final cannot be subclasses.
// useful when creating immutable classes such as  String classes

// final class Base {
class Base {
    void Display()
    {
        System.out.println("Method for Base class.");
    }
}

class Extended extends Base {

    void Display()
    {
        System.out.print("Method of Extended class.");
    }
}

class finalClass {

    public static void main(String[] arg)
    {
        Base Subclass = new Base();
        Subclass.Display();

        Extended d = new Extended();
        d.Display();
    }
}