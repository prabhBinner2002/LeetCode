package sortingAlgosCC;

public class OptimizedBubbleSort {
    public static void optBubbleSort(int[] arr) {
        outer : for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;
            inner : for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapped = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!swapped) {
                break outer;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        optBubbleSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
