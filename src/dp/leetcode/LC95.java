package dp.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC95 {
     static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
        }
    }

    private static List<TreeNode> build(int si, int ei) {
        List<TreeNode> res = new ArrayList<>();

        if (si > ei) {
            res.add(null);
            return res;
        }

        for (int i = si; i <= ei; i++) {
            List<TreeNode> leftSubTrees = build(si, i - 1);
            List<TreeNode> rightSubTrees = build(i + 1, ei);

            for (TreeNode l : leftSubTrees) {
                for (TreeNode r : rightSubTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }

        return res;
    }

    public static List<TreeNode> generateTrees(int n) {
        return build(1, n);
    }

    public static void inOrder(TreeNode root) {
         if (root == null) {
             System.out.print("Null");
             return;
         }

         inOrder(root.left);
         System.out.print(root.val + " ");
         inOrder(root.right);
    }

    public static void main(String[] args) {
        List<TreeNode> list = generateTrees(3);
    }
}
