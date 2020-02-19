package HackerRank.Easy;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class MakingAnagrams {

	static int makingAnagrams(String s1, String s2) {
        StringBuilder sb2 = new StringBuilder(s2);
        int n1 = 0;

        for(int i=0; i<s1.length(); i++){
            char c = s1.charAt(i);
            int idx = sb2.toString().indexOf(c);    //s2�� �����ϴ���
            if(idx > -1){
                n1++;								//s1�� ��ġ�� ���� ��
                sb2.deleteCharAt(idx);             //s2�� ��ġ�� ���� ����
            }
        }

        return (s1.length() - n1) + sb2.length();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = makingAnagrams(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
