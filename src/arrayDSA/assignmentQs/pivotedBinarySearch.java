package arrayDSA.assignmentQs;

public class pivotedBinarySearch {
    private static int pivotedSearch(int[] nums, int key) {
        int i, j, smallest = Integer.MAX_VALUE;

        for (i = 0; i < nums.length; i++) {
            if (smallest > nums[i]){
                smallest = nums[i];
            }
        }

        for (j = 0; j < nums.length; j++) {
            if(nums[j] == smallest){
                break;
            }
        }

        int start = j;
        int end = j - 1;

        System.out.println("start: " + start + " end: " + end);

        return -1;
    }

    public static void main(String[] args) {
        int[] num = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(pivotedSearch(num, 6));
    }
}
