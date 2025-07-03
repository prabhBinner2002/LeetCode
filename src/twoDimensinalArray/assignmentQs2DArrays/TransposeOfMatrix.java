package twoDimensinalArray.assignmentQs2DArrays;

public class TransposeOfMatrix {
    public static void getTranspose(int[][] arr) {
        int[][] transposedMatrix = new int[arr[0].length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                transposedMatrix[j][i] = arr[i][j];
            }
        }

        for(int[] i : transposedMatrix) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        getTranspose(arr);
    }
}
