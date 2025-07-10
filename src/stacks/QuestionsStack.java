package stacks;

import java.util.Stack;

public class QuestionsStack {
    public static void pushAtBottom(Stack<Integer> s, int val) {
        if (s.isEmpty()) {
            s.push(val);
            return;
        }

        int top = s.pop();
        pushAtBottom(s, val);
        s.push(top);
    }

    public static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty()) return;

        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }

    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            s.push(str.charAt(i));
        }
        StringBuilder result = new StringBuilder();
        while (!s.isEmpty()) result.append(s.pop());

        return result.toString();
    }

    public static void printStack(Stack<Integer> s) {
        while(!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        reverseStack(s);
        printStack(s);
    }
}
