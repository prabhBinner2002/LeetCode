package sortingAlgosCC;

public class assignmentSort {
    public static void bubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void selection(int[] arr) {
        int pos;
        for (int i = 0; i < arr.length - 1; i++) {
            pos = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[pos]) {
                    pos = j;
                }
            }
            int temp = arr[pos];
            arr[pos] = arr[i];
            arr[i] = temp;
        }
    }

    public static void insertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int prev = i - 1;
            while(prev >= 0 && arr[prev] < current) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            arr[prev + 1] = current;
        }
    }

    public static void countSort(int[] arr) {
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            largest = Math.max(largest, arr[i]);
        }

        int[] count = new int[largest + 1];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        int j = 0;
        for (int i = count.length - 1; i >= 0; i--) {
            while(count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }

    public static void printArr(String method,int[] arr) {
        System.out.println(method);
        for(int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {3,6,2,1,8,7,4,5,3,1};
//        bubble(arr);
//        printArr("Bubble", arr);
//        selection(arr);
//        printArr("Selection", arr);
//        insertion(arr);
//        printArr("Insertion", arr);
        countSort(arr);
        printArr("Counting", arr);
    }
}
