public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int begin = 0;
        int end = nums.length-1;
        // establish a left boundary
        if(target<=nums[begin]) {
            return begin;
        }
        // establish a right boundary
        if(target>nums[end]) {
            return end+1;
        }
        return binarySearchInsertPosition(nums, begin, end, target);
    }

    private int binarySearchInsertPosition(int[] nums, int begin, int end, int target) {
        if(Math.abs(begin-end)<2) {
            return begin+1;
        }
        int position = (begin + end) /2;
        if(nums[position]==target) {
            return position;
        }
        if(nums[position]<target) {
            return binarySearchInsertPosition(nums, position, end, target);
        }

        return binarySearchInsertPosition(nums, begin, position, target);
    }
}