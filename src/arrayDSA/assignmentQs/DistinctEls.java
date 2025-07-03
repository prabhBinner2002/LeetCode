package arrayDSA.assignmentQs;

public class DistinctEls {
    public static boolean hasDuplicates(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(hasDuplicates(nums));
    }
}

/*
import java.util.*;

public class MyClass {
    public static void printSubArrays(int[] arr) { // O(n^3)
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int start = i;
            for (int j = i; j < arr.length; j++) {
                int end = j;
                sum = 0;
                for (int k = start; k <= end; k++) {
                    System.out.printf("%d ", arr[k]);
                    sum += arr[k];
                }
                System.out.printf("| Sum : %d", sum);
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void prefixSumArray(int[] arr) {
        int start, end, largest = Integer.MIN_VALUE, sum;
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            start = i;
            for (int j = start; j < arr.length; j++) {
                end = j;
                sum = start == 0 ? prefix[end] : prefix[end] - prefix[start - 1];
                largest = Math.max(largest, sum);
            }
        }

        System.out.println("Largest Sum: " + largest);
    }

    public static void kadane(int[] arr) {
        int sum = 0, largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum < 0) {
                sum = 0;
            }
            largest = Math.max(largest, sum);
        }
        System.out.println("Largest: " + largest);
    }

    public static void rainWater(int[] arr) {
        int[] leftMax = new int[arr.length];
        int n = arr.length;
        leftMax[0] = arr[0];
        for(int i = 1; i < arr.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }

        int[] rightMax = new int[arr.length];
        rightMax[n - 1] = arr[n -1];
        for(int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
        }

        int trappedWater = 0;
        for (int i = 0; i < n; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            trappedWater += (waterLevel - arr[i]);
        }

        System.out.println(trappedWater);
    }

    public static void maxProfit(int[] arr) {
        int profit = 0, buy = arr[0], maxProfit = 0;
        for(int i = 1; i < arr.length; i++) {
            if(buy < arr[i]) {
                profit = arr[i] - buy;
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buy = arr[i];
            }
        }
        System.out.println("Max  Profit: " + maxProfit);
    }

    public static boolean hasDuplicate(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            if (map.get(arr[i]) > 1) {
                return true;
            }
        }
        return false;
    }

    public static void maxProduct(int[] arr) {
        int max = arr[0], min = arr[0], ans = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < 1) {
                int temp = min;
                min = max;
                max = temp;
            }
            max = Math.max(max * arr[i], arr[i]);
            min = Math.min(min * arr[i], arr[i]);
            ans = Math.max(ans,max);
        }

        System.out.println(ans);
    }

    public static void main(String args[]) {
        int[] arr = {4,2,10,6,3,5};
        System.out.println(hasDuplicate(arr));
    }
}
 */