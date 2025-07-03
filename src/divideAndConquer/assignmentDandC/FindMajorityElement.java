package divideAndConquer.assignmentDandC;

public class FindMajorityElement {
    public static int findMajorityElem(int[] arr, int si, int ei) {
        if (si >= ei) return -1;

        int mid = si  + (ei - si) / 2;
        findMajorityElem(arr, si, mid);
        findMajorityElem(arr, mid + 1, ei);
        return count(arr, si, mid, ei);
    }

    public static int count(int[] arr, int si, int mid, int ei) {
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3};
        int num = findMajorityElem(nums, 0 , nums.length - 1);
        System.out.println(num);
    }
}
