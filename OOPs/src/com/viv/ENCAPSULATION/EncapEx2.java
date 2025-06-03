// using abstraction

package OOPs.src.com.viv.ENCAPSULATION;

class Area {
    private int l;
    private int b;

    Area(int l, int b) {
        this.l = l;
        this.b = b;
    }

    public void getArea() {
        int area = l*b;
        System.out.println("Area is: " + area);
    }
}

public class EncapEx2 {
    public static void main(String[] args) {
        Area rectangle = new Area(10, 6);
        rectangle.getArea();
    }
}
