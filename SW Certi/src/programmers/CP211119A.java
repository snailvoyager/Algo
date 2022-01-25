package programmers;

import java.util.Stack;

    /*
     1) "{[]}<{}>"와 같이 괄호 String을 입력받아 괄호의 정합성을 확인
     Examples:
     s: "([)]",  return: false
     s: "()[]{[]}",  return: true
     */

public class CP211119A {
    public static boolean isTrue(String input) {
        Stack<Character> stack = new Stack<>();// stack.peek(), stack.pop()

        for (int i=0; i<input.length(); i++) {
            if (input.charAt(i) == '{' || input.charAt(i) == '[' || input.charAt(i) == '<') {
                stack.push(input.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character popStr = stack.peek();
                if (popStr == '{') {
                    if (input.charAt(i) != '}') {
                        return false;
                    } else {
                        stack.pop();
                    }
                } else if (popStr == '[') {
                    if (input.charAt(i) != ']') {
                        return false;
                    } else {
                        stack.pop();
                    }
                } else if (popStr == '<') {
                    if (input.charAt(i) != '>') {
                        return false;
                    } else {
                        stack.pop();
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String input = "[]{[]}<{}>";

        System.out.println(isTrue(input));

    }
}
