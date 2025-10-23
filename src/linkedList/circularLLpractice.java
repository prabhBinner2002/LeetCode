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

    static Node addEmpty(Node last, int data) {
        if (last != null) return last;

        Node newNode = new Node(data);
        last = newNode;
        last.next = newNode;
        return last;
    }

    static Node addFirst(Node last, int data) {
        if (last == null) return addEmpty(last, data);

        Node newNode = new Node(data);
        newNode.next = last.next;
        last.next = newNode;
        return last;
    }

    static Node addLast(Node last, int data) {
        if (last == null) return addEmpty(last, data);

        Node newNode = new Node(data);
        newNode.next = last.next;
        last.next = newNode;
        last = newNode;
        return last;
    }

    static Node addAfter(Node last, int data, int item) {
        if (last == null) return null;

        Node newNode, p;
        p = last.next;
        do {
            if (p.data == item) {
                newNode = new Node(data);
                newNode.next = p.next;
                p.next = newNode;
                if (p == last) {
                    last = newNode;
                    return last;
                }
            }
            p = p.next;
        } while (p != last.next);
        System.out.println("Data is not present in the file");
        return last;
    }

    static Node deleteNode(Node last, int data) {
        if (last == null) return null;
        if (last.next == last && last.data == data) {
            last = null;
            return last;
        }

        Node temp = last, d = new Node(-1);

        if (last.data == data) {
            while (temp.next != last) {
                temp = temp.next;
            }
            temp.next = last.next;
            last = temp.next;
        }

        while (temp.next != last && temp.next.data != data) {
            temp = temp.next;
        }

        if (temp.next.data == data) {
            d = temp.next;
            temp.next = d.next;
        }

        return last;
    }

    public static void main(String[] args) {

    }
}
