package javalang.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SkylineProblem {
    class Solution {

        // this approach builds all critical paths into a sorted list and then procceds to see each building and the
        // critical points it covers
        // there is a faster divide and conquer approach to this problem as well
        // NlogN time
        public List<List<Integer>> getSkyline(int[][] buildings) {
            List<List<Integer>> result = new ArrayList<>();
            if (buildings == null || buildings.length == 0) {
                return result;
            }

            // set of all critical poitns
            // O(N) time O(N) space
            Set<Integer> scp = new HashSet<>(buildings.length);
            for (int[] b : buildings) {
                scp.add(b[0]);
                scp.add(b[1]);
            }

            // all critical points
            Integer[] cp = scp.toArray(new Integer[0]);
            Arrays.sort(cp);
            int[] height = new int[scp.size()];

            // O(NLogN) time
            // update each critical point with buildign information
            for (int[] b : buildings) {

                // find first critical point within building boundary, if not found (it will be found in this case btw), it will resutrn insertion index
                int index = Arrays.binarySearch(cp, 0, cp.length - 1, b[0]);

                // index has to be there since I created the index list above containing all indexes from input! so no point checing negative
                // if (index < 0) {
                //     index = ~index;
                // }

                // while the next critical points are within boundary of this building
                while (index < cp.length && cp[index] < b[1]) {
                    height[index] = Math.max(height[index], b[2]);
                    index++;
                }
            }

            result.add(innerList(cp[0], height[0]));
            for (int i = 1; i < cp.length; i++) {
                if (height[i] != height[i - 1]) {
                    result.add(innerList(cp[i], height[i]));
                }
            }
            return result;
        }


        // APPROACH 2: we get a list of critical points and then sort it. We iterate over the osrted criticalpoints while maintaining a maxheap for the height at any point in time
        //         public List<List<Integer>> getSkyline(int[][] buildings) {
//             List<List<Integer>> result = new ArrayList<>();

//             if (buildings == null || buildings.length == 0) {
//                 return result;
//             }

//             List<int[]> criticalPoints = new ArrayList<>();
//             for (int[] b : buildings) {
//                 // starting edge of building
//                 criticalPoints.add(new int[]{b[0], b[2]});
//                 // ending edge of vuildinb
//                 criticalPoints.add(new int[]{b[1], -b[2]});
//             }


//             // if first index is same, then we need the second index to be decreasing. This will allow us to always add a new value before taking out values for the same index repeated multiple times
//             // otherwise we will ge incorrect result
//             Collections.sort(criticalPoints, (a,b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

//             PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

//             pq.add(0);
//             int prevHeight = 0;

//             for (int i = 0; i < criticalPoints.size(); i++) {

//                 int[] cp = criticalPoints.get(i);
//                 int currIndex = cp[0];
//                 int currHeight = cp[1];
//                 if (currHeight > 0) {
//                     // add
//                     pq.add(currHeight);
//                 } else {
//                     pq.remove(-currHeight);
//                 }

//                 if (pq.peek() != prevHeight) {
//                     result.add(innerList(currIndex, pq.peek()));
//                     prevHeight = pq.peek();
//                 }
//             }

//             return result;
//         }


        // approach 3:
        // build a skyline using [min,max] positions, and htnen fill out max heights
        // space = K where K is right - left
        // time = N^2 probably
        // THIS TIMES OUT
        //     public List<List<Integer>> getSkyline(int[][] buildings) {
//         List<List<Integer>> result = new ArrayList<>();
//         if (buildings == null || buildings.length == 0) {
//             return result;
//         }

//         int left = buildings[0][0];
//         int right = buildings[buildings.length-1][1];

//         int n = right - left + 1;
//         int[] skyline = new int[n];

//         for (int[] building: buildings) {
//             int currLeft = building[0] - left;
//             int currRight = building[1] - left;
//             int currH = building[2];

//             for (int i = currLeft; i < currRight; i++) {
//                 skyline[i] = Math.max(skyline[i], building[2]);
//             }
//         }


//         result.add(innerList(left ,skyline[0]));

//         for (int i = 1 ; i < skyline.length; i++) {
//             if (skyline[i-1] != skyline[i]) {
//                 result.add(innerList(left + i, skyline[i]));
//             }
//         }
//         return result;
//     }

        private List<Integer> innerList(int point, int h) {
            List<Integer> l = new ArrayList<>();
            l.add(point);
            l.add(h);
            return l;
        }
    }

}
