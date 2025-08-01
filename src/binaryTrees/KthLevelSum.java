package binaryTrees;

import java.util.*;

public class KthLevelSum {
    static class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
        }
    }

    private static int util1(Node root, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        int currentLevel = 0;

        while (!q.isEmpty()) {
            Node curr = q.remove();
            if (curr == null) {
                res.add(currentLevel);
                currentLevel = 0;
                if (q.isEmpty()) break;
                else q.add(null);
            } else {
                currentLevel += curr.data;
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
        }

        if (k > res.size()) return -1;

        Collections.sort(res, Collections.reverseOrder());

        int sum = res.get(k - 1);

        return sum;
    }

    public static Long kthLevelSum(Node root, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            long currLevelSum = 0L;

            for (int i = 0; i < size; i++) {
                Node node = q.remove();
                currLevelSum += node.data;

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }

            if (pq.size() < k) {
                pq.add(currLevelSum);
            } else {
                if (pq.peek() < currLevelSum) {
                    pq.remove();
                    pq.add(currLevelSum);
                }
            }
        }

        return pq.size() < k ? -1 : pq.peek();
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        System.out.println(kthLevelSum(root, 1));
    }
}
