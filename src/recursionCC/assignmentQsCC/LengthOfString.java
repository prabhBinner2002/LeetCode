package recursionCC.assignmentQsCC;

public class LengthOfString {
    public static int getLength(String str, int len) {
        if (str.isEmpty()) return len;
        return getLength(str.substring(1), len + 1);
    }

    public static void main(String[] args) {
        String str = "String";
        int length = 0;
        length = getLength(str, 0);
        System.out.println(length);
    }
}
