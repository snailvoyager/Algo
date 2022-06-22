package LeetCode.Medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", Arrays.asList("leet","code")));
        System.out.println(wordBreak("applepenapple", Arrays.asList("apple","pen")));
        System.out.println(wordBreak("catsandog", Arrays.asList("cats","dog","sand","and","cat")));
        System.out.println(wordBreak("aaaaaaa", Arrays.asList("aaaa","aaa")));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] isWord = new boolean[s.length() + 1];
        isWord[0] = true;

        for (int i=1; i<=s.length(); i++) {
            for (int j=0; j<i; j++) {
                if (isWord[j] && set.contains(s.substring(j, i))) {
                    isWord[i] = true;
                    break;
                }
            }
        }
        return isWord[s.length()];
    }
}
