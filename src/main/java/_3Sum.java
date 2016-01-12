import java.util.*;

public class _3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++) {

            // TIP: normally, I would do a 2sum using hashmap, but since this
            // array is sorted, we have a special case where we can traverse the array from
            // each direction and smartly decide which pointer to move
            if(i>0 && nums[i]==nums[i-1]) {
                continue;
            }
            int j=i+1;
            int k=nums.length-1;
            while(j<k) {
                int currSum = nums[i] + nums[j] + nums[k];
                if(currSum==0) {
                    answer.add(makeTrio(nums[i], nums[j], nums[k]));
                    j++;k--;
                } else if(currSum < 0) {
                    j++;
                } else {
                    k--;
                }
                while(j<k && j>(i+1) && nums[j]==nums[j-1]) {
                    j++;
                }
                while(j<k && k<nums.length-1 && nums[k]==nums[k+1]) {
                    k--;
                }
            }


        }
        return answer;
    }

    private List<Integer> makeTrio(int a, int b, int c) {
        return new ArrayList<Integer>(){{add(a);add(b);add(c);}};
    }
}