package dp;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        int n = numRows;
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.get(0).add(1);
        if (n == 1) return ans;

        ans.add(new ArrayList<>());
        ans.get(1).add(1);
        ans.get(1).add(1);

        for (int i = 2; i <= n; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
            }
            row.add(1);
            ans.add(row);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
