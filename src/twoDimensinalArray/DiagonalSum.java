package twoDimensinalArray;

public class DiagonalSum {
    public static int diagonalSum(int[][] matrix) { //O(n^2)
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if (i == j) {
                    sum += matrix[i][j];
                } else if(i + j == matrix.length - 1) {
                    sum += matrix[i][j];
                }
            }
        }
        return sum;
    }

    public static void optimizedDiagSum(int[][] arr) { // O(n)
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            //pd
            sum += arr[i][i];
            //sd
            if (i != arr.length - 1 - i)
                sum += arr[i][arr.length - i - 1];
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        optimizedDiagSum(matrix);
    }
}
