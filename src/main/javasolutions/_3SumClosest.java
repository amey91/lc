package javasolutions;

import java.util.Arrays;

public class _3SumClosest {
  public int threeSumClosest(int[] nums, int target) {
    int diff = Integer.MAX_VALUE;
    int sum = target;

    Arrays.sort(nums);
    for(int i=0; i<nums.length-2; i++) {
      int j=i+1;
      int k=nums.length-1;
      while(j<k) {
        int currSum = nums[i] + nums[j] + nums[k];
        int currDiff = Math.abs(currSum - target);
        if(currDiff == 0) {
          return currSum;
        } else if(currDiff<diff) {
          diff=currDiff;
          sum = currSum;
        }

        if(currSum > target) {
          k--;
        } else {
          j++;
        }
      }

    }
    return sum;
  }
}