package javalang;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {

        // establish a left boundary
        if(target<=nums[0]) {
            return 0;
        }
        // establish a right boundary
        if(target>nums[nums.length-1]) {
            return nums.length;
        }
        return binarySearchInsertPosition(nums, 0, nums.length-1, target);
    }

    private int binarySearchInsertPosition(int[] nums, int begin, int end, int target) {
        if(Math.abs(begin-end)<2) {
            return begin+1;
        }
        int position = (begin + end) /2;

        if(nums[position]<target) {
            return binarySearchInsertPosition(nums, position, end, target);
        } else {
            return binarySearchInsertPosition(nums, begin, position, target);
        }

    }
}