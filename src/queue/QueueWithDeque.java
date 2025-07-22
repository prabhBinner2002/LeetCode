package queue;

import java.util.Deque;
import java.util.LinkedList;

public class QueueWithDeque {
    static class Queue {
        static Deque<Integer> dq = new LinkedList<>();

        public static boolean isEmpty() {
            return dq.isEmpty();
        }

        public static void add(int data) {
            dq.addLast(data);
        }

        public static int remove() {
            return dq.removeFirst();
        }

        public static int peek() {
            return dq.getFirst();
        }
    }

    public static void main(String[] args) {
        Queue s = new Queue();
        s.add(1);
        s.add(2);
        s.add(3);
        while(!s.isEmpty()) {
            System.out.println(s.peek());
            s.remove();
        }
    }
}
