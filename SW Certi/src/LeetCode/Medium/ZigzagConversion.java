package LeetCode.Medium;

public class ZigzagConversion {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("PAYPALISHIRING", 4));
        System.out.println(convert("AB", 1));
    }

    public static String convert(String s, int numRows) {
        StringBuilder[] arr = new StringBuilder[numRows];
        for (int i=0; i<numRows; i++) {
            arr[i] = new StringBuilder();
        }

        int idx =0;
        int direct = 1;
        for (int i=0; i<s.length(); i++) {
            arr[idx].append(s.charAt(i));

            if (idx == 0) {
                direct = 1;
            } else if (idx == numRows -1){
                direct = -1;
            }
            if (numRows != 1) {
                idx += direct;
            }
        }
        StringBuilder answer = new StringBuilder();
        for (StringBuilder sb : arr) {
            answer.append(sb);
        }

        return answer.toString();
    }
}
