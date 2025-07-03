package arrayDSA.assignmentQs;

public class TrippletWithSum0 {
    public static void getTrippedWithSumZero(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                for (int k = i + 2; k < arr.length; k++) {
                    if ((arr[i] + arr[j] + arr[k]) == 0)
                        System.out.printf("[%d, %d, %d]", arr[i], arr[j], arr[k]);
                }
            }
        }
        //TODO Watch the linked list and HashSet chapters and solve it then.
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0,  1, 2, -1, -4};
        getTrippedWithSumZero(nums);
    }
}
