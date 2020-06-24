package javasolutions;

import java.util.List;

import javasolutions.commons.NestedInteger;

public class NestedListWeightSum {
    // 339. Nested List Weight Sum
// https://leetcode.com/problems/nested-list-weight-sum/

    class Solution {
        public int depthSum(List<NestedInteger> nestedList) {
            return depthSumHelper(nestedList, 1);
        }

        private int depthSumHelper(List<NestedInteger> nestedList, int depth) {
            if (nestedList == null) {
                return 0;
            }

            int sum = 0;

            for (NestedInteger nI : nestedList) {
                if (nI.isInteger()) {
                    sum += nI.getInteger() * depth;
                } else {
                    sum += depthSumHelper(nI.getList(), depth + 1);
                }
            }
            return sum;
        }

    }
}
