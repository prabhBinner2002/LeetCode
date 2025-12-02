package linkedList;

import java.util.LinkedList;
import java.util.Queue;

public class DoubleLL {
    public class Node {
        int data;
        Node next;
        Node prev;
        Node left, right = null;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
            this.left = null;
            this.right = null;
        }
    }

    public Node head;
    public Node tail;
    public int size;

    public void addFirst(int data) {
        Node node = new Node(data);
        size++;

        if (head == null) {
            head = tail = node;
            return;
        }

        node.next = head;
        head.prev = node;
        head = node;
    }

    public void addLast(int data) {
        Node node = new Node (data);
        size++;

        if (head == null) {
            head = tail = node;
            return;
        }

        node.prev = tail;
        tail.next = node;
        tail = node;
    }

    public int removeFirst() {
        if (head == null) {
            System.out.println("DLL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }

    public int removeLast() {
        if (head == null) {
            System.out.println("DLL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }

        Node prev = head;
        int i = 0;
        while (i <= size - 1) {
            prev = prev.next;
        }

        int val = tail.data;
        prev.next = null;
        tail.prev = null;
        size--;
        tail = prev;
        return val;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void reverse() {
        Node curr = head;
        Node prev = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }

        head = prev;
    }

    public static Node createBst(Node head, Node tail) {
        if (head == null || head.next == null) {
            return head;
        }

        Node root = getMid(head);
        Node left = root.prev;
        if (root.prev != null)
            root.prev.next = null;
        Node right = root.next;
        root.left = createBst(head, left);
        root.right = createBst(right, tail);

        return root;
    }

    public static Node getMid(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void levelOrder(Node root) {
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr == null) {
                System.out.println();
                if (q.isEmpty()) break;
                else q.add(null);
            } else {
                System.out.print(curr.data + " ");
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
        }
    }

    public static void main(String[] args) {
        DoubleLL dll = new DoubleLL();
        dll.addLast(1);
        dll.addLast(2);
        dll.addLast(3);
        dll.addLast(4);
        dll.addLast(5);
        dll.print();

        Node root = createBst(dll.head, dll.tail);
        inorder(root);
        System.out.println();
        levelOrder(root);
    }
}
