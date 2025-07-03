package arrayDSA;

public class reverseArrayCC {
    public static void reverseArray(int[] arr) {
        int first = 0, last = arr.length - 1;
        while (first < last) {
            int temp = arr[first];
            arr[first] = arr[last];
            arr[last] = temp;

            first++;
            last--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,4,6,8,10,12};
        reverseArray(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
