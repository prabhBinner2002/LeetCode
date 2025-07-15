package divideAndConquer;

import static divideAndConquer.MergeSortCC.printArr;

public class Merge2Sorted {
    public static int[] sort(int[] a1, int[] a2) {
        int temp[] = new int[a1.length + a2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < a1.length && j < a2.length) {
            if (a1[i] < a2[j]) {
                temp[k++] = a1[i++];
            } else {
                temp[k++] = a2[j++];
            }
        }
        while (i < a1.length) temp[k++] = a1[i++];
        while (j < a2.length) temp[k++] = a2[j++];

        return temp;
    }

    public static void main(String[] args) {
        int[] a1 = {1, 1, 2, 3,3,5,7};
        int[] a2 = {2,4,6,8};
        int[] a = merge(a1, a2);
        printArr(a);
    }

    public static int[] merge(int[] a1, int[] a2) {
        int p1 = 0;
        int p2 = 0;
        int[] res = new int[a1.length + a2.length];
        int idx = 0;
        while (p1 < a1.length && p2 < a2.length) {
            int left = a1[p1];
            int right = a2[p2];

            if (left <= right) {
                res[idx++] = a1[p1++];
            } else {
                res[idx++] = a2[p2++];
            }
        }

        while (p1 < a1.length) {
            res[idx++] = a1[p1++];
        }
        while (p2 < a2.length) {
            res[idx++] = a2[p2++];
        }

        return res;
    }
}
