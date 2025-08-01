package heaps;

import java.util.PriorityQueue;

public class PQwithObjects {
    static class Student implements Comparable<Student>{
        String name;
        int rank;

        public Student(int rank, String name) {
            this.rank = rank;
            this.name = name;
        }

        @Override
        public int compareTo(Student other) {
            return this.rank - other.rank;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>();

        pq.add(new Student(4, "A"));
        pq.add(new Student(5, "B"));
        pq.add(new Student(2, "C"));
        pq.add(new Student(12, "D"));

        while (!pq.isEmpty()) {
            System.out.println(pq.peek().rank + " : " + pq.peek().name);
            pq.remove();
        }
    }
}
