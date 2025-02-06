package Sorting;

public class selectionSort {
    public static void main(String[] args) {
        int[] arr = {20, 10, 9, 100, 45, 35, 30};
        int l = arr.length;
        for (int i=0; i<l-1; i++) {
            int min = i;
            for (int j=i+1; j<l; j++) {
                if (arr[j] < arr[min])
                    min = j;
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        for (int element : arr) {
            System.out.print(element + " ");
        }
    }
}
