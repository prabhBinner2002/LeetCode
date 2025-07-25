package stacks;

import java.util.Stack;

public class NextGreater {
    public static int[] nextGreater(int[] arr) {
        Stack<Integer> s = new Stack<>();
        int[] nextGreater = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[i] >= s.peek()) {
                s.pop();
            }
            if (s.isEmpty()) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = s.peek();
            }
            s.push(arr[i]);
        }
        return nextGreater;
    }

    public static void main(String[] args) {
        int[] arr = {6,6,7,1,8,11};
        int[] res = nextGreater(arr);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
