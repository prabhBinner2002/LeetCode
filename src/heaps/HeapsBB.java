package heaps;

import java.util.*;

public class HeapsBB {
    static class Heap {
        private ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) { // log(n)
            // Add at last index
            arr.add(data);

            int x = arr.size() - 1; // x is child here
            int par = (x - 1) / 2; // parent index

            while (arr.get(x) < arr.get(par)) {
                // Swap
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x = par;
                par = (x - 1) / 2;
            }
        }

        public int peek() {
            return arr.get(0);
        }

        private void heapify(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minIdx = i;

            if (left < arr.size() && arr.get(minIdx) > arr.get(left))
                minIdx = left;

            if (right < arr.size() && arr.get(minIdx) > arr.get(right))
                minIdx = right;

            if (minIdx != i) {
                // Swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx);
            }
        }

        public int remove() {
            int temp = peek();

            // Step 1 : Swap 1st and last
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            // Step 2 : Remove last Node
            arr.remove(arr.size() - 1);

            // Step 3 : Heapify call for root
            heapify(0);
            return temp;
        }

        public boolean isEmpty() {
            return arr.isEmpty();
        }
    }

    public static void main(String[] args) {
        Heap pq = new Heap();
        pq.add(3);
        pq.add(4);
        pq.add(2);
        pq.add(5);
        pq.add(1);
        while (!pq.isEmpty()) { // heapSort
            System.out.println(pq.peek()); // 1 2 3 4 5
            pq.remove();
        }
    }
}
