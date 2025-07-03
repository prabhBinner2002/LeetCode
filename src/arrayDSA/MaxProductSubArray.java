package arrayDSA;

public class MaxProductSubArray {
    public static int maxProduct(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        int ans = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }

            max = Math.max(max * arr[i], arr[i]);
            min = Math.min(min * arr[i], arr[i]);

            ans = Math.max(ans, max);
        }

        return ans;
    }
}
