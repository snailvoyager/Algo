package LeetCode.Easy;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        boolean[] isChar = new boolean[s.length()];

        int indexT = 0;

        for (int i=0; i<s.length(); i++) {

            for (int j=indexT; j<t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    isChar[i] = true;
                    indexT = j+1;
                    break;
                }
            }

        }


        for (boolean b : isChar) {
            if (!b) {
                return false;
            }
        }
        return true;
    }
}
