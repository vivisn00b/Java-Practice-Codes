// Using this() for Constructor Chaining in the Same Class
//
package com.viv.Constructors;

public class conChaining2 {
}

class Rectangle {
    int length, width;

    // Constructor with two parameters
    Rectangle(int l, int w) {
        length = l;
        width = w;
    }

    // Constructor with one parameter, calling the two-parameter constructor
    Rectangle(int side) {
        this(side, side); // Calling the Rectangle(int, int) constructor
    }

    void display() {
        System.out.println("Length: " + length + ", Width: " + width);
    }

    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle(10, 5);
        Rectangle square = new Rectangle(7);

        rect1.display();
        square.display();
    }
}
