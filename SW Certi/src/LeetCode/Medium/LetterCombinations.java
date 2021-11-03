package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
    static char[][] alpha = new char[10][4];

    public static void main(String[] args) {
        System.out.println(solution("2345"));
    }

    public static List<String> solution(String digits) {
        List<String> answer = new ArrayList<>();

        alpha[2][0] = 'a';
        alpha[2][1] = 'b';
        alpha[2][2] = 'c';
        alpha[3][0] = 'd';
        alpha[3][1] = 'e';
        alpha[3][2] = 'f';
        alpha[4][0] = 'g';
        alpha[4][1] = 'h';
        alpha[4][2] = 'i';
        alpha[5][0] = 'j';
        alpha[5][1] = 'k';
        alpha[5][2] = 'l';
        alpha[6][0] = 'm';
        alpha[6][1] = 'n';
        alpha[6][2] = 'o';
        alpha[7][0] = 'p';
        alpha[7][1] = 'q';
        alpha[7][2] = 'r';
        alpha[7][3] = 's';
        alpha[8][0] = 't';
        alpha[8][1] = 'u';
        alpha[8][2] = 'v';
        alpha[9][0] = 'w';
        alpha[9][1] = 'x';
        alpha[9][2] = 'y';
        alpha[9][3] = 'z';

        if (digits.length() < 1) {
            return answer;
        }
        int n = Integer.parseInt(digits.substring(0, 1));
        for (int i=0; i<alpha[n].length; i++) {
            if (alpha[n][i] == 0) {
                break;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(alpha[n][i]);
            bfs(answer, sb, 1, digits);
        }

        return answer;
    }

    public static void bfs(List<String> answer, StringBuilder sb, int depth, String digit) {
        if (depth == digit.length()) {
            answer.add(sb.toString());
            return;
        }
        int n = Integer.parseInt(digit.substring(depth, depth+1));

        for (int i=0; i<alpha[n].length; i++) {
            if (alpha[n][i] == 0) {
                break;
            }
            sb.append(alpha[n][i]);
            bfs(answer, sb, depth +1, digit);
            sb.deleteCharAt(depth);
        }
    }
}
