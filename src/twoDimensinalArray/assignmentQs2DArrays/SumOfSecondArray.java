package twoDimensinalArray.assignmentQs2DArrays;

public class SumOfSecondArray {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{11,4,3},{2,2,3}};
        int sum = 0;
        for(int j = 0; j < arr[0].length; j++) {
            sum += arr[1][j];
        }
        System.out.println(sum);
    }
}
