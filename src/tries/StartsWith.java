package tries;

public class StartsWith {
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

    public static boolean startsWith(String prefix) {
        Node curr = root;
        for (char ch : prefix.toCharArray()) {
            int idx = ch - 'a';
            if (curr.children[idx] == null) return false;
            curr = curr.children[idx];
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"a","banana","app","appl","ap","apply","apple"};
        for (String word : words) {
            insert(word);
        }

        System.out.println(startsWith("app"));
        System.out.println(startsWith("appa"));
    }
}
