package sortingAlgosCC;

import java.util.Arrays;

public class BasicSortingAlogsCC {
    public static void bubbleSort(int[] arr) {
        int swap;
        for (int turn = 0; turn < arr.length; turn++) {
            swap = 0;
            for (int i = 0; i < arr.length - 1 - turn; i++) {
                if(arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swap++;
                }
            }
            if (swap == 0) {
                break;
            }
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[minPos] > arr[j]) {
                    minPos = j;
                }
            }

            // Swap
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int prev = i - 1;

            // finding out the correct position to insert
            while (prev >= 0 && arr[prev] > curr) {
                arr[prev + 1] = arr[prev];
                prev--;
            }

            // insertion
            arr[prev + 1] = curr;
        }
    }

    public static void countingSort(int[] arr) {
        int[] count;
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            largest = Math.max(largest, arr[i]);
        }

        count = new int[largest + 1];

        // Aux Array of counts
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        // Sorting
        int j = 0;
        for (int i = 0; i < count.length; i++) {
            while(count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }

    public static void printArr(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {5,4,1,3,2,4,5,6,1,4,1,3,2,4,5,6,1,4,1,3,2,4,5,6,1};
        countingSort(arr);
        printArr(arr);
    }
}
