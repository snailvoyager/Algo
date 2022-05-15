package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public static void main(String[] args) {
        System.out.println(letterCasePermutation("a1b2"));
    }

    public static List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();

        outer :
        for (int i=0; i<(1<<s.length()); i++) {
            StringBuilder str = new StringBuilder();

            for (int j=0; j<s.length(); j++) {
                char c = s.charAt(j);

                if ((i & (1<<j)) != 0) {  //UpperrCase

                    if (c>=48 && c<=57) {   //number
                        continue outer;
                    } else if (c>=65 && c<=90) {    //Upper
                        c +=  32;
                    } else {    //Lower
                        c -= 32;
                    }
                }
                str.append(c);
            }
            result.add(str.toString());
        }

        return result;
    }
}
