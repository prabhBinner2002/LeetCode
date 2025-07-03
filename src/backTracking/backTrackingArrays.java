package backTracking;

import static divideAndConquer.MergeSortCC.printArr;

public class backTrackingArrays {
    public static void changeArr(int[] arr, int i, int v) {
        if (i == arr.length) { // Base Case
            printArr(arr);
            return;
        }

        // recursion
        arr[i] = v;
        changeArr(arr, i+1, v+1); //fnx call step
        arr[i] = arr[i] - 2; //backtracking step
    }

    public static void main(String[] args) {
        int[] arr = new int[5];
        changeArr(arr, 0 , 1);
        printArr(arr);
    }
}
