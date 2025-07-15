package divideAndConquer;

import static divideAndConquer.MergeSortCC.printArr;

public class QuickSortCC {
    public static void quickSort(int[] arr, int si, int ei) {
        if (si >= ei) return;

        int pivotIndex = partition(arr, si, ei);
        quickSort(arr, si, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, ei);
    }

    public static int partition (int[] arr, int si, int ei) {
        int pivot = arr[ei];

        int i = si - 1;

        for (int j = si; j < ei; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;

        return i;
    }

    public static void main(String[] args) {
        int[] arr = {6,3,9,8,2,5};
        qs(arr, 0 , arr.length - 1);
        printArr(arr);
    }

    public static void qs(int[] arr, int si, int ei) {
        if (si >= ei) return;

        int privotIdx = getPivot(arr, si, ei);
        qs(arr, si, privotIdx - 1);
        qs(arr, privotIdx + 1, ei);
    }

    public static int getPivot(int[] arr, int si, int ei) {
        int pivot = arr[ei];
        int i = si - 1;
        for (int j = si; j < ei; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        i++;
        arr[ei] = arr[i];
        arr[i] = pivot;

        return i;
    }
}
