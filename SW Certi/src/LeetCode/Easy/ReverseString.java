package LeetCode.Easy;

public class ReverseString {
	public void reverseString(char[] s) {
        for(int i=0; i<(s.length / 2); i++){
            char c = s[i];
            int ban = (s.length-1) - i;
            s[i] = s[ban];
            s[ban] = c;
            
        }
    }
}
