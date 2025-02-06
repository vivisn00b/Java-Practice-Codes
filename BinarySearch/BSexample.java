package BinarySearch;

public class BSexample {
    public static void main(String args[]) {
        BSexample obj = new BSexample();
        int arr[] ={10,20,40,50,60,99};
        int l = arr.length;
        int search = 50;
        int res = obj.binarysearch(arr, l, search);
        if (res == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index: " + res);
    }

    public int binarysearch(int a[], int len, int x) {
        int start = 0;
        int end = len-1;
        while (start <= end) {
            int mid = (start + end)/2;
            if (x < a[mid])
                end = mid-1;
            else if (x > a[mid])
                end = mid+1;
            else
                return mid;
        }
        return -1;
    }
}
