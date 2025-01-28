import java.util.Scanner;
import java.util.ArrayList;

class ALfunctions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //System.out.println("Enter the size of ArrayList:");
        //int l = sc.nextInt(); //input 2
        ArrayList<Integer> al = new ArrayList<>();
        //ArrayList<Integer> al = new ArrayList<>(l);
        System.out.println("Initial size: " + al.size()); //will show 0
        al.add(1);
        al.add(2);
        al.add(3); //will take more elements than list size
        al.add(4);
        al.add(4, 10000); //inserting element at specific index
        al.remove(1); //removes at index
        al.set(0,100); //updating value at index 0
        System.out.println("Final size: " + al.size()); //size changes unlike arrays
        for(int e : al) {
            System.out.println(e); //will print more than 2 outputs if inputs are more
        }
        System.out.println(al.get(2)); //returns element at index 2
        System.out.println(al.indexOf(100)); //retuens index of specified element

        ArrayList<String> l1 = new ArrayList<>();
        l1.add("Java");
        l1.add("C++");
        ArrayList<String> l2 = new ArrayList<>();
        l2.add("C");
        l1.addAll(l2);
        ArrayList<String> l3 = new ArrayList<>();
        l3.add("PHP");
        l3.add("JavaScript");
        l1.addAll(0, l3); //add at specific index
        System.out.println("" + l1);
        l1.remove("C"); //remove a specified element
        System.out.println(l1);

        //clearing all elements from arraylist
        l1.clear();
        System.out.println("List after clearing:" + l1);

        ArrayList<String> n = new ArrayList<>(4);
        n.add("Ram");
        n.add("Shyam");
        n.add("Hari");
        n.add("Viv");
        n.add("John");
        String r = n.set(2, "Harry"); //replacing at index 2
        System.out.println("Replaced element:" + r + "\n" + "New list:" + n);
        System.out.println("Size before trim: " + n.size());
        n.trimToSize();
        //Printing the size after trimming
        System.out.println("Size after trim: " + n.size());
        System.out.println(n);
    }
}
