package stacks;

import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(41);
        st.push(3);
        st.push(32);
        st.push(2);
        st.push(11);

        sortStack(st);

        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
    }

    private static void sortStack(Stack<Integer> s) {
        if (s.isEmpty()) return;

        int n = s.pop();

        sortStack(s);

        insertStack(s, n);
    }

    private static void insertStack(Stack<Integer> s, int n) {
        if (s.isEmpty() || s.peek() <= n) {
            s.push(n);
            return;
        }

        int k = s.pop();

        insertStack(s, n);

        s.push(k);
    }
}
