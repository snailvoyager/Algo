package coding;

public class OY250324 {
    public static void main(String[] args) {
        System.out.println(compressWord("abbcccb", 3));
        System.out.println(compressWord("aba", 2));
        System.out.println(compressWord("baac", 2));
    }

    public static String compressWord(String word, int k) {
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            for (int j = 0; j < k && i+j < word.length(); j++) {
                if (c != word.charAt(i+j)) {
                    break;
                }
                if (j == k-1) {
                    return compressWord(word.replace(String.valueOf(c).repeat(k), ""), k);
                }
            }
        }
        return word;
    }
}
