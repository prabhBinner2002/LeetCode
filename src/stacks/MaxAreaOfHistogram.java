package stacks;

import java.util.Stack;

public class MaxAreaOfHistogram {
    public static int getMaxArea(int[] heights) {
        int maxArea = 0;
        int[] nextSmallerLeft = getNSL(heights);
        int[] nextSmallerRight = getNSR(heights);

        for (int k = 0; k < heights.length; k++) {
            int height = heights[k];
            int width = nextSmallerRight[k] - nextSmallerLeft[k] - 1;
            int area = height * width;
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }

    public static int[] getNSL(int[] heights) {
        Stack<Integer> s = new Stack<>();
        int[] nsl = new int[heights.length];

        for (int i = 0 ; i < heights.length; i++) {
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = s.peek();
            }

            s.push(i);
        }

        return nsl;
    }

    public static int[] getNSR(int[] heights) {
        Stack<Integer> s = new Stack<>();
        int[] nsr = new int[heights.length];

        for (int i = heights.length - 1 ; i >= 0 ; i--) {
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nsr[i] = heights.length;
            } else {
                nsr[i] = s.peek();
            }

            s.push(i);
        }

        return nsr;
    }

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(getMaxArea(heights));
    }
}
