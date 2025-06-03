// using interface
// it is a key mechanism to achieve abstraction

package OOPs.src.com.viv.ABSTRACTION;

interface Shape {
    double Area();
}

class Square implements Shape {
    private double s;
    Square(double s) {
        this.s = s;
    }
    public double Area() {
        return Math.pow(s,2);
    }
}

public class AbstractEx2 {
    public static void main(String[] args) {
        Square sq = new Square(10.2);
        System.out.println("Area of square is:" + sq.Area());
    }
}
