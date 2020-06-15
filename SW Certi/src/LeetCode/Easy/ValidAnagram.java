package LeetCode.Easy;

public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];
        
        for(int i=0; i<s.length(); i++){
            int c = s.charAt(i) - 'a';
            alphabet[c]++;
        }
        
        for(int i=0; i<t.length(); i++){
            int c = t.charAt(i) - 'a';
            if(alphabet[c] == 0)
                return false;
            alphabet[c]--;
        }
        
        for(int i=0; i<26; i++){
            if(alphabet[i] != 0)
                return false;
        }
        return true;
    }
}
