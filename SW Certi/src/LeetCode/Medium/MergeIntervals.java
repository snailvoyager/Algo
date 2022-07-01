package LeetCode.Medium;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] arr = {{1,4}, {0,2}, {3,5}};
        //System.out.println(Arrays.toString(merge(arr)));
        System.out.println(Arrays.toString(merge2(arr)));
    }
    public static int[][] merge(int[][] intervals) {

        int idx = 0;

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        for (int i=0; i<intervals.length; i++) {
            for (int j=i+1; j<intervals.length; j++) {
                if (intervals[i][0] <= intervals[j][0] && intervals[j][0] <= intervals[i][1]
                        || intervals[i][0] <= intervals[j][1] && intervals[j][1] <= intervals[i][1]
                        || intervals[j][0] <= intervals[i][0] && intervals[i][0] <= intervals[j][1]
                        || intervals[j][0] <= intervals[i][1] && intervals[i][1] <= intervals[j][1]) {

                    int start = Math.min(intervals[i][0], intervals[j][0]);
                    int end = Math.max(intervals[i][1], intervals[j][1]);

                    intervals[i][0] = -1;
                    intervals[j][0] = start;
                    intervals[j][1] = end;
                    System.out.println(Arrays.toString(intervals[j]));
                    break;
                }
            }
        }
        for (int[] interval : intervals) {
            //System.out.println(Arrays.toString(interval));
            if (interval[0] != -1) {
                idx++;
            }
        }
        System.out.println(idx);

        int[][] result = new int[idx][2];
        idx = 0;
        for (int i=0; i<intervals.length; i++) {
            if (intervals[i][0] != -1) {
                result[idx][0] = intervals[i][0];
                result[idx][1] = intervals[i][1];
                idx++;
            }
        }
        return result;
    }

    public static int[][] merge2(int[][] intervals) {
        List<int[]> result = new ArrayList<>();

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        for (int i=1; i<intervals.length; i++) {
            if (intervals[i-1][1] >= intervals[i][0]) {
                intervals[i][0] = intervals[i-1][0];
                intervals[i][1] = Math.max(intervals[i-1][1], intervals[i][1]);

                intervals[i-1][0] = -1;
                intervals[i-1][1] = -1;
            }
        }

        for (int[] node : intervals) {
            if (node[0] > -1) {
                result.add(node);
                System.out.println(Arrays.toString(node));
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
