package hacker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {
    //https://leetcode.com/problems/insert-interval/
    public static int[][] mergeInterval(int[][] intervals, int[] newInterval){
        List<int[]> resultList = new ArrayList<>();

        for(int[] interval : intervals) {
            if(newInterval[0] > interval[1]) {
                resultList.add(interval);
            }
            else if(newInterval[1] < interval[0]) {
                resultList.add(newInterval);
                newInterval = interval;
            }
            else {
                int[] merged = new int[] {Math.min(newInterval[0], interval[0]), Math.max(newInterval[1], interval[1])};
                newInterval = merged;
            }
        }
        resultList.add(newInterval);

        return resultList.toArray(new int[resultList.size()][2]);
    }

    public static void main(String[] args) {
        int[][] intervals  = new int[][]{{1,3},{6,9}, {10,13}};
        int[] newInterval = new int[]{4,5};
        for(int[] ar: mergeInterval(intervals,newInterval))
            System.out.println(Arrays.toString(ar));
    }
}
