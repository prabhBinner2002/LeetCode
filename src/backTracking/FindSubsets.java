package backTracking;

import java.util.ArrayList;
import java.util.List;

public class FindSubsets {
    public static void findSubsets(String str, String ans, int i) {
        // Base Case
        if (i == str.length()) {
            if (ans.length() == 0) {
                System.out.println("null");
            } else
                System.out.println(ans);
            return;
        }

        // Recursion
        // Yes Choice
        findSubsets(str, ans + str.charAt(i), i + 1);
        // No Choice
        findSubsets(str, ans, i + 1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        rec(nums, output, 0, subsets);
        return subsets;
    }

    public void rec(int[] nums, List<Integer> out, int idx, List<List<Integer>> subsets) {
        if (idx == nums.length) {
            subsets.add(new ArrayList<>(out));
            return;
        }

        out.add(nums[idx]);
        rec(nums, out, idx + 1, subsets);

        out.remove(out.size() - 1);
        rec(nums, out, idx + 1, subsets);
    }

    public static void main(String[] args) {
        String str = "abc";
        findSubsets(str, "", 0);
    }
}
