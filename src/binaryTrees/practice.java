package binaryTrees;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

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

    public static int count(Node root) {
        if (root == null) return 0;

        int leftC = count(root.left);
        int rightC = count(root.right);

        return leftC + rightC + 1;
    }

    public static int sum(Node root) {
        if (root == null) return 0;

        int leftS = sum(root.left);
        int rightS = sum(root.right);

        return leftS + rightS + root.data;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        Node subRoot = root.left;
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

//        System.out.println(minDist(root, 4, 6)); // Number of Edges
//        System.out.println(subTree(root, subRoot));
//        System.out.println(getLCA(root, 4, 5).data);
//        kthLevel(root, 1, 3);
//        topView(root);
//        System.out.println(diam(root).diameter); // Info stores height as well.
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
