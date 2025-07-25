package arrayDSA;

public class practice {
    public static int trappedRainWater(int[] heights) {
        int[] leftMax = new int[heights.length];
        leftMax[0] = heights[0];
        for (int i = 1; i < heights.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], heights[i]);
        }

        int[] rightMax = new int[heights.length];
        rightMax[rightMax.length - 1] = heights[heights.length - 1];
        for (int i = rightMax.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], heights[i]);
        }

        int trappedWater = 0;
        for (int i = 0; i < heights.length; i++) {
            int waterLvl = Math.min(leftMax[i], rightMax[i]);
            int area = waterLvl - heights[i];
            trappedWater += area;
        }

        return trappedWater;
    }

    public static int twoPointerApproach(int[] heights) {
        int lp = 0; int rp = heights.length - 1;
        int lh = 0, rh = 0;
        int ans = 0;
        while (lp < rp) {
            lh = Math.max(lh, heights[lp]);
            rh = Math.max(rh, heights[rp]);
            if (lh < rh) {
                ans += lh - heights[lp];
                lp++;
            } else {
                ans += rh - heights[rp];
                rp--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] height = {4,2,0,6,3,2,5};
        System.out.println(twoPointerApproach(height));
    }
}
