package Collections.ListInterface.Arraylists;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ALexample {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // Syntax
        ArrayList<Integer> list = new ArrayList<>(5);

        //        list.add(67);
        //        list.add(234);
        //        list.add(654);
        //        list.add(43);
        //        list.add(654);
        //        list.add(8765);

        //        System.out.println(list.contains(765432));
        //        System.out.println(list);
        //        list.set(0, 99);
        
        //        list.remove(2);
        
        //        System.out.println(list);

        // input
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter element " + i + ": ");
            list.add(in.nextInt());
        }

        boolean hasNum = list.contains(2);
        System.out.println(hasNum);

        // get item at any index
        for (int i = 0; i < 5; i++) {
            System.out.print(list.get(i) + "\t"); // pass index here, list[index] syntax will not work here
        }
        System.out.println();

        System.out.println(list);

        Object[] arr = list.toArray();
        System.out.println(arr.getClass() + Arrays.toString(arr));
        //Integer[] array = list.toArray(new Integer[0]);  // the toArray() method will internally allocate a new array of the correct size
        Integer[] array = list.toArray(new Integer[list.size()]);  // preallocate an array size, if the array is large enough, toArray() will reuse your array instead of creating a new one.
        for (int i = 0; i < 5; i++) {
            System.out.println("Element " + i + ": " + array[i]);
        }

        list.sort(Comparator.naturalOrder());  // ascending order
        list.sort(Comparator.reverseOrder());  // descending order
        list.sort(null);  // If you pass null, Java treats it as "use the natural ordering of elements"
        System.out.println("Sorted list:" + list);
    }
}
