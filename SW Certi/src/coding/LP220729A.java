package coding;

public class LP220729A {
    public static void main(String[] args) {
        System.out.println(solution("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP"));
        System.out.println(solution("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS"));
        System.out.println(solution("RRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR"));
    }
    public static int solution(String G) {
        int result = 0;
        int P = 0, S = 0, R = 0;

        for (int i=0; i<G.length(); i++) {
            if (G.charAt(i) == 'P') {
                P++;
                S += 2;
            } else if (G.charAt(i) == 'S') {
                S++;
                R += 2;
            } else {
                R++;
                P += 2;
            }
        }
        result = Math.max(Math.max(P, S), R);
        return result;
    }
}
