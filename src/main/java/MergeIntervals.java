package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {// 56. Merge Intervals
    // https://leetcode.com/problems/merge-intervals/
    class Solution {

        // nlogn with sort
        public int[][] merge(int[][] intervals) {
            if (intervals == null || intervals.length == 0) {
                return new int[0][];
            }
            Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
            List<int[]> result = new ArrayList<>();
            int[] first = intervals[0];
            result.add(first);
            for (int i = 1; i< intervals.length; i++) {
                if (result.get(result.size()-1)[1] >= intervals[i][0]) {
                    // replace end of last result element to max of the two ends
                    result.get(result.size()-1)[1] = Math.max(result.get(result.size()-1)[1], intervals[i][1]);
                } else {
                    // just add normally since no overlap
                    result.add(intervals[i]);
                }
            }
            return result.toArray(new int[result.size()][]);
        }


        // time = n*logn
        // space = n
        // this approach is wayyy too much code
        // new TreeMap
        // Algorithm
        // for each tuple
        //      get floor and ceil of both ends
        //      for each floor and ceil pair, merge if needed
//     public int[][] merge(int[][] intervals) {
//         if (intervals == null || intervals.length == 0) {
//             return new int[0][0];
//         }

//         TreeMap<Integer, Integer> map = new TreeMap<>();
//         for (int[] pair: intervals) {
//             pair = mergeIfNeeded(map, pair);
//             pair = mergeIfNeeded(map, pair);
//             map.put(pair[0], pair[1]);
//         }

//         int result[][] = new int[map.size()][2];
//         int i = 0;
//         for (Map.Entry<Integer, Integer> e : map.entrySet()) {
//             result[i][0] = e.getKey();
//             result[i++][1] = e.getValue();
//         }
//         return result;
//     }

//     private int[] mergeIfNeeded(TreeMap<Integer, Integer> map, int[] pair) {
//         int first = pair[0];
//         int second = pair[1];
//         Map.Entry<Integer, Integer> entry = map.floorEntry(first);
//         if (entry != null) {
//             if (entry.getValue() >= pair[0]) {
//                 map.remove(entry.getKey());
//                 pair[0] = Math.min(entry.getKey(), pair[0]);
//                 pair[1] = Math.max(entry.getValue(), pair[1]);
//             }
//         }
//         entry = map.ceilingEntry(first);
//         if (entry != null) {
//             if (entry.getKey() <= pair[1]) {
//                 map.remove(entry.getKey());
//                 pair[0] = Math.min(entry.getKey(), pair[0]);
//                 pair[1] = Math.max(entry.getValue(), pair[1]);
//             }
//         }
//         entry = map.floorEntry(second);
//         if (entry != null) {
//             if (pair[0] <= entry.getValue()) {
//                 map.remove(entry.getKey());
//                 pair[0] = pair[0] = Math.min(entry.getKey(), pair[0]);
//                 pair[1] = Math.max(entry.getValue(), pair[1]);
//             }
//         }
//         entry = map.ceilingEntry(second);
//         if (entry != null) {
//             if (pair[1] >= entry.getKey()) {
//                 map.remove(entry.getKey());
//                 pair[0] = pair[0] = Math.min(entry.getKey(), pair[0]);
//                 pair[1] = Math.max(entry.getValue(), pair[1]);
//             }
//         }
//         return pair;
//     }
    }

}
