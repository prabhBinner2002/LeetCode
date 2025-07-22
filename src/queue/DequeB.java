package queue;

import java.util.Deque;
import java.util.LinkedList;

public class DequeB {
    public static void main(String[] args) {
        Deque<Integer> q = new LinkedList<>();
        q.addFirst(1);
        q.addFirst(2);
        q.addLast(3);
        q.addLast(4);
        System.out.println(q);
        q.removeFirst();
        System.out.println(q);
    }
}
