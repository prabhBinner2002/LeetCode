package divideAndConquer.assignmentDandC;

public class SortString {
    public static void sortString(String[] arr, int si, int ei) {
        if (si >= ei) return;

        int mid = si + (ei - si) / 2;
        sortString(arr, si, mid);
        sortString(arr, mid + 1, ei);
        merge(arr, si, mid, ei);
    }

    public static void merge(String[] arr, int si, int mid, int ei) {
        String[] temp = new String[ei - si + 1];

        int i = si;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= ei) {
            if (arr[i].compareTo(arr[j]) < 0) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        for (i = si; i < temp.length; i++) {
            arr[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        String[] arr = {"sun", "earth", "mars", "mercury", "pp", "ppp"};
        sortString(arr, 0, arr.length - 1);
        for (String i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
