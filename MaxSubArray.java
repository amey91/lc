package leetcode;

public class MaxSubArray {
    public int maxSubArray(int[] A) {
        if(A.length==1)
            return A[0];
        int currSum=A[0], maxSum=A[0];
        for(int i=1; i<A.length; i++){
            currSum = Math.max(currSum+A[i],A[i]);
            maxSum = currSum>maxSum? currSum:maxSum; //this seems to be faster than Math.max() for my 64 bit JVM
        }
        return maxSum;
    }
}
