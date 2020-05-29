package javalang;

import java.util.List;

import javalang.commons.NestedInteger;

public class NestedListWeightSum2 {
    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     * // Constructor initializes an empty nested list.
     * public NestedInteger();
     * <p>
     * // Constructor initializes a single integer.
     * public NestedInteger(int value);
     * <p>
     * // @return true if this NestedInteger holds a single integer, rather than a nested list.
     * public boolean isInteger();
     * <p>
     * // @return the single integer that this NestedInteger holds, if it holds a single integer
     * // Return null if this NestedInteger holds a nested list
     * public Integer getInteger();
     * <p>
     * // Set this NestedInteger to hold a single integer.
     * public void setInteger(int value);
     * <p>
     * // Set this NestedInteger to hold a nested list and adds a nested integer to it.
     * public void add(NestedInteger ni);
     * <p>
     * // @return the nested list that this NestedInteger holds, if it holds a nested list
     * // Return null if this NestedInteger holds a single integer
     * public List<NestedInteger> getList();
     * }
     */


// 364. Nested List Weight Sum II
// https://leetcode.com/problems/nested-list-weight-sum-ii/
// this is a really cool solution: https://leetcode.com/problems/nested-list-weight-sum-ii/discuss/83641/No-depth-variable-no-multiplication

    class Solution {
        public int depthSumInverse(List<NestedInteger> nestedList) {
            if (nestedList == null) {
                return 0;
            }
            int depth = findDepth(nestedList, 0);
            return findSum(nestedList, depth);
        }

        private int findSum(List<NestedInteger> nestedList, int depth) {
            int sum = 0;

            for (NestedInteger n : nestedList) {
                if (n.isInteger()) {
                    sum += n.getInteger() * depth;
                } else {
                    sum += findSum(n.getList(), depth - 1);
                }
            }
            return sum;
        }

        private int findDepth(List<NestedInteger> nestedList, int depth) {

            depth += 1; // 1

            int currDepth = depth;

            for (NestedInteger n : nestedList) {
                if (!n.isInteger()) {
                    depth = Math.max(depth, findDepth(n.getList(), currDepth));
                }
            }

            return depth;

        }
    }
}
