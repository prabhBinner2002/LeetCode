package queue;

public class CircularQueue {
    static class Queue {
        static int[] arr;
        static int size;
        static int rear;
        static int front;

        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        public static boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public static boolean isFull() {
            return (rear + 1) % size == front;
        }

        public static void add(int data) { //O(1)
            if (isFull()) {
                System.out.println("Queue is Full");
                return;
            }

            if (front == -1) // For adding first element
                front = 0;

            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        public static int remove() { // O(1)
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }

            int res = arr[front];
            front = (front + 1) % size;

            // last Element delete
            if (rear == front) {
                rear = front = -1;
            } else {
                front = (front + 1) % size;
            }

            return res;
        }

        public static int peek() { // O(1)
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }

            return arr[front];
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(3);
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.remove());
        q.add(4);
        System.out.println(q.remove());
        q.add(5);

        // 1 2 3
        while (!q.isEmpty()) {
            System.out.print(q.peek() + " ");
            q.remove();
        }
    }
}
