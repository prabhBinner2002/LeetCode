package arrayDSA;

public class OptimizedRainWater {
    public static int trap(int[] height) {
        int n = height.length;
        int ans = 0, l = 0, r = n - 1;
        int leftMax = 0, rightMax = 0;
        while (l < r) {
            leftMax = Math.max(leftMax, height[l]);
            rightMax = Math.max(rightMax, height[r]);
            if (leftMax < rightMax) {
                ans += leftMax - height[l];
                l++;
            } else {
                ans += rightMax - height[r];
                r--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};
        System.out.println(trap(height));
    }
}
