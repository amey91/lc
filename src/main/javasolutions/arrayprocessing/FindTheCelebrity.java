package javasolutions.arrayprocessing;

public class FindTheCelebrity {

    /* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

    // 277. Find the Celebrity
// https://leetcode.com/problems/find-the-celebrity/
// Medium
    public class Solution extends Relation {

        // space = 1
        // time = N + N = N
        // We find the possible celeb cndidate in N time using an incrementing pointer. Once we have that, we have sure that guy is celeb.
        // If that guy is not celeb then no one else as explained below. Nice! https://leetcode.com/problems/find-the-celebrity/discuss/71227/Java-Solution.-Two-Pass
        // I had created a N^2 solution below which is not optimal
        public int findCelebrity(int n) {
            int candidate = 0;

            // candidate always moves forward!
            // At the end of the loop all elements after candidate have been checked. All elements before candidate also
            // know someone after them or are not known by someone. Thus candidate is the only posible solution
            for (int i = 1; i < n; i++) {
                if (knows(candidate, i)) {
                    candidate = i;
                }
            }

            // see if our candidate is the celeb. This can be optimized since we have checked knows(candidate, candidate+1...n-1) above, but keeping this for readability
            for (int i = 0; i < n; i++) {
                if (i == candidate) {
                    continue;
                }
                if (!knows(i, candidate) || knows(candidate, i)) {
                    return -1;
                }
            }
            return candidate;
        }

        // time = N^2
        // spae = N
        // this can be improved to N time and 1 space as shown above
//     public int findCelebrity(int n) {

//         // start with negative array to avoid filling it. If we dont use this array, we wont be able to minimize
//         // calls to knows()
//         boolean[] notACeleb = new boolean[n];

//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 // dont ask if they know themselves and minimize calls to knows()
//                 if (i != j && (!notACeleb[i] || !notACeleb[j])) {
//                     if(knows(i, j)) {
//                         notACeleb[i] = true;
//                     } else {
//                         notACeleb[j] = true;
//                     }
//                 }
//             }
//         }

//         int celebIndex = -1;
//         int celebCount = 0;
//         for (int i = 0; i < n; i++) {
//             if (!notACeleb[i]) {
//                 celebCount++;
//                 celebIndex = i;
//             }
//         }

//         return celebCount == 1? celebIndex: -1;
//     }
    }

    class Relation {
        protected boolean knows(int a, int b) {
            // STUB method
            return true;
        }
    }
}
