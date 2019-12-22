package Professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_암호편지_LCS {
	static int T;
    static String Answer;
    static String str = "";
    static String today = "today";
    static String tomorrow = "tomorrow";
    static int length1 = 5;
    static int length2 = 8;
    static int[][] D1, D2;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        T = Integer.parseInt(br.readLine());
        for(int test_case=1; test_case<=T; test_case++) {
            Answer = "";
//          st = new StringTokenizer(br.readLine());
            str = br.readLine();
             
            int N = str.length();
            D1 = new int[length1+1][N+1];
            D2 = new int[length2+1][N+1];
             
            for(int i=1; i<=length1; i++) {
                for(int j=1; j<=N; j++) {
                    if(today.charAt(i-1) == str.charAt(j-1))
                        D1[i][j] = D1[i-1][j-1] + 1;
                    else
                        D1[i][j] = Math.max(D1[i-1][j], D1[i][j-1]);
                }
            }
             
            for(int i=1; i<=length2; i++) {
                for(int j=1; j<=N; j++) {
                    if(tomorrow.charAt(i-1) == str.charAt(j-1))
                        D2[i][j] = D2[i-1][j-1] + 1;
                    else
                        D2[i][j] = Math.max(D2[i-1][j], D2[i][j-1]);
                }
            }
             
            if(D1[length1][N] == length1)
                Answer = today;
            else if(D2[length2][N] == length2)
                Answer = tomorrow;
            else
                Answer = "none";
             
            System.out.println("#"+test_case + " " + Answer);
        }
    }
}
/*
탐정협회에 이메일을 보내면 암호화된 답장이 돌아온다고 합니다. 탐정 A씨는 탐정모임 날짜가 잘 기억이 나지 않아 문의 메일을 보냈더니 다음과 같은 답장이 왔습니다. 답장에는 "today", "tomorow" 중 한가지 대답이 글자의 순서가 바뀌지 않은 채로 흩어져 들어 있다고 합니다. 답장에 들어있는 단어를 출력해보세요. 두 단어 모두 없는 경우 "none"을 출력합니다.  
입력
테스트 케이스 개수와 한 줄에 답 문장이 하나씩 주어집니다. 답장의 길이는 1000글자를 넘지 않습니다.
출력
#테스트케이스 번호와 today, tomorrow, none 중의 하나를 출력합니다.

3
tsodvaky
asdgtasdjoadj
asjdkgtjoasdgmasjokrrimowvdis

#1 today
#2 none
#3 tomorrow
*/