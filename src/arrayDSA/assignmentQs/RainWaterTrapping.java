package arrayDSA.assignmentQs;

public class RainWaterTrapping {
    public static int getRainWaterTrappedVolume(int[] arr) {
        int trappedWater = 0, n = arr.length;
        int[] leftMax = new int[n];
        leftMax[0] = arr[0];
        for(int i = 1; i < n; i++) {
            leftMax[i] = Math.max(arr[i], leftMax[i - 1]);
        }

        int[] rightMax = new int[n];
        rightMax[n-1] = arr[n-1];
        for (int i = n - 2; i >= 0; i-- ) {
            rightMax[i] = Math.max(arr[i], rightMax[i + 1]);
        }

        for(int i = 0; i < n; i++) {
            int waterLvl = Math.min(leftMax[i], rightMax[i]);
            trappedWater += waterLvl - arr[i];
        }

        return trappedWater;
    }

    public static void main(String[] args) {
        int[] height = {4, 2, 0, 3, 2, 5};
        System.out.println(getRainWaterTrappedVolume(height));
    }
}
