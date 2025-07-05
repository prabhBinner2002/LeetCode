package linkedList;

public class MergeSortLL {
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

    public Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Find mid
        Node mid = getMid(head);

        // left & right halg MS
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        // merge
        return merge(newLeft, newRight);
    }

    private Node merge(Node head1, Node head2) {
        Node mergedLL = new Node (-1);
        Node temp = mergedLL;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergedLL.next;
    }

    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next; // This is a tiny difference.

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private void addFirst(int data) {
        Node node = new Node(data);
        size++;

        if (head == null) {
            head = tail = node;
            return;
        }

        node.next = head;
        head = node;
    }

    private void print() {
        if (head == null) {
            System.out.println("List is Empty.");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private void zigZag() {
        // Find the mid
         Node slow = head;
         Node fast = head.next;
         while (fast != null && fast.next != null) {
             slow = slow.next;
             fast = fast.next.next;
         }

         Node mid = slow;

        // Reverse the second half
        Node curr =  mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Alternate Merging = Zig Zag merge

        Node rightHead = prev;
        Node leftHead = head;
        Node nextL, nextR;
        while (rightHead != null && leftHead != null) {
            nextL = leftHead.next;
            leftHead.next = rightHead;
            nextR = rightHead.next;
            rightHead.next = nextL;
            rightHead = nextR;
            leftHead = nextL;
        }
    }

    public static void main(String[] args) {
        MergeSortLL ll = new MergeSortLL();
        ll.addFirst(6);
        ll.addFirst(5);
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);

        ll.print();
        ll.zigZag();
        ll.print();
    }
}
