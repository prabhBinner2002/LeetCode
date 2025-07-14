package divideAndConquer.assignmentDandC;

public class InversionCount {
    public static int getInversionSort(int[] arr) {
        int n = arr.length - 1;
        return mergeSort(arr, 0 , n);
    }

    public static int mergeSort(int[] arr, int si, int ei) {
        int invCount = 0;

        if (ei > si) {
            int mid = si + (ei - si) / 2;
            invCount += mergeSort(arr, si, mid);
            invCount += mergeSort(arr, mid + 1, ei);
            invCount += merge(arr, si, mid, ei);
        }

        return invCount;
    }

    public static int merge(int[] arr, int si, int mid, int ei) {
        int[] temp = new int[ei - si + 1];
        int i = si;
        int j = mid;
        int k = 0;
        int invCount = 0;

        while(i < mid && j <= ei) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                invCount += (mid - i);
            }
        }

        while (i < mid) temp[k++] = arr[i++];
        while (j <= ei) temp[k++] = arr[j++];

        for (i = si, k = 0; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }

        return invCount;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};
        System.out.println(getInversionSort(arr));
    }
}
