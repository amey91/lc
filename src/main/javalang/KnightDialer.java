package javalang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TODO: [low priority low risk] you understood the log solution usingmatrix multiplication but you didnt derive it on your own.
public class KnightDialer {
    // @Revise
    // https://leetcode.com/problems/knight-dialer/
    // linear solution explanation: https://hackernoon.com/google-interview-questions-deconstructed-the-knights-dialer-f780d516f029
    // logarithmic solution explanation: https://medium.com/@alexgolec/google-interview-questions-deconstructed-the-knights-dialer-impossibly-fast-edition-c288da1685b8

    private static Map<Integer, List<Integer>> map = null;

    private static final int NUMS = 9;

    // they have asked us to mod answer with this number
    private static final int MODULO = 1_000_000_007;

    // this is the linear solution with DP + memoization. This can be further optimized by going bottoms up since we dont have to recurse down
    // and remember counts for all root nodes. ONLY (N-1 x 10) level matters to calculate results of (N x 10) level. So space is constant
    // since only 10 x 1 matrix is needed in bottoms up solution
    public int knightDialer_topDown(int N) {
        Map<Integer, List<Integer>> map = getMap();
        // number on keypad to current hop number
        int[][] memoize = new int[10][N];
        for (int i = 0; i < 10; i++) {
            memoize[i][0] = 1;
        }
        int sum = 0;
        for (int i = 0; i <= NUMS; i++) {
            sum = (sum + knightDialer_topDown_(i, N, map, memoize)) % MODULO;
        }
        return sum % MODULO;
    }

    private int knightDialer_topDown_(int curr, int N, Map<Integer, List<Integer>> map, int[][] memoize) {
        if (N == 1) {
            return 1;
        }
        int sum = 0;
        List<Integer> list = map.get(curr);
        for (Integer possibleNext : list) {
            if (memoize[possibleNext][N - 1] == 0) {
                // modulo is commutative
                // (a + b) % c = ((a % c ) + (b % c)) %c
                memoize[possibleNext][N - 1] = knightDialer_topDown_(possibleNext, N - 1, map, memoize) % MODULO;
            }
            sum = (sum + memoize[possibleNext][N - 1]) % MODULO;
        }
        return sum;
    }

    private static Map<Integer, List<Integer>> getMap() {
        if (map != null) {
            return map;
        }
        map = new HashMap<>();
        map.put(1, Arrays.asList(8, 6));
        map.put(2, Arrays.asList(7, 9));
        map.put(3, Arrays.asList(4, 8));
        map.put(4, Arrays.asList(0, 3, 9));
        map.put(5, new ArrayList<>());
        map.put(6, Arrays.asList(1, 7, 0));
        map.put(7, Arrays.asList(2, 6));
        map.put(8, Arrays.asList(1, 3));
        map.put(9, Arrays.asList(2, 4));
        map.put(0, Arrays.asList(4, 6));
        return map;
    }

    private static List<Integer> getNeighbors(int position) {
        return getMap().get(position);
    }

    // Optimal bottoms up DP solution that uses smart memoization by only remembering results of (N) and (N-1) levels
    // at any point of time.
    public int knightDialer_bottomsUp(int N) {
        int[] current = new int[10];
        Arrays.fill(current, 1);
        int currentHop = 1;
        while (currentHop < N) {
            int[] previous = new int[10];
            System.arraycopy(current, 0, previous, 0, current.length);
            currentHop++;
            for (int i = 0; i < 10; i++) {
                int currSum = 0;
                for (int neighbor : getNeighbors(i)) {
                    currSum = (currSum + previous[neighbor]) % MODULO;
                }
                current[i] = currSum;
            }
        }
        int sum = 0;
        for (int value : current) {
            // modulo is commutative
            // (a + b) % c = ((a % c ) + (b % c)) %c
            sum = (sum + value) % MODULO;
        }
        return sum;
    }

    public static void main(String[] args) {
        new KnightDialer().knightDialer_bottomsUp(2);
    }

}
