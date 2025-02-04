package BinarySearch;
import java.util.Arrays;

public class BSrecursive {
    int binarySearch(int a[], int l, int r, int x)
    {
        if (r >= l) {
            int m = l + (r - l) / 2;
            if (a[m] == x)
                return m;
            if (a[m] > x)
                return binarySearch(a, l, m - 1, x);
            return binarySearch(a, m + 1, r, x);
        }
        return -1;
    }

    public static void main(String args[])
    {
        BSrecursive ob = new BSrecursive();
        int a[] = { 2, 3, 4, 10, 40 };
        int n = a.length;
        int x = 10;

        int res = ob.binarySearch(a, 0, n - 1, x);

        if (res == -1)
            System.out.println(
                    "Element is not present in array");
        else
            System.out.println("Element is present at index " + res);
    }
}
