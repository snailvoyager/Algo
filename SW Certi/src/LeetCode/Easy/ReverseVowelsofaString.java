package LeetCode.Easy;

import java.util.Arrays;
import java.util.HashSet;

public class ReverseVowelsofaString {
    public String reverseVowels(String s) {
        int f = 0;
        int r = s.length()-1;
        StringBuilder result = new StringBuilder(s);
        String vowels = "aeiouAEIOU";

        while (f < r) {
            char fVowel = result.charAt(f);
            char rVowel = result.charAt(r);

            if (isVowels(vowels, fVowel) && isVowels(vowels, rVowel)) {
                //switch
                result.setCharAt(f, rVowel);
                result.setCharAt(r, fVowel);
                r--;
                f++;
            } else if (isVowels(vowels, fVowel)) {
                r--;
            } else if (isVowels(vowels, rVowel)) {
                f++;
            } else {
                r--;
                f++;
            }
        }

        return result.toString();
    }

    public boolean isVowels(String vowels, char c) {
        for (int i=0; i<vowels.length(); i++) {
            if (vowels.charAt(i) == c) {
                return true;
            }
        }
        return false;
    }

    public String reverseVowelsNew (String s) {
        int left = 0, right = s.length() - 1;
        HashSet<Character> set = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        char[] arr = s.toCharArray();

        while (left < right) {
            if (!set.contains(arr[left])) {
                left++;
            } else if (!set.contains(arr[right])) {
                right--;
            } else {    //switch
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;
            }
        }
        return new String(arr);
    }
}
