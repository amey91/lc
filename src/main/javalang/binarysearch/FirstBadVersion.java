package javalang.binarysearch;

public class FirstBadVersion {
    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
// 278. First Bad Version
// https://leetcode.com/problems/first-bad-version/
    class VersionControl {
        boolean isBadVersion(int n) {
            return true; // stubbed for compilation
        }
    }


    // binary search
    // time logN
    // space 1
    public class Solution extends VersionControl {
        public int firstBadVersion(int n) {

            int left = 1, right = n;
            int middle;

            // Analysis of binary search options:
            // I can do
            // 1. while(left<right) and right = (middle) or left = middle+1
            //     OR
            // 2. while(left<=right) and right = middle-1 or left = middle+1
            //
            // approach 1 says that I am not going to allow left==right so I can move only one pointer
            // approach 2 says that I am going to allow left==right so I have to move both pointers
            // Both work but I think it is better to use the convergence on one value using left<=right
            // No matter what approach I use, I can be sure that left pointer contains the answer index since right will cross over into good territory

            while (left <= right) {
                // IMPORTANT this is to avoid the overlfow bug!!! https://en.wikipedia.org/wiki/Binary_search_algorithm#Implementation_issues
                // overflow occurs when we do middle = (left+right)/2 This avoids that problem
                middle = left + (right - left)/2;
                // ALWAYS move the pointer since our condition allows equal values otherwise infinite loop when (left == right)
                if (isBadVersion(middle)) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }


            // left is always at inflection point since it is bad, right will cross over the answer
            return left;
        }
    }
}
