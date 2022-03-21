package LeetCode.Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class WordPattern {
    public static void main(String[] args) {
        String[] strArray = "dog cat cat dog".split(" ");
        System.out.println(Arrays.toString(strArray));
    }

    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();

        String[] sArray = s.split(" ");

        if (pattern.length() != sArray.length) {
            return false;
        }

        for (int i=0; i<pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = sArray[i];

            if (map.containsKey(c)) {
                if (map.get(c).equals(word)) {

                } else {
                    return false;
                }
            } else {
                if (map.containsValue(word)) {
                    return false;
                } else {
                    map.put(c, word);
                }
            }
        }
        return true;
    }
}
