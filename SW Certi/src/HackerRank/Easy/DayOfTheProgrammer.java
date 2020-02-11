package HackerRank.Easy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DayOfTheProgrammer {

	static String dayOfProgrammer(int year) {
        if(year == 1918)
            return "26.09." + year;
        if(year < 1918){
            if(year % 4 == 0)
                return "12.09." + year;
            else
                return "13.09." + year;
        } else{
            if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
                return "12.09." + year;
            else
                return "13.09." + year;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

}
