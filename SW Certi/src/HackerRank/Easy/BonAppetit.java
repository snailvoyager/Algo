package HackerRank.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BonAppetit {

	static void bonAppetit(List<Integer> bill, int k, int b) {
        bill.remove(k);         //Anna가 먹지않은 음식 값 삭제
        int sum = 0;
        for(int i : bill)
            sum += i;           //먹은 음식 값 합산

        sum /= 2;               //둘이서 엔빵

        if(b > sum)
            System.out.println(b - sum);
        if(b == sum)
            System.out.println("Bon Appetit");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] nk = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String[] billItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> bill = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int billItem = Integer.parseInt(billItems[i]);
            bill.add(billItem);
        }

        int b = Integer.parseInt(bufferedReader.readLine().trim());

        bonAppetit(bill, k, b);

        bufferedReader.close();
    }

}
