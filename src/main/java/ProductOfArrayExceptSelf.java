public class ProductOfArrayExceptSelf {
  public int[] productExceptSelf(int[] nums) {
    int[] ans = new int[nums.length];
    int product = 1;
    boolean oneZero = false;
    boolean twoZero = false;
    for(int i=0; i<nums.length; i++) {
      if(nums[i]!=0)
        product = product*nums[i];
      if(nums[i]==0) {
        if(oneZero) {
          twoZero = true;
        }
        oneZero=true;
      }
    }
    for(int i=0; i<nums.length; i++) {
      ans[i] = twoZero? 0 : oneZero? nums[i]==0? product : 0 : product/nums[i];
    }

    return ans;
  }
}