package stacks;

import java.util.ArrayList;

public class StackArray {
    static class Stack {
        static ArrayList<Integer> list = new ArrayList<>();
        public static boolean isEmpty() {
            return list.isEmpty();
        }

        // push
        public static void push(int data) {
            list.add(data);
        }

        // pop
        public static int pop() {
            if (isEmpty()) {
                return -1;
            }

            int top = list.getLast();
            list.removeLast();
            return top;
        }

        // peek
        public static int peek() {
            if (isEmpty()) {
                return -1;
            }

            return list.getLast();
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

