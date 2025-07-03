package twoDimensinalArray.assignmentQs2DArrays;

import java.util.HashMap;

public class NumOfDuplicates {
    public static int getDuplicates(int[][] arr, int key) { // O(n^2)
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] ints : arr) {
            for (int j = 0; j < arr[0].length; j++) {
                map.put(ints[j], map.getOrDefault(ints[j], 0) + 1);
            }
        }

        return map.get(key) == null ? 0 : map.get(key);
    }

    public static void main(String[] args) {
        int[][] matrix = {{4,7,8},{8,8,7}};
        int key = 7;
        System.out.println("Number of " + key + "s: " + getDuplicates(matrix, key));
    }
}
