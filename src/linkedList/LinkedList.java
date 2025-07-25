package linkedList;

public class LinkedList {
    public static class Node{
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head;
    public Node tail;
    public int size;

    public void addFirst(int data) {
        // Step 1: Create new Node
        Node newNode = new Node(data);
        size++;

        if (head == null) { // If LL is empty
            head = tail = newNode;
            return;
        }

        // Step 2: newNode.next = head Linking step
        newNode.next = head; // link

        // Step 3: head = newNode
        head = newNode;

    }

    public void addLast(int data) {
        // Step 1: Create a new Node
        Node newNode = new Node(data);
        size++;

        if (head == null) {  // If LL is empty
            head = tail = newNode;
            return;
        }

        // Step 2: tail point to newNode
        tail.next = newNode;

        // Step 3: newNode is tail now
        tail = newNode;
    }

    public void print() {

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print(null + "\n");

    }

    public void add(int idx, int data) {
        if (idx == 0) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        while ( i < idx - 1 ) {
            temp = temp.next;
            i++;
        }

        // i = idx - 1; temp -> prev
        newNode.next = temp.next;
        temp.next = newNode;

    }

    public int removeFirst() {

        if (size == 0) {
            System.out.println("Linked is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if (size == 0) {
            System.out.println("Linked list is Empty.");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            size = 0;
            int val = head.data;
            head = tail = null;
            return val;
        }

        // prev : i = size - 2;
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }

        int val = tail.data; // prev.next.data
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public int itrSearch(int key) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public int helper(Node head, int key) {
        if (head == null) return -1;
        if (head.data == key) return 0;
        int idx = helper(head.next, key);
        if (idx == -1) return -1;
        return idx + 1;
    }

    public int recSearch(int key) {
        return helper(head, key);
    }

    public void reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }

    public void deleteNthFromEnd(int n) {
        // Calculate size of LL
        int size = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }

        if (n == size) {
            head = head.next; // removeFirst
            return;
        }

        // size - n
        int i = 1;
        int iToFind = size - n;
        Node prev = head;
        while (i < iToFind) {
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
    }

    public Node findMid(Node head) { // Slow Fast Approach
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2
        }

        return slow; // Slow is my midNode
    }

    public boolean checkPalindrome() {
        if (head == null || head.next == null) return true;

        // Step 1: Find Mid
        Node midNode = findMid(head);

        // Step 2: Reverse Second half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while (curr != null) {
            next  = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev; // Right half head
        Node left = head;

        // Step 3: Check left and right half
        while (right != null) {
            if (left.data != right.data) return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
//        ll.addFirst(2);
//        ll.addFirst(1);
//        ll.addLast(2);
//        ll.addLast(1);
//        ll.add(2, 2); // 1 -> 2 -> 3 -> 4 -> 5 -> null
//     /* ll.removeFirst(); // 2 -> 3 -> 4 -> 5 -> null
//        ll.removeLast(); // 2 -> 3 -> 4 -> nul */
////      ll.reverse();
//        System.out.println(ll.checkPalindrome());
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);
        ll.add(4,5);
        ll.addLast(6);
        ll.print();

    }
}
