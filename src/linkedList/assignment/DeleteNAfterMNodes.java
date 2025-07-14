package linkedList.assignment;

import linkedList.LinkedList;
import linkedList.LinkedList.Node;

public class DeleteNAfterMNodes {
    public void deleteNAfterM(Node head, int m, int n) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            for (int i = 0; i < m && curr != null; i++) {
                prev = curr;
                curr = curr.next;
            }
            for (int i = 0; i < n && curr != null; i++) {
                curr = curr.next;
            }
            prev.next = curr;
        }
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(9);
        ll.addFirst(8);
        ll.addFirst(7);
        ll.addFirst(6);
        ll.addFirst(5);
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        Node head = ll.head;
        ll.print();
        DeleteNAfterMNodes solution = new DeleteNAfterMNodes();
        solution.deleteNAfterM(head, 2, 2);
        ll.print();
    }
}
