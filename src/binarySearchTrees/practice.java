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

    public static Node insert(Node root, int n) {
        if (root == null) {
            root = new Node(n);
            return root;
        }

        if (root.data > n) {
            root.left = insert(root.left, n);
        } else {
            root.right = insert(root.right, n);
        }

        return root;
    }

    public static Node buildTree(int[] arr) {
        Node root = null;
        for (int i : arr) {
            root = insert(root, i);
        }

        return root;
    }

    public static void inOrder(Node root) {
        if (root == null) return;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static boolean search(Node root, int key) {
        if (root == null) return false;
        if (root.data == key) return true;
        if (key < root.data) return search(root.left, key);
        else return search(root.right, key);
    }

    public static Node getIS(Node root) {
        while (root.left != null) root = root.left;
        return root;
    }

    public static Node delete(Node root, int val) {
        if (root.data > val) root.left = delete(root.left, val);
        else if (root.data < val) root.right = delete(root.right, val);
        else {
            if (root.left == null && root.right == null) return null;
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            Node is = getIS(root.right);
            root.data = is.data;
            root.right = delete(root.right, is.data);
        }

        return root;
    }

    public static boolean isValidBST(Node root, Node min, Node max) {
        if (root == null) return true;

        if (min != null && root.data <= min.data) return false;
        if (max != null && root.data >= max.data) return false;

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    public static Node mirror(Node root) {
        if (root == null) return null;

        Node left = mirror(root.left);
        Node right = mirror(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    static class Info {
        boolean isBst;
        int size;
        int min;
        int max;
        public Info(boolean isBst, int size, int min, int max) {
            this.isBst = isBst;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static int maxBstSize = 0;

    public static Info largestBST(Node root) {
        if (root == null)
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);


        Info left = largestBST(root.left);
        Info right = largestBST(root.right);

        int size = left.size + right.size + 1;
        int min = Math.min(root.data, Math.min(left.min, right.min));
        int max = Math.max(root.data, Math.max(left.max, right.max));

        if (root.data <= left.max || root.data >= right.min)
            return new Info(false, size, max, min);
        if (left.isBst && right.isBst) {
            maxBstSize = Math.max(size, maxBstSize);
            return new Info(true, size, max, min);
        }

        return new Info(false, size, min, max);
    }

    public static Node createBST(int[] arr,int si,int ei) {
        if (si > ei) return null;

        int mid = si + (ei - si)/2;
        Node root = new Node(arr[mid]);
        root.left = createBST(arr, si, mid - 1);
        root.right = createBST(arr, mid + 1, ei);
        return root;
    }

    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4};
        Node root1 = createBST(values, 0, values.length - 1);
        int[] v = {6, 7, 8, 9, 10};
        Node root2 = createBST(v, 0, v.length - 1);
        Node root = new Node(2);
        root.left = new Node(0);
        root.right = new Node(1);
        root.left.left = root1;
        root.right.left = root2;

        largestBST(root);
        System.out.println(maxBstSize);
    }
}
