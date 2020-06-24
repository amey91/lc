package javasolutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {

    class Solution {

//     https://leetcode.com/problems/top-k-frequent-words/submissions/
//     692. Top K Frequent Words

        public List<String> topKFrequent(String[] words, int k) {

            List<String> list = new ArrayList<>();
            if (words == null || k == 0) {
                return list;
            }


            Map<String, Integer> frequencies = new HashMap<>(words.length);

            for (String s : words) {
                frequencies.put(s, frequencies.getOrDefault(s, 0) + 1);
            }

            // bucket sort
            PriorityQueue<String>[] buckets = new PriorityQueue[words.length + 1];

            for (Map.Entry<String, Integer> entry : frequencies.entrySet()) {
                int bucket = entry.getValue();
                if (buckets[bucket] == null) {
                    // min heap
                    buckets[bucket] = new PriorityQueue<>((a, b) -> a.compareTo(b));
                }
                buckets[bucket].offer(entry.getKey());
            }

            int total = 0;

            List<String> answer = new LinkedList<>();
            for (int i = buckets.length - 1; i >= 0 && total < k; i--) {
                if (buckets[i] == null) {
                    continue;
                }
                while (total < k && !buckets[i].isEmpty()) {
                    total++;
                    answer.add(buckets[i].poll());
                }
            }

            return answer;

        }

//     public List<String> topKFrequent_CountFrequencyUsingPQ(String[] words, int k) {

//         List<String> list = new ArrayList<>();
//         if (words == null || k == 0) {
//             return list;
//         }

//         // TODO is there a PQ that supports different comparators for comparison and ordering?
//         // PriorityQueue<Node> pq = new PriorityQueue<Node>(Comparators.comparing(Node::getVal).xthenComparing(Node::getfrequency))

//         // count freq
//         // insert into heap
//         // return list after popping

//         Map<String, Integer> frequencies = new HashMap<>(words.length/2);

//         for (String s : words) {
//             frequencies.put(s, frequencies.getOrDefault(s, 0) +1);
//         }

// PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<Map.Entry<String, Integer>>(Map.Entry.<String, Integer>comparingByValue().thenComparing(Map.Entry.<String, Integer>comparingByKey().reversed()));

//         for (Map.Entry<String, Integer> entry : frequencies.entrySet()) {
//             pq.offer(entry);
//             if (pq.size() > k) {
//                 pq.poll();
//             }
//         }

//         List<String> answer = new ArrayList<>();

//         while (!pq.isEmpty()) {
//             answer.add(0, pq.poll().getKey());
//         }
//         return answer;

//     }


    }
}
