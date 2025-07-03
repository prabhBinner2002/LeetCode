package recursionCC.assignmentQsCC;

public class AllOccurence {
    public static void printAllOccurences(int[] arr, int key, int idx) {
        if (idx == arr.length) return;
        if (arr[idx] == key) System.out.print(idx + " ");
        printAllOccurences(arr, key, idx + 1);
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 5, 6, 2, 7, 2, 2};
        int key = 2;
        printAllOccurences(arr, key, 0);
    }
}
