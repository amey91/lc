// uses top down recursion, is inefficient
// can be optimized by bottoms up recursion with memoization

public class ClimbingStairsInefficient {

    public int climbStairs(int n) {
        if(n<2) {
            return n;
        }
        return count(n-1, 1)+count(n-2, 1);
    }

    private int count(int stepsLeft, int currentCount) {
        return stepsLeft==0? currentCount : stepsLeft==1? currentCount+1: stepsLeft==2? currentCount+3: count(stepsLeft-1, currentCount+1)+count(stepsLeft-2, currentCount+1);

    }
}