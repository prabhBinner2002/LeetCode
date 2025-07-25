package binarySearchTrees;

import java.util.ArrayList;

public class BST {
    static class Node {
        int data;
        Node left;
        Node right;
        public Node (int data) {
            this.data = data;
        }
    }

    public static void preOrder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static Node createBST(int[] arr, int si, int ei) {
        if (si > ei) return null;

        int mid = (si + ei) / 2;
        Node root = new Node(arr[mid]);
        root.left = createBST(arr, si, mid - 1);
        root.right= createBST(arr, mid + 1, ei);
        return root;
    }

    public static Node createBST(ArrayList<Integer> arr, int si, int ei) {
        if (si > ei) return null;
        int mid = (si + ei)/2;
        Node root = new Node(arr.get(mid));
        root.left = createBST(arr, si, mid - 1);
        root.right = createBST(arr, mid + 1, ei);
        return root;
    }

    public static void getInOrder(Node root, ArrayList<Integer> seq) {
        if (root == null) return;
        getInOrder(root.left, seq);
        seq.add(root.data);
        getInOrder(root.right, seq);
    }

    public static Node balanceBST(Node root) {
        ArrayList<Integer> inOrder = new ArrayList<>();
        getInOrder(root, inOrder);
        return createBST(inOrder, 0, inOrder.size() - 1);
    }

    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;
        public Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.max = max;
            this.min = min;
        }
    }

    public static int maxBST = 0;

    public static Info largestBST(Node root){
        if (root == null)
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);

        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);

        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        if (root.data <= leftInfo.max || root.data >= rightInfo.min)
            return new Info(false, size, min, max);

        if (leftInfo.isBST && rightInfo.isBST) {
            maxBST = Math.max(maxBST, size);
            return new Info(true, size, min, max);
        }

        return new Info(false, size, min, max);
    }

    public static void main(String[] args) {
//        int[] arr = {3,5,6,8,10,11,12};
//        Node root = createBST(arr, 0, arr.length - 1);
//        preOrder(root);

//        ----------------------

//        Node root = new Node(8);
//        root.left = new Node(6);
//        root.right = new Node(10);
//        root.left.left = new Node(5);
//        root.left.left.left = new Node(3);
//        root.right.right = new Node(11);
//        root.right.right.right = new Node(12);
//
//        root = balanceBST(root);
//        preOrder(root);

//        -----------------------

        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);
        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);

        Info info = largestBST(root);
        System.out.println("Largest BST Size: " + maxBST);
    }
}
