package javasolutions;

public class CountingElements {
    // 1426. Counting Elements
// https://leetcode.com/problems/counting-elements/
    class Solution {
        public int countElements(int[] arr) {
            if (arr == null || arr.length == 0) {
                return 0;
            }
            int[] counts = new int[1001];
            for (int a: arr) {
                counts[a]++;
            }
            int result = 0;
            for (int i = 0; i < counts.length-1; i++) {
                if (counts[i] > 0 && counts[i+1] > 0) {
                    result += counts[i];
                }
            }
            return result;
        }
    }
}
