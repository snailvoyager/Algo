package LeetCode.Easy;

import java.util.HashMap;

public class FindTheDifference {
    public static void main(String[] args) {
        char c = 0;
        char a = 'a';
        c ^= a;
        c ^= 'b';
        c ^= 'c';
        c ^= 'c';
        c ^= 'a';
        c ^= 'x';
        c ^= 'b';
        System.out.println(c);
        System.out.println(9 >> 2);

        System.out.println(findTheDifference("abcd", "abcde"));
        System.out.println(findTheDifference2("abcd", "abcde"));
    }

    public static char findTheDifference2(String s, String t) {
        char result = 0;
        for (int i =0; i<t.length(); i++) {
            result ^= t.charAt(i);
        }
        for (int i =0; i<s.length(); i++) {
            result ^= s.charAt(i);
        }
        return result;
    }

    public static char findTheDifference(String s, String t) {
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        if (s.length() == 0) {
            return t.charAt(0);
        }

        char result = '\0';

        for (int i=0; i<s.length(); i++) {
            if (sMap.containsKey(s.charAt(i))) {
                int cnt = sMap.get(s.charAt(i)) + 1;
                sMap.put(s.charAt(i), cnt);
            } else {
                sMap.put(s.charAt(i), 1);
            }
        }

        for (int i=0; i<t.length(); i++) {
            if (tMap.containsKey(t.charAt(i))) {
                int cnt = tMap.get(t.charAt(i)) + 1;
                tMap.put(t.charAt(i), cnt);
            } else {
                tMap.put(t.charAt(i), 1);
            }
        }

        for (int i=0; i<t.length(); i++) {
            int tCnt = tMap.get(t.charAt(i));
            int sCnt = 0;
            if (sMap.containsKey(t.charAt(i))) {
                sCnt = sMap.get(t.charAt(i));
            } else {
                result = t.charAt(i);
                break;
            }

            if (tCnt != sCnt) {
                result = t.charAt(i);
                break;
            }
        }

        return result;
    }
}
