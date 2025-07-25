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
        MergeKSorted merger = new MergeKSorted();

        // Create 3 sorted linked lists
        Node l1 = new Node(1);
        l1.next = new Node(4);
        l1.next.next = new Node(7);

        Node l2 = new Node(2);
        l2.next = new Node(5);
        l2.next.next = new Node(8);

        Node l3 = new Node(3);
        l3.next = new Node(6);
        l3.next.next = new Node(9);

        // Put lists into array
        Node[] lists = {l1, l2, l3};

        // Merge all lists
        Node mergedHead = merger.mergeKLists(lists);

        // Print merged linked list
        System.out.print("Merged List: ");
        Node temp = mergedHead;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
