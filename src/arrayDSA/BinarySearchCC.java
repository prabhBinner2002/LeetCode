package arrayDSA;

public class BinarySearchCC {
    public static int binarySearch(int[] nums, int key) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == key) {
                return mid;
            } if (nums[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2,4,6,8,10,12};
        int index = binarySearch(nums, 12);
        if (index == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println(index);
        }
    }
}
