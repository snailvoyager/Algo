package programmers;

import java.util.Arrays;

public class StringCompact {

    public static void main(String[] args) {
        //String str = "aabbaccc";
        String str = "abcabcabcabcdededededede";
        System.out.println(solution(str));
    }

    public static int solution(String s) {
        int answer = s.length();
        int n = s.length() / 2;

        for(int i=1; i<=n; i++) {
            StringBuilder sub = new StringBuilder();
            String[] arrStr = new String[(s.length()/i) + 1];

            int k = i;
            int m = 0;
            for(int j=0; j<=(s.length()/i); j++) {
                if(j == (s.length()/i)) {
                    arrStr[j] = s.substring(m);
                    break;
                }
                arrStr[j] = s.substring(m, k);
                k += i;
                m += i;
            }
            System.out.println(Arrays.toString(arrStr));

            for (int o=0; o<arrStr.length; o++) {
                int cnt = 1;
                if (o < arrStr.length -1) {
                    for (int p = o + 1; p < arrStr.length; p++) {
                        if (arrStr[o].equals(arrStr[p])) {
                            cnt++;
                            o = p;
                        } else {
                            if (cnt != 1) {
                                sub.append(cnt);
                                sub.append(arrStr[o]);
                            }
                            else
                                sub.append(arrStr[o]);
                            break;
                        }
                    }
                } else {
                    sub.append(arrStr[o]);
                }
            }

            System.out.println(sub.toString());

            if (answer > sub.length()) {
                answer = sub.length();
            }
        }
        return answer;
    }
}
