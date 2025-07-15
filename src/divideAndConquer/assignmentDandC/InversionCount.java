package divideAndConquer.assignmentDandC;

public class InversionCount {
    public static int getInversionSort(int[] arr) {
        int n = arr.length - 1;
        return mergeSort(arr, 0 , n);
    }

    public static int mergeSort(int[] arr, int si, int ei) {
        // If the arr is of invalid size, we return 0;
        int invCount = 0;

        if (ei > si) {
            int mid = si + (ei - si) / 2;
            int leftInvCount = mergeSort(arr, si, mid);
            int rightInvCount = mergeSort(arr, mid + 1, ei);
            int invCountMerge = merge(arr, si, mid, ei);
            return leftInvCount + rightInvCount + invCountMerge;
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
        int[] arr = {1,3,5,10,2,6,8,9};
        System.out.println(mergePractice(arr, 0, arr.length - 1));
    }

    public static int mergePractice(int[] arr, int si, int ei) {
       if (si < ei) {
           int mid = si + (ei - si) / 2;
           int left = mergePractice(arr, si, mid);
           int right = mergePractice(arr, mid+1, ei);
           int invCount = mergeFunc(arr, si, mid, ei);
           return left + right + invCount;
       }
       return 0;
    }

    public static int mergeFunc(int[] arr, int si, int mid, int ei) {
        int[] temp = new int[ei - si + 1];
        int i = si;
        int j = mid + 1;
        int k = 0;
        int invCount = 0;
        while (i <= mid && j <= ei) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                invCount += (mid - i + 1);
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        for (i = si, k = 0; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }

        return invCount;
    }
}
