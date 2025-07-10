package stacks;

public class StackLL {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Stack{
        static Node head = null;

        public static boolean isEmpty() {
            return head == null;
        }

        public static void push(int data) {
            Node node = new Node(data);
            if (isEmpty()) {
                head = node;
                return;
            }

            node.next = head;
            head = node;
        }

        public static int pop() {
            if (isEmpty()) {
                return -1;
            }

            int top = head.data;
            head = head.next;
            return top;
        }

        public static int peek() {
            if (isEmpty()) {
                return -1;
            }

            return head.data;
        }
    }

    public static void main(String[] args) {
        Stack S = new Stack();
        S.push(1);
        S.push(2);
        S.push(3);
        while (!S.isEmpty()) {
            System.out.println(S.peek());
            S.pop();
        }
    }
}
