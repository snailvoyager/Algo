package Professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_��ȣ����_LCS {
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
Ž����ȸ�� �̸����� ������ ��ȣȭ�� ������ ���ƿ´ٰ� �մϴ�. Ž�� A���� Ž������ ��¥�� �� ����� ���� �ʾ� ���� ������ ���´��� ������ ���� ������ �Խ��ϴ�. ���忡�� "today", "tomorow" �� �Ѱ��� ����� ������ ������ �ٲ��� ���� ä�� ����� ��� �ִٰ� �մϴ�. ���忡 ����ִ� �ܾ ����غ�����. �� �ܾ� ��� ���� ��� "none"�� ����մϴ�.  
�Է�
�׽�Ʈ ���̽� ������ �� �ٿ� �� ������ �ϳ��� �־����ϴ�. ������ ���̴� 1000���ڸ� ���� �ʽ��ϴ�.
���
#�׽�Ʈ���̽� ��ȣ�� today, tomorrow, none ���� �ϳ��� ����մϴ�.

3
tsodvaky
asdgtasdjoadj
asjdkgtjoasdgmasjokrrimowvdis

#1 today
#2 none
#3 tomorrow
*/