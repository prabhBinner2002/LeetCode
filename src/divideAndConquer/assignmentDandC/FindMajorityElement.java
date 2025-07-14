package divideAndConquer.assignmentDandC;

public class FindMajorityElement {
    public static int findMajorityElem(int[] arr, int si, int ei) {
        if (si >= ei) return arr[si];

        int mid = si  + (ei - si) / 2;

        int left = findMajorityElem(arr, si, mid);
        int right = findMajorityElem(arr, mid + 1, ei);

        if (left == right) return left;

        int leftCount = count(arr, left, si, ei);
        int rightCount = count(arr, right, si, ei);

        return rightCount > leftCount ? right : left;
    }

    public static int count(int[] arr, int num, int si, int ei) {
        int count  = 0;
        for (int i = si; i <= ei; i++) {
            if (arr[i] == num) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        int num = findMajorityElem(nums, 0 , nums.length - 1);
        System.out.println(num);
    }
}
