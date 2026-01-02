package graphs;

import java.util.*;

public class AlienDict {
    public static String alienDict(ArrayList<String> arr) {
        // adjacency as sets to avoid duplicate edges
        Map<Character, Set<Character>> graph = new HashMap<>();
        int[] indegree = new int[26];
        boolean[] present = new boolean[26];
        int presentCount = 0;

        // mark which letters exist
        for (String w : arr) {
            for (char c : w.toCharArray()) {
                int idx = c - 'a';
                if (!present[idx]) {
                    present[idx] = true;
                    presentCount++;
                }
                graph.putIfAbsent(c, new HashSet<>());
            }
        }

        // build edges from adjacent words
        for (int i = 0; i < arr.size() - 1; i++) {
            String s1 = arr.get(i);
            String s2 = arr.get(i + 1);

            int len = Math.min(s1.length(), s2.length());
            boolean diffFound = false;

            for (int j = 0; j < len; j++) {
                char c1 = s1.charAt(j);
                char c2 = s2.charAt(j);

                if (c1 != c2) {
                    // edge: c1 -> c2
                    if (graph.get(c1).add(c2)) {
                        indegree[c2 - 'a']++;
                    }
                    diffFound = true;
                    break;
                }
            }

            // invalid prefix case: "abc" before "ab"
            if (!diffFound && s1.length() > s2.length()) {
                return "";
            }
        }

        // topo sort (Kahn)
        Queue<Character> q = new LinkedList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            if (present[c - 'a'] && indegree[c - 'a'] == 0) q.offer(c);
        }

        StringBuilder ans = new StringBuilder();
        while (!q.isEmpty()) {
            char curr = q.poll();
            ans.append(curr);
            for (char nxt : graph.getOrDefault(curr, Collections.emptySet())) {
                indegree[nxt - 'a']--;
                if (indegree[nxt - 'a'] == 0) q.offer(nxt);
            }
        }

        // cycle check
        if (ans.length() != presentCount) return "";
        return ans.toString();
    }
 
    public static void main(String[] args) {

    }
}
