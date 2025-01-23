public class methodoverloading {
    public static void main(String[] args) {
        int ans = sum(3, 4, 7); //static methods doesn't need objects to access them
        System.out.println(ans);

        methodoverloading obj = new methodoverloading();
        obj.show("Viv");
        byte a=1;
        obj.show(a);
        int b=100;
        obj.show(b);
    }
    static int sum(int a, int b) {
        return a+b;
    }
    static int sum(int a, int b, int c) {
        return a+b+c;
    }
    public void show(int x)
    {
        System.out.println("In int: " + x);
    }
    public void show(String s)
    {
        System.out.println("In String: " + s);
    }
    public void show(byte b)
    {
        System.out.println("In byte: " + b);
    }
}