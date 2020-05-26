package javalang;

// https://leetcode.com/problems/happy-number/
// #202. Happy Number
public class HappyNumber {
    class Solution {

        // constant space and n time
        public boolean isHappy(int n) {
            int slow = n;
            int fast = sumOfDigitsSquared(n);

            while (slow != fast) {
                slow = sumOfDigitsSquared(slow);
                fast = sumOfDigitsSquared(sumOfDigitsSquared(fast));
            }

            return fast == 1;
        }

        private int sumOfDigitsSquared(int n) {
            int sum = 0;
            while (n > 0) {
                int digit = n%10;
                n = n/10;
                sum += digit*digit;
            }
            return sum;
        }

        // this is n space and n time
        // public boolean isHappy(int n) {
        //     Set<Integer> seen = new HashSet<>();
        //     while(true) {
        //         int sum = sumOfDigitsSquared(n);
        //         if (sum == 1) {
        //             return true;
        //         }
        //         if (seen.contains(sum)) {
        //             return false;
        //         }
        //         seen.add(sum);
        //         n = sum;
        //     }
        // }
    }
}
