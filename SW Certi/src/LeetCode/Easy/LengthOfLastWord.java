package LeetCode.Easy;

import java.util.Arrays;

public class LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello  world   "));
    }

    public static int lengthOfLastWord(String s) {
        String[] arr = s.split(" ");
        System.out.println(Arrays.toString(arr));

        return arr[arr.length - 1].length();
    }
}
