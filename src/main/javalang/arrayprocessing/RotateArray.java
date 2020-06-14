package javalang.arrayprocessing;

public class RotateArray {

    // 189. Rotate Array
// https://leetcode.com/problems/rotate-array/


    class Solution {

        // space = k
        // time = n + 2k = n
        // IMPORTANT: there are N time and 1 space solutions available where you reverse the entire array then reverse the (0 to k-1) and (k to n-1) parts

        public void rotate(int[] nums, int k) {
            // algo: copy last k element to temp array
            // copy first n-k elements to end
            // copy tem array into front of answer
            if (nums == null || k < 0) {
                return;
            }

            k = k % nums.length;

            // 0 1 2 3 _ 4 5 6
            // n= = 7 =  4 5 6 0 1 2 3 4
            int[] temp = new int[k];
            int n = nums.length;
            for (int i = n - k, j = 0; i < n; i++, j++) { // i == 4 to 6
                // temp array pop
                temp[j] = nums[i];
            }

            // move n - k elements

            for (int i = n-k-1; i >= 0; i--) { // i = 6 to 5
                nums[i + k] = nums[i];
            }

            // upperloop is simpler because stopping limit is clear
            // for (int i = n-1; i > k-1; i--) { // i from n-1 to (n-1-(n-k))
            //     nums[i] = nums[i-k];
            // }

            for (int i = 0; i < k; i++) {
                nums[i] = temp[i];
            }
        }
    }
}
