package arrayListsCC.assign;

import java.util.*;

public class LonleyNum {
    public static ArrayList<Integer> getLonies(ArrayList<Integer> nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        Collections.sort(nums);
        for (int i = 0; i < nums.size(); i++) {
            if ((i == 0 || nums.get(i) - nums.get(i - 1) > 1) && (i == nums.size() - 1 || nums.get(i + 1) - nums.get(i) > 1)) {
                ans.add(nums.get(i));
            }
        }
        return ans;
    }

    public static List<Integer> getLoniesOptimized(ArrayList<Integer> nums) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int val = entry.getKey();
            if (entry.getValue() == 1 && !map.containsKey(val + 1) && !map.containsKey(val - 1)) {
                ans.add(val);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums= new ArrayList<>();
        nums.add(1);
        nums.add(3);
        nums.add(5);
        nums.add(3);

        List<Integer> lonies = getLoniesOptimized(nums);
        System.out.println(lonies);
    }
}
