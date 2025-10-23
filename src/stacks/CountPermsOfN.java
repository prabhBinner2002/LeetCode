package stacks;

import java.util.Stack;

public class CountPermsOfN {
    private static int solution(int n) {
        Stack<Integer> s = new Stack<>();
        int ans = 0;
        outer :for (int i = 1; i <= n; i++) {
            if (!s.isEmpty())
                while(!s.isEmpty())
                    s.pop();

            int temp = i;
            while(i > 0) {
                int lastDigit = i % 10;
                s.push(lastDigit);
                i /= 10;
            }
            i = temp;

            while(!s.isEmpty()) {
                int j = s.pop();
                if (s.isEmpty()) break;
                int k = s.pop();
                if (j > k) continue outer;
            }

            ans++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 123;
        System.out.println(solution(n));
    }
}
