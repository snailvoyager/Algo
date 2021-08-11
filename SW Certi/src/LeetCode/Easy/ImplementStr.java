package LeetCode.Easy;

public class ImplementStr {
    class Solution {
        public int strStr(String haystack, String needle) {
            int result = -1;
            if (needle.length() == 0) {
                return 0;
            }
            if (needle.length() > haystack.length()) {
                return -1;
            }

            for(int i=0; i<haystack.length(); i++) {
                int first = i;
                int haystackIdx = i;
                int needleIndx = 0;

                if (i + needle.length() > haystack.length()) {
                    break;
                }

                while (haystack.charAt(haystackIdx) == needle.charAt(needleIndx)) {
                    needleIndx++;
                    if (needle.length() == needleIndx) {
                        return first;
                    }
                    haystackIdx++;
                }
            }
            return result;
        }
    }
}
