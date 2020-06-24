package javasolutions;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n<3) {
            return n;
        }
        int[] counts = new int[n+1];
        counts[0] = 0;
        counts[1] = 1;
        counts[2] = 2;
        for(int i=3; i<counts.length; i++) {
            counts[i] = counts[i-1] + counts[i-2];
        }
        return counts[n];
    }
}