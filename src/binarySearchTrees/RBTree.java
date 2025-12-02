package binarySearchTrees;

public class RBTree {
    private Node root;
    private final Node Nil;

    private class Node {
        Node parent, left, right;
        boolean red;
        int data;
        Node(int k) {
            data = k;
            red = true;
            parent = left = right = null;
        }
    }

    public RBTree() {
        Nil = new Node(0);
        Nil.red = false;
        Nil.left = Nil.right = Nil.parent = Nil;
        root = Nil;
    }

    public void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != Nil) y.left.parent = x;

        y.parent = x.parent;
        if (x.parent == Nil) root = y;
        else if (x == x.parent.left) x.parent.left = y;
        else x.parent.right = y;

        y.left = x;
        x.parent = y;
    }

    public void rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;
        if (y.right != Nil) y.right.parent = x;

        y.parent = x.parent;
        if (x.parent == Nil) root = y;
        else if (x == x.parent.right) x.parent.right = y;
        else x.parent.left = y;

        y.right = x;
        x.parent = y;
    }

    public void insert(int data) {
        Node y = Nil;
        Node x = root;

        while (x != Nil) {
            y = x;
            if (data < x.data) x = x.left;
            else x = x.right;
        }

        Node z = new Node(data);
        z.parent = y;

        if (y == Nil) root = z;
        else if (z.data < y.data) y.left = z;
        else y.right = z;

        z.left = Nil;
        z.right = Nil;
        z.red = true;

        fixup(z);
    }

    private void fixup(Node z) {
        while (z.parent.red) {
            if (z.parent == z.parent.parent.left) {
                Node y = z.parent.parent.right;
                if (y.red) {
                    z.parent.red = false;
                    y.red = false;
                    z.parent.parent.red = true;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.right) {
                        z = z.parent;
                        leftRotate(z);
                    }
                    z.parent.red = false;
                    z.parent.parent.red = true;
                    rightRotate(z.parent.parent);
                }
            } else {
                Node y = z.parent.parent.left;
                if (y.red) {
                    z.parent.red = false;
                    y.red = false;
                    z.parent.parent.red = true;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.left) {
                        z = z.parent;
                        rightRotate(z);
                    }
                    z.parent.red = false;
                    z.parent.parent.red = true;
                    leftRotate(z.parent.parent);
                }
            }
        }
        root.red = false;
    }

    public void inorder(Node n) {
        if (n != Nil) {
            inorder(n.left);
            System.out.print(n.data + (n.red ? "R " : "B "));
            inorder(n.right);
        }
    }

    private void transplant(Node u, Node v) {
        if (u.parent == Nil) root = v;
        else if (u == u.parent.left) u.parent.left = v;
        else u.parent.right = v;
        v.parent = u.parent;
    }

    public void delete(int key) {
        Node z = search(root, key);
        if (z == Nil) return;

        Node y = z;
        Node x;
        boolean yOriginalRed = y.red;

        // Case 1: no left child
        if (z.left == Nil) {
            x = z.right;
            transplant(z, z.right);
        }
        // Case 2: no right child
        else if (z.right == Nil) {
            x = z.left;
            transplant(z, z.left);
        }
        // Case 3: two children
        else {
            y = minimum(z.right);
            yOriginalRed = y.red;
            x = y.right;

            if (y.parent == z) {
                x.parent = y;
            } else {
                transplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }

            transplant(z, y);
            y.left = z.left;
            y.left.parent = y;
            y.red = z.red;
        }

        if (!yOriginalRed)
            deleteFixup(x);
    }


    private void deleteFixup(Node x) {
        while (x != root && !x.red) {
            if (x == x.parent.left) {
                Node w = x.parent.right;

                if (w.red) {
                    w.red = false;
                    x.parent.red = true;
                    leftRotate(x.parent);
                    w = x.parent.right;
                }

                if (!w.left.red && !w.right.red) {
                    w.red = true;
                    x = x.parent;
                } else {
                    if (!w.right.red) {
                        w.left.red = false;
                        w.red = true;
                        rightRotate(w);
                        w = x.parent.right;
                    }
                    w.red = x.parent.red;
                    x.parent.red = false;
                    w.right.red = false;
                    leftRotate(x.parent);
                    x = root;
                }
            } else {
                Node w = x.parent.left;

                if (w.red) {
                    w.red = false;
                    x.parent.red = true;
                    rightRotate(x.parent);
                    w = x.parent.left;
                }

                if (!w.right.red && !w.left.red) {
                    w.red = true;
                    x = x.parent;
                } else {
                    if (!w.left.red) {
                        w.right.red = false;
                        w.red = true;
                        leftRotate(w);
                        w = x.parent.left;
                    }
                    w.red = x.parent.red;
                    x.parent.red = false;
                    w.left.red = false;
                    rightRotate(x.parent);
                    x = root;
                }
            }
        }
        x.red = false;
    }

    private Node search(Node n, int key) {
        while (n != Nil && key != n.data) {
            if (key < n.data) n = n.left;
            else n = n.right;
        }
        return n;
    }

    private Node minimum(Node n) {
        while (n.left != Nil) n = n.left;
        return n;
    }

    public Node getRoot() { return root; }

    private void printTreeHelper(Node root, String prefix, boolean isLeft) {
        if (root != Nil) {
            // Print right subtree first
            printTreeHelper(root.right, prefix + (isLeft ? "│   " : "    "), false);

            // Print current node
            System.out.println(prefix + (isLeft ? "└── " : "┌── ") + root.data + " " + (root.red ? "R" : "B"));

            // Print left subtree
            printTreeHelper(root.left, prefix + (isLeft ? "    " : "│   "), true);
        }
    }

    public static void main(String[] args) {
        RBTree t = new RBTree();
        int[] arr = {10, 5, 15};
        for (int i : arr) t.insert(i);
        t.inorder(t.getRoot());
        System.out.println();
        t.printTreeHelper(t.getRoot(), "", false);
        t.delete(10);
        t.printTreeHelper(t.getRoot(), "", false);
        t.delete(5);
        t.printTreeHelper(t.getRoot(), "", false);
        t.delete(15);
        t.printTreeHelper(t.getRoot(), "", false);
        System.out.println(t);
    }
}
