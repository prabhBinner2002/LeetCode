package linkedList;

import java.util.LinkedList;

public class practice {
    public static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head;
    public Node tail;
    public int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(int data) {
        Node node = new Node(data);
        size++;

        if (head == null) {
            head = tail = node;
            return;
        }

        node.next = head;
        head = node;
    }

    public void addLast(int data) {
        Node node = new Node(data);
        size++;

        if (head == null) {
            head = tail = node;
            return;
        }

        tail.next = node;
        tail = node;
    }

    public void add(int idx, int data) {
        if (idx == 0) {
            addFirst(data);
            return;
        } else if (idx == size) {
            addLast(data);
            return;
        }

        Node node = new Node(data);
        size++;

        if (head == null) {
            head = tail = node;
            return;
        }

        int i = 0;
        Node temp = head;
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }

        node.next = temp.next;
        temp.next = node;
    }

    public int removeFirst() {
        if (head == null) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int data = head.data;
            head = tail = null;
            size--;
            return data;
        }

        int data = head.data;
        head = head.next;
        size --;
        return data;
    }

    public int removeLast() {
        if (head == null) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int data = head.data;
            head = tail = null;
            return data;
        }

        Node temp = head;
        int i = 0;
        while (i < size - 2) {
            temp = temp.next;
            i++;
        }

        int data = tail.data;
        temp.next = null;
        tail = null;
        return data;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public int search(int key) {
        if (head == null) {
            System.out.println("LL is empty");
            return -1;
        }

        Node temp = head;
        int idx = 0;
        while (temp != null) {
            if (temp.data == key) {
                return idx;
            }
            temp = temp.next;
            idx++;
        }

        return -1;
    }

    private int helper(Node head, int key) {
        if (head.data == key) return 0;
        return helper(head.next, key) + 1;
    }

    public int searchRec(int key) {
        return helper(head, key);
    }

    public void reverse() {
        if (isEmpty()) {
            System.out.println("LL is Empty");
            return;
        }

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

    public int removeNthFromEnd(int idx) {
        if (isEmpty()) return Integer.MIN_VALUE;
        if (idx == size) {
            return removeFirst();
        } else if (idx == 1) {
            return removeLast();
        }

        Node temp = head;
        int i = 0;
        while (i < size - idx - 1) {
            temp = temp.next;
            i++;
        }

        int data = temp.next.data;
        temp.next = temp.next.next;
        size--;
        return data;
    }

    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public boolean isPalindrome() {
        Node prev = null;
        Node curr = getMid(head);
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;

        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    public boolean hasCycle() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            if (slow == fast) return true;
            fast = fast.next.next;
            slow = slow.next;
        }

        return false;
    }

    public void removeCycle() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            if (slow == fast) break;
            slow = slow.next;
            fast = fast.next.next;
        }

        slow = head;
        Node prev = null;
        while (slow != fast) {
            slow = slow.next;
            prev = fast;
            fast = fast.next;
        }

        prev.next = null;
        tail = prev;
    }

    private Node merge(Node leftHead, Node rightHead) {
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;
        while (leftHead != null && rightHead != null) {
            if (leftHead.data <= rightHead.data) {
                temp.next = leftHead;
                leftHead = leftHead.next;
            } else {
                temp.next = rightHead;
                rightHead = rightHead.next;
            }
            temp = temp.next;
        }

        while (leftHead != null) {
            temp.next = leftHead;
            leftHead = leftHead.next;
            temp = temp.next;
        }

        while (rightHead != null) {
            temp.next = rightHead;
            rightHead = rightHead.next;
            temp = temp.next;
        }

        return mergedLL.next;
    }

    public Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node mid = slow;
        Node rightHead = mid.next;
        mid.next = null;
        Node left = mergeSort(head);
        Node right = mergeSort(rightHead);
        return merge(left, right);
    }

    public void zigZag(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node prev = null;
        Node curr = slow.next;
        slow.next = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node leftHead = head;
        Node rightHead = prev;
        Node nextLeft;
        Node nextRight;

        while (leftHead != null && rightHead != null) {
            nextLeft = leftHead.next;
            leftHead.next = rightHead;
            nextRight = rightHead.next;
            rightHead.next = nextLeft;
            leftHead = nextLeft;
            rightHead = nextRight;
        }

    }

    public static void main(String[] args) {
        practice ll = new practice();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(3);
        ll.add(4,1);
        ll.add(4,2);
        ll.print();
        ll.zigZag(ll.head);
        ll.print();

//        Node node = new Node(2);
//        ll.head = new Node(1);
//        ll.head.next = node;
//        ll.head.next.next = new Node(3);
//        ll.head.next.next.next = node;
//
//        System.out.println(ll.hasCycle());
//        ll.removeCycle();
//        System.out.println(ll.hasCycle());
    }
}
