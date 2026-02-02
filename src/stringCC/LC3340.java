package stringCC;

public class LC3340 {
    public static boolean isBalanced(String num) {
        int odd = 0, even = 0;

        if (num.length() %  2 != 0) {
            for (int i = 0, j = 1; j < num.length(); i = i + 2, j = j + 2) {
                even += num.charAt(i) - '0';
                odd += num.charAt(j) - '0';
            }
            even += num.charAt(num.length() - 1) - '0';
        } else {
            for (int i = 0, j = 1; j < num.length(); i = i + 2, j = j + 2) {
                even += num.charAt(i) - '0';
                odd += num.charAt(j) - '0';
            }
        }

        return even == odd ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("1234"));
    }
}
