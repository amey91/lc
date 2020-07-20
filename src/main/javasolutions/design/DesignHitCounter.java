package javasolutions.design;

import java.util.ArrayDeque;

public class DesignHitCounter {
    // 362. Design Hit Counter
// https://leetcode.com/problems/design-hit-counter/

    // Maintains a ArrayDeque that we keep adding to window. Maximum size of window is 300
// since window size is 300 and clock is monotonically increasing
// Space = 300
// Time = O(1) for put, O(300) worst case (since everything can be removed)
    class HitCounter {

        int WINDOW = 300;

        // time of the hit
        ArrayDeque<Integer> list;
        int hits;


        /**
         * Initialize your data structure here.
         */
        public HitCounter() {
            this.hits = 0;
            this.list = new ArrayDeque<>();
        }

        /**
         * Record a hit.
         *
         * @param timestamp - The current timestamp (in seconds granularity).
         */
        public void hit(int timestamp) {
            list.offerLast(timestamp);
            hits++;
            // todo: delete while adding so time complexity is O(300)  = O(1)
        }

        /**
         * Return the number of hits in the past 5 minutes.
         *
         * @param timestamp - The current timestamp (in seconds granularity).
         */
        public int getHits(int timestamp) {
            while (!list.isEmpty()) {
                if (timestamp - 300 >= list.peekFirst()) {
                    list.pollFirst();
                    hits--;
                } else {
                    break;
                }
            }
            return hits;
        }
    }

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
}
