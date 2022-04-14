package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationIterator {
    List<String> combiList;
    boolean[] Visited;
    int idx = 0;

    public CombinationIterator(String characters, int combinationLength) {
        combiList = new ArrayList<>();
        Visited = new boolean[characters.length()];

        combi(characters, characters.length(), combinationLength, 0);
    }

    public void combi(String characters, int n, int r, int start) {
        if (r == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<n; i++) {
                if (Visited[i]) {
                    sb.append(characters.charAt(i));
                }

            }
            combiList.add(sb.toString());
            return;
        }

        for (int i=start; i<n; i++) {
            Visited[i] = true;
            combi(characters, n, r-1, i+1);
            Visited[i] = false;
        }
    }

    public String next() {
        return combiList.get(idx++);
    }

    public boolean hasNext() {
        return combiList.size() > idx;
    }
}
