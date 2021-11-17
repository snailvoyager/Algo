package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();

        nextParenthes("()", answer, 1, 1, n);

        if (n == 1) {
            answer.add("()");
        }
        if (n > 1) {
            nextParenthes("((", answer, 2, 0, n);
        }

        return answer;
    }

    public void nextParenthes(String prev, List<String> answer, int open, int close, int n) {
        if (open > close) {
            if (close + 1 == n) {
                answer.add(prev + ")");
                return;
            }
            nextParenthes(prev + ")", answer, open, close+1, n);
        }

        if (open < n) {
            nextParenthes(prev + "(", answer, open+1, close, n);
        }
    }
}
