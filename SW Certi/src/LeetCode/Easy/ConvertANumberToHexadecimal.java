package LeetCode.Easy;

public class ConvertANumberToHexadecimal {
    public String toHex(int num) {
        if (num == 0)
            return "0";

        char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

        StringBuilder result = new StringBuilder();
        while (num != 0) {
            result.insert(0, map[num & 15]);    //16으로 나눈 나머지
            num = (num >>> 4);      //2^4 씩 나누기
        }

        return result.toString();
    }
}
