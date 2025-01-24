package Methods;

import java.util.Arrays;

public class varargs {
    public static void main(String[] args) {
//        multiple(2, 3, "Viv", "Rahul", "git");
        demo(1,2,3,4,5,6);
        demo("Viv", "vi", "v");
        fun(10,20,30);
    }

    static void demo(int ...v) {
        for (int i : v) {
            System.out.println(i);
        }
    }

    static void demo(String ...v) {
        System.out.println(Arrays.toString(v));
    }

    static void multiple(int a, int b, String ...v) {
//        System.out.println(a + " " + b + " " + Arrays.toString(v));
    }

    static void fun(int ...v) {
//        System.out.println(v);
        System.out.println("Number of arguments: " + v.length);
        System.out.println(Arrays.toString(v));
    }
}
