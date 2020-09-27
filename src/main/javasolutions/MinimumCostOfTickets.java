package javasolutions;

import java.util.Arrays;

public class MinimumCostOfTickets {
    // 983. Minimum Cost For Tickets
// https://leetcode.com/problems/minimum-cost-for-tickets/

    // algorithm
// day = days[0]

    // for each in in costs[].length
//     cost = costs[i]
//     daysCovered = 1, 7 or 30
//     while days[index] <= day + daysCovered - 1
//         index++
//     index, currCost + cost
    class Solution {

        public int mincostTickets(int[] days, int[] costs) {
            if (days == null || costs == null) {
                return 0;
            }

            int[] dp = new int[days.length];
            Arrays.fill(dp, Integer.MAX_VALUE);
            int min = costHelper(days, costs, 0, dp);
            return min;

        }

        // here you dont need to pass in the currentCost top down, rather the counts will be calculated bottoms up in dp array
        private int costHelper(int[] days, int[] costs, int daysIndex, int[] dp) {
            if (daysIndex >= days.length) {
                return 0;
            }
            if (dp[daysIndex] != Integer.MAX_VALUE) {
                return dp[daysIndex];
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                int currCostAdd = costs[i];
                int currIndex = daysIndex;
                int daysCovered = i == 0? 1: i==1? 7: 30; // 1

                while (currIndex < days.length && days[currIndex] <= days[daysIndex] + daysCovered - 1) {
                    currIndex++;
                }

                int currIndexCost = costHelper(days, costs, currIndex, dp) + currCostAdd;
                min = Math.min(min, currIndexCost);
            }

            // IMP: for each index, we go through all possibilities (i.e. all 3 cost options in this scenario) and record the min
            dp[daysIndex] = min;
            return min;
        }
    }
}
