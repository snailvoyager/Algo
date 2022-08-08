package coding;

/*
2) 인코딩된 문자열이 있으면 디코딩된 문자열을 반환하십시오.
Examples:
    s = "3[a]2[bc]", return "aaabcbc".

    s = "3[a2[c]]", return "accaccacc".
    s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
*/

import java.util.Stack;

public class CP211119B {

    public static void main(String[] args) {
    }

    public static String decode(String input) {
        Stack<Character> stack = new Stack<>();
        String answer = "";

        for (int i=0; i<input.length(); i++) {
            if (input.charAt(i) != ']') {
                stack.push(input.charAt(i));
            } else {
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty()) {
                    if (stack.peek() != '[') {
                        sb.append(stack.pop());
                    }
                }
            }
        }
        return answer;
    }
}