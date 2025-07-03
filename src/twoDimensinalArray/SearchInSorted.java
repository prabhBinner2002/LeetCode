package twoDimensinalArray;

public class SearchInSorted {
    public static boolean stairCaseSearchTopRightStart(int[][] arr, int key) {
        int row = 0, col = arr[0].length - 1;

        while (row < arr.length && col >= 0) {
            if(arr[row][col] == key) {
                System.out.println("key found at (" + row + "," + col +")");
                return true;
            } else if (key < arr[row][col]) {
                col--;
            } else {
                row++;
            }
        }

        return false;
    }

    public static boolean stairCaseSearchBottomLeftStart(int[][] arr, int key) {
        int row = arr.length - 1, col = 0;

        while (row >= 0 && col < arr[0].length) {
            if(arr[row][col] == key) {
                System.out.println("key found at (" + row + "," + col +")");
                return true;
            } else if (key < arr[row][col]) {
                row--;
            } else {
                col++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{10,20,30,40},{15,25,35,45},{27,29,37,48},{32,33,39,50}};
        int key = 33;
        stairCaseSearchBottomLeftStart(matrix, key);
    }
}
