package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean[] vis = new boolean[wordList.size()];
        int num = 0;

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        while (!q.isEmpty()) {
            String word = q.poll();

            for (int i = 0; i < word.length(); i++) {
                StringBuilder newWord = new StringBuilder(word);
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    newWord.setCharAt(i, ch);
                    if (wordList.contains(newWord.toString())) {
                        System.out.print(newWord + " ");
                        if (newWord.toString().equals(endWord)) {
                            break;
                        }
                        int idx = wordList.indexOf(newWord.toString());
                        if (!vis[idx]) {
                            vis[idx] = true;
                            num++;
                            q.add(newWord.toString());
                        }
                    }
                }
            }
        }

        return num;
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

        System.out.println(ladderLength(beginWord, endWord, wordList));
    }
}
