package OOPs.src.com.viv.StaticExample;

import java.util.Arrays;

public class innerClass {
    static class Test {
        String name;
        public Test(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return name;
        }
    }

    public static void main(String[] args) {
        Test a = new Test("Vivy");
        Test b = new Test("Rahul");
        System.out.println(a);
//      System.out.println(a.name);
        System.out.println(b.name);
    }
}

//static class A {
//
//}