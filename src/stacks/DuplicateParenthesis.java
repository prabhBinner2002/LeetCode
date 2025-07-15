package stacks;

import java.util.Stack;

public class DuplicateParenthesis {
    public static boolean isValid(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch != ')') { // Opening
                s.push(ch);
            } else { // Closing
                int count = 0;
                while (s.pop() != '(') {
                    count++;
                }
                if (count < 1) return true; // Duplicate
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "((a+b))";
        String str1 = "(a-b)";
        System.out.println(isValid(str));
    }
}
