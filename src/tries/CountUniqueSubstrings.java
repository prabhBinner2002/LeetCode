package tries;

public class CountUniqueSubstrings {
    public static class Node {
        Node[] children = new Node[26];
        boolean endOfWord;
        public Node() {
            int i = 0;
            while (i < 26) {
                children[i] = null;
                i++;
            }
            endOfWord = false;
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.endOfWord = true;
    }

    public static boolean search(String word) {
        Node curr = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (curr.children[idx] == null) return false;
            curr = curr.children[idx];
        }
        return curr.endOfWord;
    }

    public static int countNodes(Node root) {
        if (root == null) return 0;

        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null)
                count += countNodes(root.children[i]);
        }

        return count + 1;
    }

    public static void main(String[] args) {
        String str = "apple"; // Ans - 15

        // Suffix -> insert in trie
        for (int i = 0; i < str.length(); i++) {
            String suffix = str.substring(i);
            insert(suffix);
        }

        System.out.println(countNodes(root));
    }
}
