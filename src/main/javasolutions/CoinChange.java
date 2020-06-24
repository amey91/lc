package javasolutions;

public class CoinChange {
    // https://leetcode.com/problems/coin-change/submissions/
// 322. Coin Change


// wrong Greedy soution:
// subtract max possible value till remaining sum becomes lower than that value.
// if reminang sum == 0, return count
// if you run out of coins, return -1


// correct DP solution
// f(amount)
// f(0) = 0
// f(n) = if amount - coins[i] >= 0 then f(amount - coins[i]) + 1
// if amount is remaining then return -1

    class Solution {
        public int coinChange(int[] coins, int amount) {
            if (coins == null) {
                return 0;
            }
            if (amount == 0) {
                return 0;
            }

            // better run times can be achieved by creating int and using amount+1 instead of null
            Integer[] dp = new Integer[amount + 1];
            // bottom up approach, you hardcode all the edge conditions before iterating
            dp[0] = 0;

            for (int i = 1; i <= amount; i++) {
                Integer min = null;
                for (int j = 0; j < coins.length; j++) {
                    int childAmount = i - coins[j];
                    if (childAmount >= 0) {
                        Integer childAmountCoins = dp[childAmount];

                        // Trust that subsolutions are solved, thus there is no need to iterate
                        if (childAmountCoins != null) {
                            min = min == null ? childAmountCoins + 1 : Math.min(min, childAmountCoins + 1);
                        }
                    }
                }
                dp[i] = min;
            }
            return dp[amount] == null ? -1 : dp[amount];
        }


//         // bottom up is calculateCoins(coins, i, dp); but this should be iterative otherwise it is not much better than recursive
//         // top down is calculateCoins(coins, amount, dp);
//     private Integer calculateCoins_recursive(int[] coins, int amount, Integer[] dp) {

//         if (amount < 0) {
//             return null;
//         }
//         if (amount == 0) {
//             return 0;
//         }
//         if (dp[amount] != null) {
//             return dp[amount];
//         }

//         Integer min = null;
//         // iterate through all coin combinations
//         for (int i = 0; i < coins.length; i++) {
//             int currAmount = amount;
//             Integer subSolution = calculateCoins(coins, amount - coins[i], dp);
//             if (subSolution != null && subSolution >= 0) {
//                 subSolution += 1;
//                 min = min == null? subSolution: Math.min(min, subSolution);
//             }
//         }
//         if (min == null) {
//             dp[amount] = -1;
//         } else {
//             dp[amount] = min;
//         }
//         return dp[amount];
//     }
    }
}
