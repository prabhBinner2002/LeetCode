package arrayListsCC.assign;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MostFrequent {
    public static void getMostFreqent(ArrayList<Integer> nums, int key) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int ans = 0, maxFrequency = 0;
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) == key) {
                int target = nums.get(i + 1);
                map.put(target, map.getOrDefault(target, 0) + 1);
                if (map.get(target) > maxFrequency) {
                    ans = target;
                    maxFrequency = map.get(target);
                }
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(100);
        nums.add(200);
        nums.add(1);
        nums.add(100);
        getMostFreqent(nums, 1);
    }
}
