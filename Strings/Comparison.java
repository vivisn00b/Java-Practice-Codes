package Strings;

public class Comparison {
    public static void main(String[] args) {
        String a = "Vivek";
        String b = "Vivek";
        String c = a;
//        System.out.println(c == a);
//        System.out.println(a == b);

        String name1 = new String("Viv");
        String name2 = new String("Viv");

        System.out.println(name1 == name2);

        System.out.println(name1.equals(name2));

    }
}
