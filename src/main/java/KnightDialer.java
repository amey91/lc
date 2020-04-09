package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KnightDialer {
    // @Revise
    // https://leetcode.com/problems/knight-dialer/
    // linear solution explanation: https://hackernoon.com/google-interview-questions-deconstructed-the-knights-dialer-f780d516f029
    // logarithmic solution explanation: https://medium.com/@alexgolec/google-interview-questions-deconstructed-the-knights-dialer-impossibly-fast-edition-c288da1685b8


    private static final int NUMS = 9;

    private static final int MODULO = 1_000_000_007;

    public int knightDialer(int N) {
        Map<Integer, List<Integer>> map = getMap();
        // number on keypad to current hop number
        int[][] memoize = new int[10][N];
        for (int i = 0; i< 10; i++) {
            memoize[i][0] = 1;
        }
        int sum = 0;
        for (int i = 0; i<= NUMS; i++) {
            sum = (sum + knightDialer_(i, N, map, memoize)) % MODULO;
        }
        return sum % MODULO;
    }

    private int knightDialer_(int curr, int N, Map<Integer, List<Integer>> map, int[][] memoize) {
        if (N == 1) {
            return 1;
        }
        int sum = 0;
        List<Integer> list = map.get(curr);
        for (Integer possibleNext : list) {
            if (memoize[possibleNext][N-1] == 0) {
                memoize[possibleNext][N-1] = knightDialer_(possibleNext, N-1, map, memoize) % MODULO;
            }
            sum = (sum + memoize[possibleNext][N-1]) % MODULO;
        }
        return sum;
    }

    private static Map<Integer, List<Integer>> getMap() {
        final Map<Integer, List<Integer>> map = new HashMap<>();
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
}
