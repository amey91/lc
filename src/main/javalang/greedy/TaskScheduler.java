package javalang.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TaskScheduler {

    // General approach from scratch:
// 1. first i thought about simply placing things int the order in which they are given leaving empty slots and then greedily filling those empty spots
// 2. however, the drawback of starting with the first character is that the first character may not be the most frequent chracter, in which case the answer is subtoptimal
// 3. in order to get an optimal answer, we actually need to use the most frequent character. Extending that loginc, the most frequent character from set of all left over characters will
//      be the longpoll at anytime. Thus PQ of frequency count and processing items in batches of k works
// 4. Optimal solution is more analytical. We realize that PQ is not needed since we do not need to produce the exact sequence. Just counting chars is enough
// 5. IMPORTANT: Within each partition, if the partitions can hold the maxFreq element without breaking window uniqueness, then we can obviously fit any other element with less frequency than maxFreq
//      without breaking the window constraint e.g. AAABB,n=2 here we have A _ _ A _ _ A. Then we can fit B and any number of other elements with frequency < freq(A) within the partitions

    class Solution {

        // ANALYTICAL APPROACH 2 uses array instead of map and calculates idle slots
        // compared to analytical apporach 1 below, we stop trying to count the empty slots per partition. In this approach, we just count the empty slots in the entire system at once and then proceed to see if
        // those empty slots can be filled. If all empty slots cannot be filled, then we will neeed the balance empty slots to satisfy the window constraint. Else if there are not empty sots, then tasks
        // can be arranges within the input array size without violating constraint. Also read the 5th point above
        // time = N for freqeucnyCounts + 1 for  sorting those counts since fixed size _ 1 for final idle count = N
        // space = 1
        public int leastInterval(char[] tasks, int n) {
            int[] frequencies = new int[26];

            for (char task : tasks) {
                frequencies[task - 'A']++;
            }

            Arrays.sort(frequencies);

            int partitions = frequencies[25] - 1;

            int idles = partitions * n;

            for (int i = 24; i >= 0; i--) {

                // for any frequency that matches maxFrequency, only count (max - 1) instances since there are (max - 1) partitions, so the last occurrence would not occupy any idle slots
                idles -= frequencies[i] == frequencies[25] ? frequencies[i] - 1 : frequencies[i];
            }

            return idles > 0 ? tasks.length + idles : tasks.length;
        }

        // ANALYTICAL APPROACH 1 - Interview friendly. Count frequencies and calculate how many partitions, idle slots per partition and total length after all idle slots have been filled.
        // space = N for frequency map + N for PQ
        // time = N for frequency map
        public int leastInterval_frequencyanalysis(char[] tasks, int n) {
            Map<Character, Integer> freq = new HashMap<>();


            int maxFreq = 0;
            int maxFreqCount = 0;

            for (char task : tasks) {
                int newCount = freq.getOrDefault(task, 0) + 1;
                freq.put(task, newCount);
                if (newCount == maxFreq) {
                    maxFreqCount++;
                } else if (newCount > maxFreq) {
                    maxFreq = newCount;
                    maxFreqCount = 1;
                }
            }

            // NOTE in interview go through AAABBBCCCDDD,2 and AAABBCCDD,2

            // max frequency is the long poll. It divides result into maxFreq-1 smaller parts
            // e.g. AAABB maxFreqCount = 1 and maxFreq - 3, so we can divide intput into 3-1 = 2 parts A[_ _]A[_ _]A
            int partitions = maxFreq - 1; // 1

            // a partition can contians more than n tasks per partition since the criteria for k skips is still satisfied and we dont even need any idle cycles
            // e.g. AAABBBCCCDDD and n = 2 then each patition contains ABCD
            // e.g. in AAABBB and n = 2 we need only 2 paritions AB_AB
            // thus empty elemnts in each partition needs to be cauclated to move ahead
            int idleSlotsInEachPartition = Math.max(n + 1 - maxFreqCount, 0); // 1


            // length is empty slots + maxFreq character counts
            int lengthWithIdleAndMaxFreqCounted = idleSlotsInEachPartition * partitions + maxFreqCount * maxFreq;

            int tasksLeftAfterMaxFreqCounted = tasks.length - lengthWithIdleAndMaxFreqCounted;

            if (tasksLeftAfterMaxFreqCounted < 0) {
                // there are idle slots
                return lengthWithIdleAndMaxFreqCounted;
            }

            // we need to add all remaining elements into the answer. we are sure that tasksLeftAfterMaxFreqCounted can be arranged inside the original lengthWithIdleAndMaxFreqCounted since
            // we can always swap the non-max-frequenct characters  to avoid any kind of contradiction
            return lengthWithIdleAndMaxFreqCounted + tasksLeftAfterMaxFreqCounted;

        }

//     // GREEDY algorithm
//     // time = for N elements, create heap logN and for each element, push and pop k times worst case = NkLogN
//     // space = N for pq
//     // after filling up max heap for character frequency, we process K+1 elements at a time (to prvent duplicates in a K window) and increment result based on how many
//     // elements were removed or idle spots were left.
//     public int leastInterval(char[] tasks, int n) {

//         Map<Character, Integer> freq = new HashMap<>();

//         for (char c : tasks) {
//             freq.put(c, freq.getOrDefault(c, 0) + 1);
//         }

//         PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(freq.size(), (a,b) -> a.getValue() == b.getValue() ? a.getKey() - b.getKey() : b.getValue() - a.getValue());

//         pq.addAll(freq.entrySet()); // A3 B3

//         // IMPORTANT: this stores how many entries we processed or were left null. If we wanted to produce an exact order in which the items would be processed, this would be a list and we would keep
//         // adding prorcessed characters or null/empty vlaues to this lst as needed.
//         int result = 0;

//         while (!pq.isEmpty()) {

//             int count = n + 1;

//             // this is the cooldown window. This stores all the top k frequencies so that we do not count them twise within a k-sized window
//             List<Map.Entry<Character, Integer>> currWindow = new ArrayList<>();

//             // process current K size window
//             while (count > 0 && !pq.isEmpty()) {

//                 Map.Entry<Character, Integer> entry = pq.poll();
//                 if (entry.getValue() > 1) {
//                     entry.setValue(entry.getValue() -1);
//                     currWindow.add(entry);
//                 }
//                 // entry was processed
//                 result ++;
//                 count--; // 2
//             }


//             while (!currWindow.isEmpty()) {
//                 pq.offer(currWindow.remove(0));
//             }

//             // add all emty slots for this k size window to the result since these slots will go un-filled into the final result
//             if (!pq.isEmpty()) {
//                 result += count;
//             }
//         }

//         return result;
//     }
    }
}
