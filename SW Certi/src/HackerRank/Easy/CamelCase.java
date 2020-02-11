package HackerRank.Easy;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class CamelCase {

	static int camelcase(String s) {
		
		/*
		 * int result = 1;
		 * 
		 * for(int i=0; i<s.length(); i++){ if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
		 * result++; } return result;
		 */ 
		
		  String[] arr = s.split("[A-Z]"); return arr.length;
		 
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = scanner.nextLine();

        int result = camelcase(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}

/*
hcjeXdPqsohqwqdxscoloeaflzUhauyfgbrhqxqeBxvfxbraxfcewAhnzNoqnztYpctziqtYriylrogkjerwgskymNinonzeguhjlTbvmgbbnjoyQqygjOuyumgBdnehqkpXiqkeHbejexluujuyzwzlnfcCeuxeljuwpurcytlyjxHiuzEdywzhjexyFtTpllvpyLoskwcarzhkRdhqtavugyyllwcaumbsyaYfqyxPgzfbcrDjsUhlzzovgdOcipohrlwjdxlcrdcgyoNagdlrwmnynvnqknqTpuiyhutrexuamztmvTzmOycuudtedyjntdwtzmqfbiCdzrYtxajrpihywfjkqzrqsdMhpobqdboRyhzjapboxesnbrbrcbmsQjmjhyfwiiehbdacbcpejBcJnrormhefXdhmukrTlygrqgYcvjsohysoUoblpfnaubrlRkMsyxCsftwoDijmaekkusyjkKcwbqoarabtsymypaylekdewqtdhpettiBgDeyhpabnytkhxospoewOqbcngzdkkiqfhuslxUpxlwjwfffOeplextrbftgheddexlqlgMimjrqdqjeipceyadfzuGujdyorpnlqucvboyapytgxnukfiafisecgwysbppOxltdgqhIfuhmlpyvlibfcrywjwqzdlitnzHqCmgtJeumapzrddohYhlmymjoiwiuscwarCvpiipUbrafcFxugrgjrybkmcjfRgIyOmzqzdgngWnabszugaslSlbWjkmwtfVavhsxjhvgsbihkafdAwcndpjhdWsgsbghhyieJvhRazhpbmscqrlghfTgggbucmfXawuLmicisdzPhbxtvdmUbwdjuNvfAminJbpheygOzctourxKyuotagxmgptukkvlnekaBwznstjkpkIznxepshstjivgSahraBxduwbNedpeJvdjtuzkwbqjmunzlcVeryxxirujarydibhvmjbttjtycxvpyrtqqbvVyuYvigaskszhgnvfp{-truncated-}

 */
