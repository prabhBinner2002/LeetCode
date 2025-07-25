package linkedList;

public class circularLLpractice {
    static class Node{
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node addToEmpty(Node last, int data) {
        if (last != null) return last;

        Node node = new Node(data);
        last = node;
        last.next = node;
        return last;
    }

    public static Node addFront(Node last, int data) {
        if (last == null)  return addToEmpty(last, data);

        Node node = new Node(data);
        node.next = last.next;
        last.next = node;
        return last;
    }

    public static Node addEnd(Node last, int data) {
        if (last == null) return addToEmpty(last, data);

        Node node = new Node(data);
        node.next = last.next;
        last.next = node;
        last = node;
        return last;
    }

    public static Node addAfter(Node last, int data, int item) {
        if (last == null) return null;

        Node node, p;
        p = last.next;
        do {
            if (p.data == item) {
                node = new Node(data);
                node.next = p.next;
                p.next = node;
                if (p == last) {
                    last = p;
                }
                return last;
            }
            p = p.next;
        } while (p != last.next);
        System.out.println("Item not found in the List");
        return last;
    }

    public static Node deleteNode(Node last, int key) {
        if (last == null) return null;
        else if (last == last.next) {
            last = null;
            return last;
        }

        Node node = last, d = new Node(-1);
        if (node.data == key) {
            while (node.next != last) {
                node = node.next;
            }
            node.next = last.next;
            last = node.next;
        }

        while (node.next != last && node.next.data != key) {
            node = node.next;
        }

        if (node.next.data == key) {
            d = node.next;
            node.next = d.next;
        }

        return last;
    }

    public static void traverse(Node last) {
        Node p;

        if (last == null) {
            System.out.println("List is Empty");
            return;
        }

        p = last.next;

        do {
            System.out.print(p.data + " ");
            p = p.next;
        } while (p != last.next);
    }

    public static void main(String[] args) {
        Node last = null;
        last = addToEmpty(last, 6);
        last = addEnd(last, 8);
        last = addFront(last, 2);
        last = addAfter(last, 10 , 2);
        traverse(last);
        deleteNode(last, 8);
        System.out.println(".".repeat(10));
        traverse(last);
    }
}
