package binarySearchTrees;

public class practice {
    static class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
        }
    }

    public static void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (val < root.data) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static boolean search(Node root,  int key) {
        if (root == null) return false;
        if (root.data == key) return true;
        else if (root.data > key) return search(root.left, key);
        else return search(root.right, key);
    }

    public static Node delete(Node root, int val) {
        if (root.data > val) delete(root.left, val);
        if (root.data < val) delete(root.right, val);
        else {
            if (root.left == null && root.right == null) return null;
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            Node IS = findIS(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
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

    public static boolean isValidBST(Node root, Node min, Node max) {
        if (root == null) return true;

        if (min != null && root.data <= min.data) return false;
        else if (max != null && root.data >= max.data) return false;

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    public static Node findIS(Node root) {
        while (root.left != null) root = root.left;
        return root;
    }

    public static void main(String[] args) {
        int[] values = {5,1,3,4,2,7};
        Node root = null;
        for (int i : values) {
            root = insert(root, i);
        }
    }
}
