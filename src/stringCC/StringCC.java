package stringCC;

public class StringCC {
    public static boolean isPalindrome(String str) {
        for(int i = 0; i < str.length()/2; i++) {
            if (str.charAt(i) != str.charAt(str.length()-i-1)) {
                return false;
            }
        }
        return true;
    }

    public static float shortestPath(String path) {
        int x = 0, y = 0;
        for (int i = 0; i < path.length(); i++) {
            char dir = path.charAt(i);
            switch (dir) {
                case 'N' -> y++;
                case 'S' -> y--;
                case 'E' -> x++;
                case 'W' -> x--;
            }
        }

        float sqX = x*x, sqY = y*y;

        return (float) Math.sqrt(sqX + sqY);
    }

    public static String toUpperCase(String str) {
        StringBuilder sb = new StringBuilder();

        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ' ' && i < str.length() - 1) {
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            } else {
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }

    public static String getCompressedString(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            Integer count = 1;
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            sb.append(str.charAt(i));
            if (count > 1) {
                sb.append(count);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
//        String str = "racecar";
//        System.out.println(isPalindrome(str));
//        String path = "NS";
//        System.out.println(shortestPath(path));
//        String str = "hello, world ";
//        System.out.println(toUpperCase(str));
        String str = "abbcccdd";
        System.out.println(getCompressedString(str));
    }
}
