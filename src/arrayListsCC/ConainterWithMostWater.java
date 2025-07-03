package arrayListsCC;

import java.util.ArrayList;

public class ConainterWithMostWater {
    public static int getMaxWater_BruteForce(ArrayList<Integer> hts) {
        int maxWater = 0, height, width, water;
        for (int i = 0; i < hts.size(); i++) {
            for (int j = i + 1; j < hts.size(); j++) {
                height = Math.min(hts.get(i), hts.get(j));
                width = j - i;
                water = height  * width;
                maxWater = Math.max(water, maxWater);
            }
        }

        return maxWater;
    }

    public static int getMaxWater_2PointerApproach(ArrayList<Integer> hts) {
        int l = 0, r = hts.size() - 1, water = 0, maxWater = 0;
        int leftMax = 0, rightMax = 0;
        while (l < r) {
            leftMax = Math.max(leftMax, hts.get(l));
            rightMax = Math.max(rightMax, hts.get(r));

            if (leftMax < rightMax) {
                water = leftMax * (r - l);
                l++;
            } else {
                water = rightMax * (r - l);
                r--;
            }
            maxWater = Math.max(water, maxWater);
        }
        return maxWater;
    }

    public static int getMaxWater_2PointerAnotherApproach(ArrayList<Integer> hts) {
        int lp = 0;
        int rp = hts.size() - 1;
        int maxWater = 0;
        while (lp < rp) {
            int height = Math.min(hts.get(lp), hts.get(rp));
            int width = rp - lp;
            int currWater = height * width;
            maxWater = Math.max(maxWater, currWater);

            if (hts.get(lp) < hts.get(rp)) {
                lp++;
            } else {
                rp--;
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        ArrayList<Integer> heights = new ArrayList<>();
        heights.add(1);
        heights.add(8);
        heights.add(6);
        heights.add(2);
        heights.add(5);
        heights.add(4);
        heights.add(8);
        heights.add(3);
        heights.add(7);

        System.out.println(getMaxWater_BruteForce(heights));
        System.out.println(getMaxWater_2PointerApproach(heights));
        System.out.println(getMaxWater_2PointerAnotherApproach(heights));
    }
}