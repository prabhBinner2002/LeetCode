package linkedList;

public class LL {
    public static class Node{
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public boolean hasCycle() { // Floyd's Cycle Finding Algorithm
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.equals(fast)) {
                return true;
            }
        }

        return false;
    }

    public void removeCycle() {
        // Detect Cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                cycle = true;
                break;
            }
        }

        if (cycle == false) {
            return;
        }

        // Find meeting point
        slow = head;
        Node prev = null;
        while (slow != fast) {
            slow = slow.next;
            prev = fast;
            fast = fast.next;
        }

        // Remove Cycle : lastNode.next = null
        prev.next = null;
        tail = prev;
    }

    public static void main(String[] args) {
        LL list = new LL();
        Node node = new Node(2);
        list.head = new Node(1);
        list.head.next = node;
        list.head.next.next = new Node(3);
        list.head.next.next.next = node;

        System.out.println(list.hasCycle());
        list.removeCycle();
        System.out.println(list.hasCycle());
    }
}
