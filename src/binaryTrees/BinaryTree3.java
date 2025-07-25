package binaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree3 {
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

    public static void kLevel(Node root, int level, int k) {
        if (root == null) return;

        if (level == k) {
            System.out.print(root.data + " ");
            return;
        }

        kLevel(root.left, level + 1, k);
        kLevel(root.right, level + 1, k);
    }

    public static Node LCA(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        // LCA
        int i = 0;
        for (; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) break;
        }

        // Last Equal Node
        Node lca = path1.get(i - 1);
        return lca;
    }

    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        if (root == null) return false;

        path.add(root);

        if (root.data == n) {
            return true;
        }

        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if (foundRight || foundLeft) return true;

        path.remove(path.size() - 1);

        return false;
    }

    public static Node lca2(Node root, int n1, int n2) {
        if (root == null || root.data == n1 || root.data == n2) return root;

        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);

        // Case: leftLca : Valid value and rightLca == null
        if (rightLca == null) {
            return leftLca;
        } if  (leftLca == null) {
            return rightLca;
        }

        return root;
    }

    public static int lcaDist(Node root, int n) {
        if (root == null) return -1;

        if (root.data == n) return 0;

        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);

        if (leftDist == -1 && rightDist == -1) return -1;
        else if (leftDist > -1) return leftDist + 1;
        else return rightDist + 1;
    }

    public static int minDist(Node root, int n1, int n2) {
        Node lca = lca2(root, n1, n2);
        int dist1 = lcaDist(lca, n1);
        int dist2 = lcaDist(lca, n2);

        return dist1 + dist2;
    }

    public static int kAncestor(Node root, int n, int k) {
        if (root == null) return -1;

        if (root.data == n) return 0;

        int leftDist = kAncestor(root.left, n, k);
        int rightDist = kAncestor(root.right, n, k);

        if (leftDist == -1 && rightDist == -1) return -1;

        int max = Math.max(leftDist, rightDist);
        if (max + 1 == k) {
            System.out.println(root.data);
        }

        return max + 1;
    }

    public static int sumTree(Node root) {
        if (root == null) return 0;

        int sum = sumTree(root.left) + sumTree(root.right);
        int rootData = root.data;
        root.data = sum;
        return sum + rootData;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node (3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);
        BinaryTree.levelOrder(node);
        sumTree(node);
        BinaryTree.levelOrder(node);
    }
}
