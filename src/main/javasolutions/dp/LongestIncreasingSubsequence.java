package javasolutions.dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {

        // tails[i] contains the minimum value of all tails of increasing subsequences of length i+1
        // e.g. tail[0] contains minimum value of all tails of length 1
        // NOTE not all of this array will be used, only "size" will be used where size is the length of the maximum length of increasing subsequence
        // space = N
        // time = NlogK where K = size of longest increasing subsequence
        int[] tails = new int[nums.length];

        int size = 0;

        for (int i = 0; i < nums.length; i++) {

            // IMPORTANT: at every stage, we only binary search from 0-size since everything else is 0
            int index = Arrays.binarySearch(tails, 0, size, nums[i]);

            // this is negative if the number was not found. However, the negative value represents the insertion point. The
            // 2's complement of this value will give the actual insertion point for the current array. This is also true for empty array
            if (index < 0) {
                // this is equivalent to index = - (index+1)
                index = ~index;
            }
            tails[index] = nums[i];

            // if the insertion point is at the end of the result, we increase size of the result
            if (index == size) {
                size++;
            }
        }

        return size;
    }

    // space = n
    // time = N^2
    // for each num, traveerse numbers prior to it and add lengths of max increasing substrings from prior to this number

//    public int lengthOfLIS_NSquared(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        if (nums.length == 1) {
//            return 1;
//        }
//
//        // 1 2 3 4 5 = 5
//        // 1 2 3 4 5
//
//        // 1 2 3 2 1 = 3
//        // 1 2 3 2 1
//        // initially all mem[i] = 1
//        // then compare all previous mem[j] to mem[i]
//        //      if (num[i] > num[j]) then mem[i] = max(mem[i], mem[j]+1)
//        // return max(mem[..])
//
//        // 1 2 4 3 6 5 8
//        // 1 2 3 3 4 4 4
//
//        // 1 2 4 3 6 5 7 8 = 6 = 1 2 3 5 7 8
//        // 1 2 3 3 4 4 5 6
//
//        // 6 5 4 3 2 1
//        // 1 1 1 1 1 1
//        int[] mem = new int[nums.length];
//        int maxLength = 0;
//        for (int i = 0; i < nums.length; i++) {
//            mem[i] = 1;
//            for (int j = 0; j < i; j++) {
//                if (nums[i] > nums[j]) {
//                    mem[i] = Math.max(mem[i], mem[j] + 1);
//                }
//            }
//            maxLength = Math.max(mem[i], maxLength);
//        }
//        return maxLength;
//    }

}
