package main.java;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// #347. Top K Frequent Elements
// Time = n + mlogk where k is Kth top elements and n is size of input and m is number of distinct characters in input
// space = m + k
public class TopKFrequentElements {
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {

            // value to count
            // load factor of 0.75, prevent rehashing
            Map<Integer, Integer> map = new HashMap<>((int) (nums.length / 0.75 + 1));
            for(int i = 0; i < nums.length; i++) {

                // get (default or existing) + 1
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }

            // Min heap. Allocate initial capacity to prevent rehashing.
            PriorityQueue<Map.Entry<Integer, Integer>> pq =
                    new PriorityQueue<>(
                            map.size(),
                            (e1, e2) -> {
                                return e1.getValue() - e2.getValue();
                            });

            for (Map.Entry<Integer, Integer> mapEntry: map.entrySet()) {
                pq.add(mapEntry);

                // keep size below K otherwise solution will ne logn instead of logk !!
                if (pq.size() > k) {
                    pq.poll();
                }
            }

            int[] result = new int[k];
            for (int i = 0; i<k; i++) {
                result[i]=pq.poll().getKey();
            }
            return result;
        }
    }
}
