package LeetCode.Easy;

import java.util.Stack;

public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(Character.isLetterOrDigit('*'));
        System.out.println("ASD@$#%><}{098FVX".toLowerCase().replaceAll("\\W+", ""));
        System.out.println(new StringBuilder("dsfosaf").reverse().toString());
    }
}

class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder converting = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 65 && c <= 90) {
                c += 32;
                converting.append(c);
                stack.push(c);
            } else if (c >= 97 && c <= 122) {
                converting.append(c);
                stack.push(c);
            } else if (c >= 48 && c<= 57) {
                converting.append(c);
                stack.push(c);
            }
        }

        if (converting.length() == 0)
            return true;

        StringBuilder backward = new StringBuilder();

        while (!stack.isEmpty()) {
            backward.append(stack.pop());
        }

        return converting.toString().equals(backward.toString());
    }
}
