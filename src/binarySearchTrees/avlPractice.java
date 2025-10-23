package binarySearchTrees;

public class avlPractice {
    static class Node {
        Node left, right;
        int height;
        int data;
        public Node (int data) {
            this.height = 1;
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node root;

    public static int getHeight(Node root) {
        if (root == null) return 0;

        return root.height;
    }

    public static int getBalance(Node root) {
        if (root == null) return 0;

        return getHeight(root.left) - getHeight(root.right);
    }

    public static Node rotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));
        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));

        return x;
    }

    public static Node rotateLeft(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));
        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));

        return y;
    }

    public static Node insert(Node root, int key) {
        if (root == null)
            return new Node(key);

        if (key < root.data) root.left = insert(root.left, key);
        if (key > root.data) root.right = insert(root.right, key);
        if (key == root.data) return root;

        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        int bf = getBalance(root);

        if (bf > 1 && key < root.left.data)
            return rotateRight(root);
        if (bf > 1 && key > root.left.data) {
            root.left = rotateLeft(root.left);
            return rotateRight(root);
        }

        if (bf < -1 && key > root.right.data)
            return rotateLeft(root);
        if (bf < -1 && key < root.right.data) {
            root.right = rotateRight(root.right);
            return rotateLeft(root);
        }

        return root;
    }

    public static void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static Node getMin(Node root) {
        while (root.left != null) root = root.left;

        return root;
    }

    public static Node deleteNode(Node root, int key) {
        if (root == null) return null;

        Node temp = null;
        if (root.data > key) root.left = deleteNode(root.left, key);
        else if (root.data < key) root.right = deleteNode(root.right, key);
        else {
            if (root.left == null || root.right == null) {
                if (root.left == null) {
                    temp = root.right;
                } else if (root.right == null) {
                    temp = root.left;
                }

                if (temp == null) { // No child Case
                    temp = root;
                    root = null;
                } else { // One child Case
                    root = temp;
                };
            } else { // Two children case
                Node is = getMin(root.right);
                root.data = is.data;
                root.right = deleteNode(root.right, is.data);
            }
        }

        if (root == null) return root;

        root.height = 1 + Math.max(getHeight(root.left), getHeight(root));

        int bf = getBalance(root);

        if (bf > 1 && getBalance(root.left) >= 0) return rotateRight(root); // LL
        if (bf > 1 && getBalance(root.left) < 0) {
            root.left = rotateLeft(root.left);
            return rotateRight(root);
        } // LR

        if (bf < -1 && getBalance(root.right) <= 0) return rotateLeft(root); // RR
        if (bf < -1 && getBalance(root.right) > 0){
            root.right = rotateRight(root.right);
            return rotateLeft(root);
        } // RL

        return root;
    }

    public static void main(String[] args) {
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        /*               AVL Tree :
                            30
                           /  \
                          20   40
                         /  \    \
                       10    25   50
         */

        preOrder(root);

        root = deleteNode(root, 20);
        System.out.println();
        preOrder(root);
    }
}
