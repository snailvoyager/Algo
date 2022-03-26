package LeetCode.Easy;

import java.util.HashMap;

public class RansomNote {
    public static void main(String[] args) {

    }

    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0; i<ransomNote.length(); i++) {
            char rc = ransomNote.charAt(i);
            if (map.containsKey(rc)) {
                int cnt = map.get(rc);
                map.put(rc, cnt+1);
            } else {
                map.put(rc, 1);
            }
        }
        for (int i=0; i<magazine.length(); i++) {
            char mc = magazine.charAt(i);
            if (map.containsKey(mc)) {
                int cnt = map.get(mc);
                if (cnt > 1) {
                    map.put(mc, cnt-1);
                } else {
                    map.remove(mc);
                }
            }
        }
        return map.size() <= 0;
    }
}
