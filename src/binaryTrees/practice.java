package binaryTrees;

import java.lang.reflect.Array;
import java.util.*;

public class practice {
    static class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
        }
    }

    class BinaryTree {
        static int idx = -1;
        public static Node buildTree(int[] arr) {
            idx++;

            if (arr[idx] == -1) return null;
            Node root = new Node(arr[idx]);
            root.left = buildTree(arr);
            root.right = buildTree(arr);
            return root;
        }
    }

    public static void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root) {
        if (root == null) return;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void postOrder(Node root) {
        if (root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static int height(Node root) {
        if (root == null) return 0;

        int leftH = height(root.left);
        int rightH = height(root.right);

        return Math.max(leftH, rightH) + 1;
    }

    public static void levelOrder(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if (currNode == null) {
                System.out.println();
                if (q.isEmpty()) break;
                else q.add(null);
            } else {
                System.out.print(currNode.data);
                if (currNode.left != null) q.add(currNode.left);
                if (currNode.right != null) q.add(currNode.right);
            }
        }
    }

    public static int kthAncestor(Node root, int n, int k) {
        if (root == null) return -1;

        if (root.data == n) return 0;

        int left = kthAncestor(root.left, n, k);
        int right = kthAncestor(root.right, n, k);

        if (left == -1 && right == -1) return -1;

        int max = Math.max(left, right);
        if (max + 1 == k) {
            return root.data;
        }

        return max + 1;
    }

    public static void main(String[] args) {
//        Node root = new Node(1);
//        root.left = new Node(2);
//        root.right = new Node(3);
//        root.left.left = new Node(4);
//        root.left.right = new Node(5);
//        root.right.right = new Node(6);
//        Node subRoot = new Node(1);
//        subRoot.left = new Node(1);
//        subRoot.right = new Node(5);
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.right = new Node(3);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(5);
        root.left.right.right.right = new Node(5);
        System.out.println(kthAncestor(root, 3, 1));

//        System.out.println(minDist(root, 4, 6)); // Number of Edges
//        System.out.println(hasSubTree(root, subRoot));
//        System.out.println(getLca(root, 2, 5).data);
//        System.out.println(kthLevel(root, 3));
//        ArrayList<Integer> ans = topView(root);
//        System.out.println(ans);
//        System.out.println(diam(root).diam); // Info stores height as well.
//        System.out.println(count(root));
//        System.out.println(height(root));
//        preOrder(root);
//        System.out.println();
//        inOrder(root);
//        System.out.println();
//        postOrder(root);
//        System.out.println();
//        levelOrder(root);
    }
}
