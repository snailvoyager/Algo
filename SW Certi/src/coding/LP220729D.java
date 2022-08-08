package coding;

public class LP220729D {
    public static void main(String[] args) {
        System.out.println(solution(".xxx...x", "..x.xxxx"));
        System.out.println(solution("..xx.x.", "x.x.x.."));
    }
    public static int solution(String L1, String L2) {
        int result = 0;
        int maxL1 = 0;
        int maxL2 = 0;
        int[] sumL1 = new int[L1.length()];     //memo
        int[] sumL2 = new int[L2.length()];

        for (int i=0; i<L1.length(); i++) {     //1차선 주행
            if (L1.charAt(i) == 'x') {
                maxL1++;
            }
            sumL1[i] = maxL1;
            if (L2.charAt(i) == 'x') {
                maxL2++;
            }
            sumL2[i] = maxL2;
        }

        result = Math.max(maxL1, maxL2);
        maxL1 = 0;

        for (int i=1; i<L1.length()-1; i++) {   //2차선 주행
            maxL2 = 0;
            if (L1.charAt(i-1) == 'x') {
                maxL1++;
            }
            if (L1.charAt(i) == 'x' && L2.charAt(i) == 'x') {
                continue;
            }
            /*for (int j=i+1; j<L1.length(); j++) {
                if (L2.charAt(j) == 'x')
                    maxL2++;
            }*/
            maxL2 = sumL2[L2.length()-1] - sumL2[i];
            result = Math.max(result, maxL1+maxL2);
        }

        maxL2 = 0;
        for (int i=1; i<L2.length()-1; i++) {
            maxL1 = 0;
            if (L2.charAt(i-1) == 'x'){
                maxL2++;
            }
            if (L2.charAt(i) == 'x' && L1.charAt(i) == 'x') {
                continue;
            }

            /*for (int j=i+1; j<L1.length(); j++) {
                if (L1.charAt(j) == 'x')
                    maxL1++;
            }*/
            maxL1 = sumL1[L1.length()-1] - sumL1[i];
            result = Math.max(result, maxL1+maxL2);
        }
        return result;
    }
}
