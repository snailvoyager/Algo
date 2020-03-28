package LeetCode.Easy;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("(())"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(["));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
     
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(')      //열면 스택에 저장
                stack.push(')');
            if(s.charAt(i) == '{')
                stack.push('}');
            if(s.charAt(i) == '[')
                stack.push(']');
            
            if(s.charAt(i) == ')'){     //닫으면 스택에서 꺼내
                if(stack.isEmpty()) return false;   //스택이 비어있으면 false
                int c = stack.pop();
                if(c != ')')
                    return false;
            }

            if(s.charAt(i) == '}'){
                if(stack.isEmpty()) return false;
                int c = stack.pop();
                if(c != '}')
                    return false;
            }

            if(s.charAt(i) == ']'){
                if(stack.isEmpty()) return false;
                int c = stack.pop();
                if(c != ']')
                    return false;
            }
        }
        if(stack.isEmpty())
            return true;
        return false;
    }
}
