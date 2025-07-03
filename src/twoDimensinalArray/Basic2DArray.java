package twoDimensinalArray;

import java.util.Scanner;

public class Basic2DArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[3][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int largest = Integer.MIN_VALUE, smallest = Integer.MAX_VALUE;

        for (int[] i : arr) {
            for (int j :i) {
                System.out.print(j + " ");
                largest = Math.max(largest, j);
                smallest = Math.min(smallest, j);
            }
            System.out.println();
        }
        System.out.println("Largest: " + largest + " | Smallest: " + smallest);
    }
}
