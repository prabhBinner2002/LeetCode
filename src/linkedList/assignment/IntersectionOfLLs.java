package linkedList.assignment;

import linkedList.LinkedList;
import linkedList.LinkedList.Node;

import java.util.HashSet;

public class IntersectionOfLLs {
    public Node getInterSection(Node head1, Node head2) { // TC: O(n) SC: O(n)
        HashSet<Node> set = new HashSet<>();

        while (head1 != null) {
            set.add(head1);
            head1 = head1.next;
        }

        while (head2 != null) {
            if (set.contains(head2))
                return head2;
            head2 = head2.next;
        }

        return null;
    }

    public Node getIntersection(Node headA, Node headB) {
        Node curr1 = headA;
        Node curr2 = headB;

        while (curr1 != curr2) {
            curr1 = curr1.next;
            curr2 = curr2.next;
            if (curr2 == null && curr1 == null)
                return null;
            if (curr1 == null)
                curr1 = headB;
            if (curr2 == null)
                curr2 = headA;
        }

        return curr1;
    }

    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        LinkedList ll2 = new LinkedList();

        // Shared node (intersection starts here)
        Node intersectNode = new Node(30);
        intersectNode.next = new Node(40);
        intersectNode.next.next = new Node(50);

        // First list: 10 -> 20 -> 30 -> 40 -> 50
        ll1.head = new Node(10);
        ll1.head.next = new Node(20);
        ll1.head.next.next = intersectNode;

        // Second list: 99 -> 30 -> 40 -> 50
        ll2.head = new Node(99);
        ll2.head.next = intersectNode;

        ll1.print();
        ll2.print();

        IntersectionOfLLs solution = new IntersectionOfLLs();
        Node result = solution.getIntersection(ll1.head, ll2.head);

        if (result != null) {
            System.out.println("Intersection at node with data: " + result.data);
        } else {
            System.out.println("No intersection found.");
        }
    }
}
