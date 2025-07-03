package arrayDSA;

public class LinearSearchCC {
    public static int linearSearch(int[] nums, int key) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static int findLargest(int[] nums) {
        int largest = Integer.MIN_VALUE; // -Infinity
        int smallest = Integer.MAX_VALUE; // +Infinity
        for (int num : nums) {
            if (num > largest) {
                largest = num;
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4,5,6,7,8,9};
        System.out.println("Largest value: " + findLargest(nums));
    }
}
