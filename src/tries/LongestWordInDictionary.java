package tries;

import java.security.cert.TrustAnchor;

public class LongestWordInDictionary {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
        String str;
        public TrieNode() {
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }
            this.isEnd = false;
            this.str = "";
        }
    }

    public static void insert(TrieNode root, String word) {
        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }

        // Mark only the last node as end of word
        current.isEnd = true;
        current.str = word;
    }

    public static String longestWord(String[] words) {
        TrieNode root = new TrieNode();

        // Insert æll words into the Trie
        for (String word : words) {
            insert(root, word);
        }

        // Use a String array to store the answer (mutable reference)
        String[] ans = {""};

        // Perform DFS to find the longest word
        dfs(root, ans);

        return ans[0];
    }

    public static void dfs(TrieNode current, String[] ans) {
        for (int i = 0; i < 26; i++) {
            TrieNode child = current.children[i];
            if (child != null && child.isEnd) {
                if (child.str.length() > ans[0].length() ||
                        (child.str.length() == ans[0].length() && child.str.compareTo(ans[0]) < 0)) {
                    ans[0] = child.str;
                }
                dfs(child, ans);
            }
        }
    }

    public static void main(String[] args) {
        String[] words1 = {"w","wo","wor","worl","world"};
        String[] words2 = {"a","banana","app","appl","ap","apply","apple"};
        System.out.println(longestWord(words2));
    }
}
