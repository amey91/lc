package javalang;

public class FindPivotIndex {
    // 724. Find Pivot Index
// https://leetcode.com/problems/find-pivot-index/
    class Solution {

        // O(N) time and O(1) space by eliminating both arrays smartly
        public int pivotIndex(int[] nums) {

            if (nums == null) {
                return -1;
            }
            int n = nums.length;

            int sum = 0;
            for (int i = n - 1; i >= 0; i--) {
                sum += nums[i];
            }

            int runningSum = 0;
            for (int i = 0; i < n; i++) {
                if (i == 0 || i == n - 1) {
                    if (sum - nums[i] == 0) {
                        return i;
                    }
                } else {
                    if (sum - runningSum - nums[i] == runningSum) {
                        return i;
                    }
                }
                runningSum += nums[i];
            }
            return -1;
        }

        // this is O(N) time but O(N) space as well
//     public int pivotIndex(int[] nums) {

//         if (nums == null) {
//             return -1;
//         }
//         int n = nums.length;
//         int[] left = new int[n];
//         int[] right = new int[n];

//         int runningSum = 0;
//         for (int i = 0; i < n; i++) {
//             runningSum += nums[i];
//             left[i] = runningSum;
//         }
//         runningSum = 0;
//         for (int i = n-1; i >=0 ; i--) {
//             runningSum += nums[i];
//             right[i] = runningSum;
//         }

//         for (int i = 0; i < n; i++) {
//             if (i == 0 ) {
//                 if (right[i+1]==0) {
//                     return i;
//                 }

//             } else if (i == n-1) {
//                 if ( left[i-1] == 0) {
//                     return i;
//                 }
//             } else if (left[i-1] == right[i+1]) {
//                 return i;
//             }
//         }
//         return -1;
//     }
    }
}
