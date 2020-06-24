package javasolutions;

public class ProductOfArrayExceptSelf {

//  238. Product of Array Except Self
//  https://leetcode.com/problems/product-of-array-except-self/

  // this approach depends on eliminating one of the 2 arrays we use in N space solution
  public int[] productExceptSelf(int[] nums) {
    // algorithm
    // product = 1
    // for int i = 1; i<n; i++
    //      product *= nums[i-1]
    //      result[i] = product
    // product = 1
    // for int i = n-2; i>=0 ;i --
    //      product *= nums[i+1]
    //      result[i] = result[i] * product
    // return result

    if (nums == null || nums.length ==0) {
      return new int[0];
    }
    int n = nums.length;
    // this is allowed, does not count toward extra space, which is just an assumption in the problem statement.
    int[] result = new int[n];
    int product = 1;
    for (int i = 1; i < n; i++) {
      product *= nums[i-1];
      result[i] = product;
    }
    product = 1;
    for (int i = n-2; i>=0; i--) {
      product *= nums[i+1];

      // !!NOTE: 0 index is still uninitialized while coming back
      if (i != 0)
        result[i] = result[i] * product;
      else
        result[i] = product;
    }
    return result;

  }

//     public int[] productExceptSelf_NSpace(int[] nums) {
//         if (nums == null || nums.length == 0) {
//             return new int[0];
//         }
//         int n = nums.length;
//         int[] result = new int[n];
//         int[] left = new int[n];
//         int[] right = new int[n];

//         int product = 1;
//         for (int i = 0; i< n; i++) {
//             product *= nums[i];
//             left[i] = product;
//         }
//         product = 1;
//         for(int i = n-1; i >= 0; i--) {
//             product *= nums[i];
//             right[i] = product;
//         }

//         for (int i = 0; i< n; i++) {
//             if (i == 0) {
//                 result[i] = right[i+1];
//             } else if (i == n-1) {
//                 result[i] = left[i-1];
//             } else {
//                 result[i] = right[i+1]*left[i-1];
//             }
//         }
//         return result;
//     }

  // public int[] productExceptSelf_UsesDivision_whichIsNotAllowed(int[] nums) {
  //     if (nums == null || nums.length <2) {
  //         return new int[0];
  //     }
  //     int n = nums.length;
  //     int zeroes = 0;
  //     int zeroIndex = -1;
  //     int product = 1;
  //     for (int i = 0; i< n; i++) {
  //         if (nums[i] == 0) {
  //             zeroes ++;
  //             zeroIndex = i;
  //         } else {
  //             product *= nums[i];
  //         }
  //     }
  //     int[] result = new int[n];
  //     if (zeroes > 1) {
  //         return result;
  //     } else if (zeroes == 1) {
  //         result[zeroIndex] = product;
  //         return result;
  //     }
  //     for (int i = 0; i < n; i++) {
  //         result[i] = product / nums[i];
  //     }
  //     return result;
  // }
}