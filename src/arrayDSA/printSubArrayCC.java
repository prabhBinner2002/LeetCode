package arrayDSA;

import java.util.Arrays;

public class printSubArrayCC {
    public static void printSubArray(int[] nums) {
        int ts = 0, largest = Integer.MIN_VALUE, smallest = Integer.MAX_VALUE, sum;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                sum = 0;
                for(int k = i; k <= j; k++) {
//                    System.out.print(nums[k] + " ");
                    sum += nums[k];
                }
                if (sum > largest) {
                    largest = sum;
                }
                if (sum < smallest) {
                    smallest = sum;
                }
                ts++;
//                System.out.print("| Sum : " + sum);
//                System.out.println();
            }
//            System.out.println();
        }
        System.out.println("Total number of pairs: " + ts);
        System.out.println("Smallest Sum: " + smallest);
        System.out.println("Largest Sum: " + largest);
    }

    public static void printSubArrayPreFix(int[] nums) {
        int ts = 0, largest = Integer.MIN_VALUE, smallest = Integer.MAX_VALUE, sum;
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                sum =  i == 0 ? prefix[j] : prefix[j] - prefix[i - 1];
                if (sum > largest) {
                    largest = sum;
                }
                if (sum < smallest) {
                    smallest = sum;
                }
            }
        }
        System.out.println("Smallest Sum: " + smallest);
        System.out.println("Largest Sum: " + largest);
    }

    public static void kadane(int[] arr) {
        int maxSum = Integer.MIN_VALUE, ts = 0, currentSum = 0;
        boolean allNegative = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                allNegative = false;
            }
        }
        if (allNegative) {
            try {
                System.out.println("Max Sum: " + Arrays.stream(arr).max().getAsInt());
                return;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        for(int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            if (currentSum < 0) {
                currentSum = 0;
            }
            maxSum = Math.max(maxSum, currentSum);
        }
        System.out.println("our Max Sum: " + maxSum);
    }

    public static void main(String[] args) {
        int[] arr = {1,-1, 5, 6, 2,3,4,5};
        int[] prefixArray = {2, 4, 6, 8, 10};
        int[] kadane = {1, 1, 3, -1, -10};
        kadane(kadane);
    }
}
