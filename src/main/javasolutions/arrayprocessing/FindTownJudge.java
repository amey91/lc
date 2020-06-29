package javasolutions.arrayprocessing;

import java.util.Arrays;

public class FindTownJudge {
    // 997. Find the Town Judge
// https://leetcode.com/problems/find-the-town-judge/
    // Easy

    class Solution {
        /// maintain 2 arrays and mark trustCount (which is inCount) and canBeJudge flag (which is more like outCount)
        // This can also be done using just 1 array in which we do "+1" for incoming edge and "-1" for outgoing edge
        //  The inCount will be N-1 for the judge and outCount will be 0
        // Space = N + N = N
        // time = N + N = N
        public int findJudge(int N, int[][] trust) {

            if (trust == null) {
                return -1;
            }
            if (trust.length == 0 && N == 1) {
                return 1;
            }
            if (trust.length == 0) {
                return -1;
            }
            int[] trustCount = new int[N + 1];
            boolean canBeJudge[] = new boolean[N + 1];
            Arrays.fill(canBeJudge, true);

            for (int[] tr : trust) {
                trustCount[tr[1]]++;
                canBeJudge[tr[0]] = false;
            }

            int index = -1;
            int possibleJudges = 0;
            for (int i = 1; i <= N; i++) {
                if (canBeJudge[i] && trustCount[i] == N - 1) {
                    possibleJudges++;
                    index = i;
                }
            }

            if (possibleJudges != 1) {
                return -1;
            }
            return index;
        }
    }

}
