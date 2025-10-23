package queue;

import java.util.NoSuchElementException;

public class QueueLL {
    static class Queue {
        // Put Node INSIDE Queue
        private static class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
            }
        }

        private Node head = null;
        private Node tail = null;

        public boolean isEmpty() {
            return head == null;
        }

        public void add(int data) { // O(1)
            Node newNode = new Node(data);  // ✅ Now works fine
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        public int remove() { // O(1)
            if (isEmpty()) {
                throw new NoSuchElementException("Queue is empty");
            }
            int front = head.data;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return front;
        }

        public int peek() {
            if (isEmpty()) {
                throw new NoSuchElementException("Queue is empty");
            }
            return head.data;
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        while (!q.isEmpty()) {
            System.out.print(q.peek() + " ");
            q.remove();
        }
    }
}
