public class DutchFlagQuickSort {

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void printarr(int[] a) {
        for (int value : a)
            System.out.print(value + " ");
        System.out.println();
    }

    static int[] partition(int[] a, int si, int ei) {
        if (ei - si <= 1) {
            if (a[ei] < a[si]) {
                swap(a, ei, si);
            }
            return new int[]{si, ei};
        }

        int mid = si;
        int pivot = a[ei];

        while (mid <= ei) {
            if (a[mid] < pivot) {
                swap(a, si++, mid++);
            } else if (a[mid] == pivot) {
                mid++;
            } else {
                swap(a, mid, ei--);
            }
        }

        return new int[]{si - 1, mid}; // Return boundaries for recursion
    }

    static void quicksort(int[] a, int si, int ei) {
        if (si >= ei)
            return;

        int[] boundaries = partition(a, si, ei);
        int i = boundaries[0];
        int j = boundaries[1];

        quicksort(a, si, i);
        quicksort(a, j, ei);
    }

    public static void main(String[] args) {
        int[] a = {4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4};

        System.out.print("Before: ");
        printarr(a);
        quicksort(a, 0, a.length - 1);
        System.out.print("After:  ");
        printarr(a);
    }
}
