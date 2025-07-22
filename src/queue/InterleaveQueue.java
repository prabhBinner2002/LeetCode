package queue;

import java.util.*;

public class InterleaveQueue {
    public static void interLeave(Queue<Integer> q) {
        Queue<Integer> first = new LinkedList<>();
        int size = q.size();
        for (int i = 0; i < size / 2; i++) {
            first.add(q.remove());
        }

        while (!first.isEmpty()) {
            q.add(first.remove());
            q.add(q.remove());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= 10; i++) {
            q.add(i);
        }
        interLeave(q);
        System.out.println(q);
    }
}
