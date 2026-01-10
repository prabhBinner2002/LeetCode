package graphs;

import java.util.*;

public class WordLadder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();

        q.offer(beginWord);
        set.remove(beginWord);

        int level = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String curr = q.poll();

                if (endWord.equals(curr)) return level;

                char[] word = curr.toCharArray();

                for (int j = 0; j < word.length; j++) {
                    char original = word[j];

                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        word[j] = ch;

                        String w = new String(word);
                        if (set.contains(w)) {
                            q.offer(w);
                            set.remove(w);
                        }
                        word[j] = original;
                    }

                }
            }

            level++;
        }

        return 0;
    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();

        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return ans;

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        set.remove(endWord);

        int level = 0;

        ans.add(new ArrayList<>());

        while (!q.isEmpty()) {
            int size = q.size();


            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                ans.get(0).add(curr);

                if (endWord.equals(curr)) {
                    ans.get(0).add(endWord);
                    return ans;
                };

                char[] word = curr.toCharArray();

                for (int j = 0; j < word.length; j++) {
                    char old = word[j];

                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        word[j] = ch;

                        String w = new String(word);

                        if (set.contains(w)) {
                            q.offer(w);
                            set.remove(w);
                        }

                        word[j] = old;
                    }
                }
            }

            level++;
        }

        return ans;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        System.out.println(findLadders(beginWord, endWord, wordList));
    }
}
