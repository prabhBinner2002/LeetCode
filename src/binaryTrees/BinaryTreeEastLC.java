package binaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeEastLC {
     public static class TreeNode {
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

     public static class BinaryTree {
         public static int idx = -1;
         public TreeNode buildTree(int[] nodes) {
             idx++;

             if (nodes[idx] == -1) return null;

             TreeNode node = new TreeNode(nodes[idx]);
             node.left = buildTree(nodes);
             node.right = buildTree(nodes);
             return node;
         }

         public void levelOrder(TreeNode root) {
             if (root == null) return;

             Queue<TreeNode> q = new LinkedList<>();
             q.add(root);
             q.add(null);

             while (!q.isEmpty()) {
                 TreeNode curr = q.remove();
                 if (curr == null) {
                     System.out.println();
                     if (q.isEmpty()) {
                         break;
                     } else {
                         q.add(null);
                     }
                 } else {
                     System.out.print(curr.val + " ");
                     if (curr.left != null) {
                         q.add(curr.left);
                     } if (curr.right != null) {
                         q.add(curr.right);
                     }
                 }
             }
         }

         public List<String> binaryTreePaths(TreeNode root) {
            List<String> res = new ArrayList<>();
            if (root != null) binaryTreePathsUtil(root, res, "");
            return res;
         }

         private void binaryTreePathsUtil(TreeNode root, List<String> res, String path) {
             if (root.left == null && root.right == null) res.add(path + root.val);
             if (root.left != null) binaryTreePathsUtil(root.left, res, path + root.val + "->");
             if (root.right != null) binaryTreePathsUtil(root.right, res, path + root.val + "->");
         }

         private boolean isLeft(TreeNode node) {
             return node.left.left == null && node.left.right == null;
         }
     }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int[] nodes = {1,2,5, -1, -1, -1, 3, -1, -1};
        TreeNode root = tree.buildTree(nodes);
        tree.levelOrder(root);
        List<String> s = tree.binaryTreePaths(root);
        System.out.println(s);
    }
}
