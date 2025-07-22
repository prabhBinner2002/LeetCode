package binaryTrees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreesB {
    static class Node {
        int data;
        Node left;
        Node right;

        Node (int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int index = -1;

        public static Node buildTree(int[] nodes) {
            index++;
            if (nodes[index] == -1) return null;

            Node newNode = new Node(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        public static void preOrder(Node root) {
            if (root == null) {
//                System.out.print(-1 + " ");
                return;
            }

            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public static void inOrder(Node root) {
            if (root == null) {
                System.out.print(-1 + " ");
                return;
            }

            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

        public static void postOrder(Node root) {
            if (root == null) {
//                System.out.print(-1 + " ");
                return;
            }

            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }

        public static void levelOrder(Node root) {
            if (root == null) {
                return;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.data + " ");
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
        }

        public static int height(Node root) {
            if (root == null) return 0;

            int lh = height(root.left);
            int rh = height(root.right);
            return Math.max(lh, rh) + 1;
        }

        public static int count(Node root) {
            if (root == null) return 0;

            int lc = count(root.left);
            int rc = count(root.right);
            return lc + rc + 1;
        }

        public static int sum(Node root) {
            if (root == null) return 0;
            int ls = sum(root.left);
            int rs = sum(root.right);
            return rs + ls + root.data;
        }

        public static int diameterA2(Node root) { // O(n^2)
            if (root == null) return 0;

            int leftDiam = diameterA2(root.left);
            int leftH = height(root.left);
            int rightDiam = diameterA2(root.right);
            int rightH = height(root.right);

            int selfDiam = leftH + rightH + 1;

            return Math.max(selfDiam, Math.max(leftDiam, rightDiam));
        }

        static class Info {
            int diameter;
            int height;

            public Info(int diameter, int height) {
                this.diameter = diameter;
                this.height = height;
            }
        }

        public static BinaryTree.Info diameter(Node root) { // O(n)
            if (root == null) return new BinaryTree.Info(0, 0);

            BinaryTree.Info leftInfo = diameter(root.left);
            BinaryTree.Info rightInfo = diameter(root.right);

            int dia = Math.max(Math.max(leftInfo.diameter, rightInfo.diameter), leftInfo.height + rightInfo.height + 1);
            int ht = Math.max(leftInfo.height, rightInfo.height) + 1;
            return new BinaryTree.Info(dia, ht);
        }

        public static boolean isIdentical(Node node, Node subRoot) {
            if (node == null && subRoot == null) return true;
            else if (node == null || subRoot == null || node.data != subRoot.data) return false;

            if (!isIdentical(node.left, subRoot.left)) return false;
            if (!isIdentical(node.right, subRoot.right)) return false;

            return true;
        }

        public static boolean isSubTree(Node root, Node subRoot) {
            if (root == null) return false;

            if (root.data == subRoot.data)
                if (isIdentical(root, subRoot)) return true;

            return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
        }

        static class Inf {
            Node node;
            int hd;
            public Inf(Node node, int hd) {
                this.hd = hd;
                this.node = node;
            }
        }

        public static void topView(Node root) {
            // Level Order
            Queue<Inf> q = new LinkedList<>();
            HashMap<Integer, Node> map = new HashMap<>();

            int min = 0, max = 0;
            q.add(new Inf(root, 0));
            q.add(null);

            while (!q.isEmpty()) {
                Inf curr = q.remove();
                if (curr == null) {
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    if (!map.containsKey(curr.hd)) { // First time my HD is occuring
                        map.put(curr.hd, curr.node);
                    }

                    if (curr.node.left != null) {
                        q.add(new Inf(curr.node.left, curr.hd - 1));
                        min = Math.min(min, curr.hd - 1);
                    } if (curr.node.right != null) {
                        q.add(new Inf(curr.node.right, curr.hd + 1));
                        max = Math.max(max, curr.hd + 1);
                    }
                }
            }

            for (int i = min; i <= max; i++) {
                System.out.print(map.get(i).data + " ");
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        BinaryTree.topView(root);
    }
}
