package OOPs.src.com.viv.TypesOfClasses;

import java.io.*;
import java.lang.*;
import java.util.*;

interface X {
    int product(int x, int y);
}

abstract class Product implements X {
    public int product(int x, int y) { return x * y; }
}

class abstractClass2 extends Product {
    public static void main(String args[]) {
        abstractClass2 ob = new abstractClass2();  // Corrected the class name from 'Main' to 'GFG'
        int p = ob.product(20, 10);
        System.out.println("Product: " + p);
    }
}

// By inheriting Product, "abstractClass2" gets access to the product() method that already implements the logic for multiplying two numbers.
// There's no need for "abstractClass2" to implement this method from scratch.