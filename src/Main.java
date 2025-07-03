import static divideAndConquer.MergeSortCC.printArr;
import static twoDimensinalArray.SpiralMatrix.printSpiral;

public class Main {
    public static void spiral(int[][] arr) {
        int startCol = 0;
        int startRow = 0;
        int endCol = arr[0].length - 1;
        int endRow = arr.length - 1;

        while (startRow <= endRow && startCol <= endCol) {
            for (int j = startCol; j <= endCol; j++) {
                System.out.print(arr[startRow][j] + " ");
            }
            for (int i = startRow + 1; i <= endRow; i++) {
                System.out.print(arr[i][endCol] + " ");
            }
            for (int j = endCol - 1; j >= startCol; j--) {
                if (startRow == endRow) break;
                System.out.print(arr[endRow][j] + " ");
            }
            for (int i = endRow - 1; i >= startRow + 1; i--) {
                if (startCol == endCol) break;
                System.out.print(arr[i][startCol] + " ");
            }
            startCol++;
            startRow++;
            endCol--;
            endRow--;
        }
    }

    public static void findInMatrix(int[][] arr, int key) {
        int row = 0, col = arr[0].length - 1;

        while (row < arr.length && col >= 0) {
            if (arr[row][col] == key) {
                System.out.print(row + " " + col);
                break;
            } else if (arr[row][col] < key) {
                row++;
            } else {
                col--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,3,4}, {5,6,7,8,9}, {10,11,12,13,14}, {15,16,17,18,19}};
        findInMatrix(matrix, 19);
     }
}