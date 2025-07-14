package linkedList.assignment;

import linkedList.LinkedList.Node;

import java.util.PriorityQueue;

public class MergeKSorted {
    public Node mergeKLists(Node[] lists) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.data, b.data));

        for (Node node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        Node head = null;
        Node temp = null;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (head == null) {
                head = curr;
                temp = curr;
            } else {
                temp.next = curr;
                temp = curr;
            }

            if (curr.next != null) {
                pq.offer(curr.next);
            }
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
