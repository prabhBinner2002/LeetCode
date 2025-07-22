package binaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class DeleteNode {
    static class Node {
        int data;
        Node right;
        Node left;
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        public static void preOrder(Node root) {
            if (root == null) return;

            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public static void levelOrder(Node root) {
            if (root == null) return;

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()) {
                Node curr = q.remove();
                if (curr == null) {
                    System.out.println();
                    if (q.isEmpty()) break;
                    else q.add(null);
                } else {
                    System.out.print(curr.data + " ");
                    if (curr.left != null) q.add(curr.left);
                    if (curr.right != null) q.add(curr.right);
                }
            }
            System.out.println(".".repeat(20));
        }
    }

    public static Node deleteNode(Node root, int target) {
        if (root == null) return null;

        root.left = deleteNode(root.left, target);
        root.right = deleteNode(root.right, target);

        if (root.left == null && root.right == null && root.data == target) {
            return null;
        }
        return root;
    }

    public static int maxPariSumPath(Node root) {
        return helper(root, Integer.MIN_VALUE);
    }

    private static int helper(Node root, int res) {
        if (root == null) return 0;

        int left = helper(root.left, res);
        int right = helper(root.right, res);

        res = Math.max(res,
                Math.max(root.data,
                        Math.max(root.data + left,
                                Math.max(root.data + right, root.data + left + right)
                        )
                )
        );

        return Math.max(root.data, Math.max(root.data + left, root.data + right));
    }

    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(-10);
        node.right = new Node(20);
        BinaryTree.levelOrder(node);
        System.out.println(maxPariSumPath(node));
    }
}
