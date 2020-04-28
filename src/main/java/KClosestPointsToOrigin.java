package main.java;

import java.util.Arrays;
import java.util.PriorityQueue;

// TODO quick sort  or quick select solution
// See https://en.wikipedia.org/wiki/Quickselect
// #973. K Closest Points to Origin

public class KClosestPointsToOrigin {

    class Solution {

        // bucket sort
        // since we know that max number is 10k, we can bucket sort
        // max distance = (10000*10000*2)^0.5 = 14150
        public int[][] kClosest(int[][] points, int K) {

            PriorityQueue<int[]>[] buckets = new PriorityQueue[14150];

            for (int i = 0 ; i<points.length; i++) {
                int distance = (int)Math.ceil(Math.sqrt(points[i][0] * points[i][0] +
                                                                points[i][1] * points[i][1]));
                if (buckets[distance] == null) {
                    buckets[distance] = new PriorityQueue<int[]>(
                            (a,b) -> {
                                return a[0]*a[0] + a[1]*a[1] - b[0]*b[0] - b[1]*b[1] ;
                            });
                }
                buckets[distance].add(points[i]);
            }

            int[][] result = new int[K][];
            int resultIndex = 0;
            for (int i = 0; i< buckets.length; i++) {
                while (buckets[i] != null && !buckets[i].isEmpty()) {
                    if (resultIndex == result.length) {
                        return result;
                    }
                    result[resultIndex++] = buckets[i].poll();
                }
            }
            return result;
        }
//
//
//         heapify top k elements
//        time: logk
//        space: k
//        public int[][] kClosest_genericSolution(int[][] points, int K) {
//
//            // min heap
//            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
//                return b[0]*b[0] + b[1]*b[1] - a[0]*a[0] - a[1]*a[1];
//            });
//
//            for (int[] point : points) {
//                pq.offer(point);
//                if (pq.size()>K) {
//                    pq.poll();
//                }
//            }
//
//            int[][] result = new int[K][];
//            int resultIndex = 0;
//            while(!pq.isEmpty()) {
//                result[resultIndex++] = pq.poll();
//            }
//            return result;
//        }
//

        // EASIEST to code
//        public int[][] kClosest_suboptimal(int[][] points, int K) {
//            Arrays.parallelSort(points, (a, b) -> {
//                return a[0] * a[0] +  a[1] * a[1]
//                               - b[0] * b[0] - b[1] * b[1];
//            });
//
//            return Arrays.copyOfRange(points, 0, K);
//        }

    }
}
