package Sorting;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;

public class SortingEx {
    public static void main(String[] args) {
        SortingEx.arraysort();
        SortingEx.sortmethod();
        SortingEx.sortofcollections();
    }

    public static void arraysort() {
        int[] arr = {1,8,0,50,14,3,100};
        for (int i=0; i<arr.length; i++) {
            for (int j=i+1; j<arr.length; j++) {
                int temp = 0;
                if (arr[j] < arr[i]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            // Printing sorted array elements
            System.out.print(arr[i] + " ");
        }
    }

    public static void sortmethod() {
        int[] arr = { 13, 7, 6, 45, 21, 9, 101, 102 };
        Arrays.sort(arr);
        //Arrays.sort(arr, 1, 5); //sorting a subarray
        System.out.printf("Modified arr[] : %s", Arrays.toString(arr));
        Integer[] a = { 13, 7, 6, 45, 21, 9, 2, 100 };
        Arrays.sort(a, Collections.reverseOrder());
        System.out.printf("Modified arr[] : %s", Arrays.toString(arr));
    }

    public static void sortofcollections() {
        ArrayList<String> al = new ArrayList<String>();
        al.add("B");
        al.add("C D");
        al.add("A");
        al.add("E");
        al.add("F G");
        Collections.sort(al);
        System.out.println("List after the use of" + " Collection.sort() :\n" + al);
    }
}
