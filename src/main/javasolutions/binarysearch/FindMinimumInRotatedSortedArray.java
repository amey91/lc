package javasolutions.binarysearch;

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        // the linear solution is faster than binary solutions for some reason
        if (nums.length == 0) {
            return 0;
        }
        int min = nums[0];
        for (int i = 1; i < nums.length ; i++) {
            if (min > nums[i]) {
                return nums[i];
            }
        }
        return min;
    }
}