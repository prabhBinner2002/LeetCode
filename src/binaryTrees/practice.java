package binaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class practice {
    public static class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class BinaryTree {
        public static int idx = -1;
        public Node buildTree(int[] nodes) {
            idx++;

            if (nodes[idx] == -1) return null;

            Node node = new Node(nodes[idx]);
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }

        public void preOrder(Node root) {
            if (root == null) return;

            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public void inOrder(Node root) {
            if (root == null) return;

            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

        public void postOrder(Node root) {
            if (root == null) return;

            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }

        public void levelOrder(Node root) {
            if (root == null) return;

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node curr = q.remove();
                if (curr == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(curr.data + " ");
                    if (curr.left != null) {
                        q.add(curr.left);
                    } if (curr.right != null) {
                        q.add(curr.right);
                    }
                }
            }
        }

        public int height(Node root) {
            if (root == null) return 0;

            int lh = height(root.left);
            int rh = height(root.right);
            return Math.max(lh, rh) + 1;
        }

        public int count(Node root) {
            if (root == null) return 0;

            int lc = count(root.left);
            int rc = count(root.right);
            return lc + rc + 1;
        }

        public int sum(Node root) {
            if (root == null) return 0;

            int ls = sum(root.left);
            int rs = sum(root.right);
            return ls + rs + root.data;
        }

        public static boolean isUniversal(Node root) {
            if (root == null) return true;

            int data = root.data;

            return dfs(root, data);
        }

        private static boolean dfs(Node node, int data) {
            if (node == null) return true;

            if (node.data != data) return false;

            return dfs(node.left, data) && dfs(node.right, data);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(1);
        root.right = new Node(1);
        root.left.left = new Node(1);
        root.left.right = new Node(1);
        root.right.left = new Node(1);
        root.right.right = new Node(2);

        System.out.println(BinaryTree.isUniversal(root));
    }
}
