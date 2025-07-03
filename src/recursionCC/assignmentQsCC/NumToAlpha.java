package recursionCC.assignmentQsCC;

public class NumToAlpha {
    static String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public static void convertNumToAlpha(int num, String str) {
        if (num <= 0) {
            System.out.println(str);
            return;
        }

        int lastDigit = num % 10;
        str = words[lastDigit] + " " + str;
        num = num / 10;
        convertNumToAlpha(num, str);
    }

    public static void main(String[] args) {
        int num = 20135646;
        convertNumToAlpha(num, "");
    }
}
