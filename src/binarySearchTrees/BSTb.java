package binarySearchTrees;

import binaryTrees.BinaryTree3;
import binaryTrees.BinaryTreeEastLC;
import binaryTrees.practice;

import java.util.ArrayList;

public class BSTb {
    static class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
        }
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.data > val) {
            // left Subtree
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static boolean search(Node root, int key) { //O(H)
        if (root == null) return false;

        if (root.data == key) return true;
        if (root.data < key) return search(root.right, key);
        else return search(root.left, key);
    }

    public static Node delete(Node root, int val) {
        if(root.data < val) root.right = delete(root.right, val);
        else if(root.data > val) root.left = delete(root.left, val);
        else { // Voila
            // Case 1 : Leaf Node
            if (root.left == null && root.right == null) return null;

            // Case 2 : One Child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // Case 3 : Two Children
            Node IS = findInOrderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }

        return root;
    }

    public static Node findInOrderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    public static void printInRange(Node root, int k1, int k2) {
        if (root == null) return;

        if (k1 <= root.data && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        } else if (root.data < k1) {
            printInRange(root.left, k1, k2);
        } else {
            printInRange(root.right, k1, k2);
        }
    }

    public static void printRootToLeaf(Node root, ArrayList<Integer> path) {
        if (root == null) return; // Base Case

        path.add(root.data);

        if (root.left == null && root.right == null) {
            printPath(path);
        };

        printRootToLeaf(root.left, path);
        printRootToLeaf(root.right, path);
        path.remove(path.size() - 1);
    }

    public static void printPath(ArrayList<Integer> path) {
        for (int i : path) {
            System.out.print(i + " -> ");
        }
        System.out.println("null");
    }

    public static boolean isValidBST(Node root, Node min, Node max) {
        if (root == null) return true;

        if (min != null && root.data <= min.data) return false;
        else if (max != null && root.data >= max.data) return false;

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    public static void mirror1(Node root) {
        if (root == null) return;

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        mirror1(root.left);
        mirror1(root.right);
    }

    public static Node mirror2(Node root) {
        if (root == null) return null;

        Node leftS = mirror2(root.left);
        Node rightS = mirror2(root.right);

        root.left = rightS;
        root.right = leftS;

        return root;
    }

    public static void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        int[] values1 = {8,5,3,1,4,6,10,11,14}; // Valid BST : true
        int[] values2 = {1,1,1}; // Valid BST : false
        Node root = null;
        for (int val : values1) {
            root = insert(root, val);
        }

        preOrder(root);
        root = mirror2(root);
        System.out.println();
        preOrder(root);
    }
}
