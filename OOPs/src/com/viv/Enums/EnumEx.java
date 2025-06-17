package OOPs.src.com.viv.Enums;

// enum is declared outside any class
enum Colour {
    RED, BLUE, YELLOW, BLACK, WHITE;
}

public class EnumEx {
    // enum declaration inside a class.
    enum Cloth {
        Shirt, Tshirt, pant, kurti;
    }
    public static void main(String[] args) {
        Colour c1 = Colour.BLACK;
        Cloth c2 = Cloth.Shirt;
        System.out.println(c2 + "'s colour is " + c1);
    }
}
