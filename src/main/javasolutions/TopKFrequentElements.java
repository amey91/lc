package javasolutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// #347. Top K Frequent Elements

public class TopKFrequentElements {
    class Solution {
        // Time = n + n + k = n (create freq map + create bucket arr + fill result)
        // Space = n + n + k = n
        public int[] topKFrequent(int[] nums, int k) {

            // value to count
            // load factor of 0.75, prevent rehashing
            Map<Integer, Integer> map = new HashMap<>( (int) (nums.length / 0.75 + 1));
            for(int i = 0; i < nums.length; i++) {

                // get (default or existing) + 1
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }

            List<Integer>[] buckets = new List[nums.length + 1];

            // map every frequency to the numbers that occured in that frequency
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (buckets[entry.getValue()] == null) {
                    buckets[entry.getValue()] = new ArrayList<>();
                }
                buckets[entry.getValue()].add(entry.getKey());
            }

            int[] result = new int[k];
            int resultIndex = 0;
            for (int listIndex = buckets.length-1; listIndex>=0; listIndex --) {
                if (buckets[listIndex] != null) {
                    for (int listItem: buckets[listIndex]) {

                        // return if array is full
                        if (resultIndex >= result.length) {
                            return result;
                        }

                        result[resultIndex++] = listItem;
                    }
                }
            }
            return result;
        }


//        // Time = n + mlogk ~= nlogk ; where k is Kth top elements and n is size of input and m is number of distinct characters in input
//        // space = m + k = m
//        public int[] topKFrequent_subOptimal(int[] nums, int k) {
//
//            // value to count
//            // load factor of 0.75, prevent rehashing
//            Map<Integer, Integer> map = new HashMap<>((int) (nums.length / 0.75 + 1));
//            for(int i = 0; i < nums.length; i++) {
//
//                // get (default or existing) + 1
//                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
//            }
//
//            // Min heap. Allocate initial capacity to prevent rehashing.
//            PriorityQueue<Map.Entry<Integer, Integer>> pq =
//                    new PriorityQueue<>(
//                            map.size(),
//                            (e1, e2) -> {
//                                return e1.getValue() - e2.getValue();
//                            });
//
//            for (Map.Entry<Integer, Integer> mapEntry: map.entrySet()) {
//                pq.add(mapEntry);
//
//                // keep size below K otherwise solution will ne logn instead of logk !!
//                if (pq.size() > k) {
//                    pq.poll();
//                }
//            }
//
//            List<Integer>[] buckets = new List[nums.length];
//
//            int[] result = new int[k];
//            for (int i = 0; i<k; i++) {
//                result[i]=pq.poll().getKey();
//            }
//            return result;
//        }
    }
}
