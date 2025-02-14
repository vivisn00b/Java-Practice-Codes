package Arrays;

import java.util.Arrays;

public class arrfunctions {
    public static void main(String[] args) {
        // Declaring array literal  
        //int[] intArray = new int[]{ 1,2,3,4,5,6,7,8,9,10 }; 
        //System.out.println(Arrays.toString(new int[]{1,2,3,4,5}));
        
        int[] numbers = {3, 5, 1, 4, 2};

        // Arrays.toString() - Prints the array as a string
        System.out.println("Array as a string: " + Arrays.toString(numbers));

        // Arrays.sort() - Sorts the array
        Arrays.sort(numbers);
        System.out.println("Sorted array: " + Arrays.toString(numbers));

        // Arrays.binarySearch() - Searches for an element in a sorted array
        int index = Arrays.binarySearch(numbers, 4);
        System.out.println("Index of 4: " + index);

        // Arrays.copyOf() - Copies the array to a new array
        int[] copiedArray = Arrays.copyOf(numbers, numbers.length);
        System.out.println("Copied array: " + Arrays.toString(copiedArray));

        // Arrays.fill() - Fills the array with a specific value
        Arrays.fill(numbers, 7);
        System.out.println("Array after filling with 7: " + Arrays.toString(numbers));

        // Arrays.equals() - Checks if two arrays are equal
        int[] anotherArray = {7, 7, 7, 7, 7};
        boolean areEqual = Arrays.equals(numbers, anotherArray);
        System.out.println("Are the arrays equal? " + areEqual);

        // Arrays.hashCode() - Generates a hash code for the array
        int hashCode = Arrays.hashCode(numbers);
        System.out.println("Hash code of the array: " + hashCode);

        // Arrays.deepToString() - Prints multidimensional array
        int[][] multiArray = {{1, 2, 3}, {4, 5, 6}};
        System.out.println("Multidimensional array: " + Arrays.deepToString(multiArray));

        // Arrays.parallelSort() - Sorts the array in parallel (useful for large arrays)
        int[] largeArray = {12, 3, 56, 8, 34, 23, 90};
        Arrays.parallelSort(largeArray);
        System.out.println("Array sorted in parallel: " + Arrays.toString(largeArray));

        // Arrays.asList() - Returns a fixed-size list backed by the specified Arrays
        System.out.println("Integer Array as List: " + Arrays.asList(numbers));

        // binarySearch() - Searches for the specified element in the array with the help of the Binary Search Algorithm
        Arrays.sort(numbers);
        int intKey = 22;
        System.out.println(intKey + " found at index = " + Arrays.binarySearch(numbers, intKey));

        // compare(array 1, array 2) - Compares two arrays passed as parameters lexicographically
        int intArr[] = { 10, 20, 15, 22, 35 };
        int intArr1[] = { 10, 15, 22 };
        int intArr2[] = {100, 1000, 520};
        int intArr3[] = { 10, 20, 15, 22, 35 };
        System.out.println("Integer Arrays on comparison(different arrays but other one is a subset of larger array): " + Arrays.compare(intArr, intArr1));
        System.out.println("Integer Arrays on comparison(different arrays): " + Arrays.compare(intArr, intArr2));
        System.out.println("Integer Arrays on comparison(same arrays): " + Arrays.compare(intArr, intArr));
        System.out.println("Integer Arrays on comparison(different arrays but same value): " + Arrays.compare(intArr, intArr3));

        // mismatch(array1, array2) - Finds and returns the index of the first unmatched element between the two specified arrays
        System.out.println("The element mismatched at index: "
                + Arrays.mismatch(intArr2, intArr3));
    }
}
