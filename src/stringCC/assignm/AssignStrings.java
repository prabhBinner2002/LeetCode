package stringCC.assignm;

import java.util.Arrays;
import java.util.HashMap;

public class AssignStrings {
    public static int countLowerCaseLetter(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a') {
                count++;
            }
        }
        return count;
    }

    public static boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        /*
        // Solution 1: Sort both strings and compare if equal. TC: O(nlogn)

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
        */

        /*
        // Solution 2: HashMap TC: O(n) ; SC: O(n)

        HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();

        for (int i = 0; i < str1.length(); i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);

            map1.put(ch1, map1.getOrDefault(ch1, 0) + 1);
            map2.put(ch2, map2.getOrDefault(ch2, 0) + 1);
        }

        return map1.equals(map2);
        */


        // Solution 3: TC: O(n): O(2*N) + O(26), SC: O(26)
        int[] count = new int[26];

        for (int i = 0; i < str1.length(); i++) {
            count[str1.charAt(i) - 'a']++;
            count[str2.charAt(i) - 'a']--;
        }

        for (int i : count) {
            if (i < 0) return false;
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(isAnagram("cat", "tac"));
    }
}
