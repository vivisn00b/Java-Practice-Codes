import java.util.Scanner;

public class multidim {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6},
                {7, 8, 9}
        };

        int collen = arr.length; //length of column
        int rowlen = arr[0].length; //length of row

        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                System.out.print(arr[row][col] + " ");
            }
            System.out.println();
        }
        multidim obj = new multidim();
        obj.arrinput();
    }
    public void arrinput() {
        Scanner scn = new Scanner(System.in);

        // Taking Number of Rows and Columns from User
        System.out.print("Enter number of rows: ");
        int row = scn.nextInt();

        System.out.print("Enter number of columns: ");
        int col = scn.nextInt();

        int[][] arr= new int[row][col];

        // Operating on Two Dimensional Array
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j]= (i + 1) * (j + 1);
            }
        }

        // Printing Elements of Arrays
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(arr[i][j]+ " ");
            }

            System.out.println();
        }
        scn.close();
    }
}