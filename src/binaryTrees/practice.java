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

    public static void levelOrder(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()) {
            Node node = q.poll();
            if (node == null) {
                System.out.println();
                if (q.isEmpty()) break;
                else q.add(null);
            } else {
                System.out.print(node.data + " ");
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
        }
    }

    static class Info {
        int d;
        int h;
        public Info(int d, int h) {
            this.h = h;
            this.d = d;
        }
    }

    public static Info diameter(Node root) {
        if (root == null) return new Info(0, 0);

        Info left = diameter(root.left);
        Info right = diameter(root.right);

        int d = Math.max(Math.max(left.d, right.d), left.h + right.h + 1);
        int h = Math.max(right.h, left.h) + 1;

        return new Info(d, h);
    }

    private static boolean isIdentical(Node root, Node subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }

        if (root == null || subRoot == null || root.data != subRoot.data) return false;

        if (!isIdentical(root.left, subRoot.left)) return false;
        if (!isIdentical(root.right, subRoot.right)) return false;

        return true;
    }

    public static boolean checkSubTree(Node root, Node subRoot) {
        if (root == null) return false;

        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) return true;
        }

        return checkSubTree(root.left, subRoot) || checkSubTree(root.right, subRoot);
    }

    static class Inf {
        Node node;
        int hd;
        public Inf(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topView(Node root) {
        if (root == null) return;

        Queue<Inf> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        q.add(new Inf(root, 0));
        q.add(null);

        int max = 0, min = 0;
        while (!q.isEmpty()) {
            Inf curr = q.poll();
            if (curr == null) {
                if (q.isEmpty()) break;
                else q.add(null);
            } else {
                if (!map.containsKey(curr.hd)) {
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

    public static Node getLca(Node root, int n1, int n2) {
        if (root == null || root.data == n1 || root.data == n2) return root;

        Node leftLca = getLca(root.left, n1, n2);
        Node rightLca = getLca(root.right, n1, n2);

        if (leftLca == null) return rightLca;
        if (rightLca == null) return leftLca;

        return root;
    }

    public static int getDist(Node root, int n) {
        if (root == null) return -1;
        if (root.data == n) return 0;

        int leftDist = getDist(root.left, n);
        int rightDist = getDist(root.right, n);

        if (leftDist == -1 && rightDist == -1) return -1;
        else if (leftDist > -1) return leftDist + 1;
        else return rightDist + 1;
    }

    public static int minDist(Node root, int n1, int n2) {
        Node lca = getLca(root, n1, n2);
        int dist1 = getDist(lca, n1);
        int dist2 = getDist(lca, n2);

        return dist1 + dist2;
    }

    public static int getKthAncestor(Node root, int n, int k) {
        if (root == null) return -1;
        if (root.data == n) return 0;

        int left = getKthAncestor(root.left, n, k);
        int right = getKthAncestor(root.right, n, k);

        if (left == -1 && right == -1) return -1;

        int max = Math.max(left, right);

        if (max + 1 == k) return root.data;

        return max + 1;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);
//        Node root = new Node(1);
//        root.left = new Node(2);
//        root.left.right = new Node(3);
//        root.left.right.left = new Node(4);
//        root.left.right.right = new Node(5);
//        root.left.right.right.right = new Node(5);
//        System.out.println(minDist(root, 1, 10));

//        System.out.println(minDist(root, 4, 6)); // Number of Edges
//        System.out.println(hasSubTree(root, subRoot));
//        System.out.println(getLca(root, 2, 5).data);
        System.out.println(getKthAncestor(root, 3, 2));
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
