    package binarySearchTrees;

    public class RedBlackTree {
        public Node root;
        public RedBlackTree() {
            super();
            root = null;
        }

        private class Node {
            int data;
            Node left, right, parent;
            char color;

            Node (int data) {
                super();
                this.data = data;
                this.left = null;
                this.right = null;
                this.parent = null;
                this.color = 'R';
            }
        }

        private Node rotateLeft(Node x) {
            Node y = x.right;
            Node T2 = y.left;

            y.left = x;
            x.parent = y;
            x.right = T2;

            if (T2 != null) T2.parent = x;

            return y;
        }

        private Node rotateRight(Node y) {
            Node x = y.left;
            Node T2 = x.right;

            x.right = y;
            y.parent = x;
            y.left = T2;

            if(T2 != null) T2.parent = y;

            return x;
        }

        private boolean ll = false;
        private boolean lr = false;
        private boolean rr = false;
        private boolean rl = false;

        private Node insertHelp(Node root, int data) {
            boolean f = false; // If Red - Red conflict arises, this flag turns on.

            if (root == null) return new Node(data);
            else if (data < root.data) {
                root.left = insertHelp(root.left, data);
                root.left.parent = root; // Assigning Parent nodes
                if (root != this.root)
                    if (root.color == 'R' && root.left.color == 'R') f = true; // Check for Red - Red case
            }
            else if (data > root.data) {
                root.right = insertHelp(root.right, data);
                root.right.parent = root; // Assigning Parent nodes
                if (root != this.root)
                    if (root.color == 'R' && root.right.color == 'R') f = true; // Check for Red - Red case
            }

            if (this.ll) {
                root = rotateLeft(root);
                root.color = 'B';
                root.left.color = 'R';
                this.ll = false;
            } else if (this.rr) {
                root = rotateRight(root);
                root.color = 'B';
                root.right.color ='R';
                this.rr = false;
            } else if (this.rl) {
                root.right = rotateRight(root.right);
                root = rotateLeft(root);
                root.color = 'B';
                root.left.color = 'R';
                this.rl = false;
            } else if (this.lr) {
                root.left = rotateLeft(root.left);
                root = rotateRight(root);
                root.color = 'B';
                root.right.color = 'R';
                this.lr = false;
            }

            if (f) {
                if (root.parent.right == root) {
                    if (root.parent.left == null || root.parent.left.color == 'B') {
                        if (root.left != null && root.left.color == 'R') this.rl = true;
                        else if (root.right != null && root.right.color == 'R') this.ll = true;
                    } else {
                        root.parent.left.color = 'B';
                        root.color = 'B';
                        if (root.parent != this.root) root.parent.color = 'R';
                    }
                } else {
                    if (root.parent.right != null && root.parent.left.color == 'B') {
                        if (root.left != null && root.left.color == 'R') this.rr = true;
                        else if (root.right != null && root.right.color == 'R') this.lr = true;
                    } else {
                        root.parent.right.color = 'B';
                        root.color = 'B';
                        if (root.parent != this.root) root.parent.color = 'R';
                    }
                }
                f = false;
            }
            return root;
        }

        public void insert(int data) {
            if (this.root == null) {
                this.root = new Node(data);
                this.root.color = 'B';
            } else {
                this.root = insertHelp(this.root, data);
            }
        }

        public Node getInorderSucc(Node root) {
            if (root.left == null ) return root;
            return getInorderSucc(root.left);
        }

        public Node deleteHelper(Node root, Node z) {
            if (z == null) return root;
            Node temp = null;
            char zColor = z.color;
            if (z.data < this.root.data) root.left = deleteHelper(root.left, z);
            else if (z.data > this.root.data) root.right = deleteHelper(root.right, z);
            else {
                if (z.left == null || z.right == null) {
                    if (z.left == null) {
                        temp = z.right;
                    } else if (z.right == null) {
                        temp = z.left;
                    }

                    if (temp == null) {
                        temp = root;
                        root = null;
                    } else {
                        root = temp;
                    }
                } else {
                    Node is = getInorderSucc(root.right);
                    root.data = is.data;
                    root.color = is.color;
                    root.right = deleteHelper(root.right, is);
                }
            }

            if (root == null) return root;

            Node w = null;
            if (zColor == 'B') {
                while (z != this.root && zColor == 'B') {
                    if (z == z.parent.left) {
                        w = z.parent.right;
                        if (w.color == 'R') {
                            w.color = 'B';
                            z.parent.color = 'R';
                            rotateLeft(z.parent);
                            w = z.parent.right;
                        } if (w.left.color == 'B' && w.right.color == 'B') {
                            z.color = 'R';
                            z = z.parent;
                        } else {
                            if (w.right.color == 'B') {
                                w.left.color = 'B';
                                w.color = 'R';
                                rotateRight(w);
                                w = z.parent.right;
                            }
                            w.color = z.parent.color;
                            z.parent.color = 'B';
                            z.right.color = 'B';
                            rotateLeft(z.parent);
                            z = this.root;
                        }
                    } else {
                        w = z.parent.left;
                        if (w.color == 'R') {
                            w.color = 'B';
                            z.parent.color = 'R';
                            rotateRight(z.parent);
                            w = z.parent.left;
                        } if (w.right.color == 'B' && w.left.color == 'B') {
                            z.color = 'R';
                            z = z.parent;
                        } else {
                            if (w.left.color == 'B') {
                                w.right.color = 'B';
                                w.color = 'R';
                                rotateLeft(w);
                                w = z.parent.left;
                            }
                            w.color = z.parent.color;
                            z.parent.color = 'B';
                            z.left.color = 'B';
                            rotateRight(z.parent);
                            z = this.root;
                        }
                    }
                }
                z.color = 'B';
            }
            return root;
        }

        private void inOrderTraversalHelper(Node root) {
            if (root == null) return;
            inOrderTraversalHelper(root.left);
            System.out.print(root.data + " ");
            inOrderTraversalHelper(root.right);
        }

        public void inorder() {
            inOrderTraversalHelper(this.root);
        }

        private void printTreeHelper(Node root, String prefix, boolean isLeft) {
            if (root != null) {
                // Print right subtree first
                printTreeHelper(root.right, prefix + (isLeft ? "│   " : "    "), false);

                // Print current node
                System.out.println(prefix + (isLeft ? "└── " : "┌── ") + root.data + " " + root.color);

                // Print left subtree
                printTreeHelper(root.left, prefix + (isLeft ? "    " : "│   "), true);
            }
        }

        public void printTree() {
            printTreeHelper(this.root, "", true);
        }

        public static void main(String[] args) {
            RedBlackTree t = new RedBlackTree();
            int[] arr = {1,6,3,5,7,8,2,9};

            for (int i : arr) {
                t.insert(i);
            }
            System.out.println();
            System.out.println();
            t.printTree();

            t.insert(4);

            System.out.println();
            System.out.println();
            t.printTree();
        }
    }
