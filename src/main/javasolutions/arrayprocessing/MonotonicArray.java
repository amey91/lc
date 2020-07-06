package javasolutions.arrayprocessing;

// 896. Monotonic Array
// https://leetcode.com/problems/monotonic-array/

class Solution {


    // see if array is either incrementing or decrementing for each value
    public boolean isMonotonic(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }
        boolean incr = true;
        boolean decr = true;
        for (int i = 1; i< A.length; i++) {
            incr &= A[i] >= A[i-1];
            decr &= A[i] <= A[i-1];

            // exit early for 99% beat
            if (!incr && !decr) {
                return false;
            }
        }

        return incr || decr;

    }

//     public boolean isMonotonic_faster_but_more_complex(int[] A) {
//         if (A == null || A.length == 0) {
//             return false;
//         }
//         if (A.length <= 2) {
//             return true;
//         }
//         int i = 0;

//         // goto first comparable integer
//         while (i < A.length -1 && A[i] == A[i+1]) {
//             i++;
//         }

//         // already at end?
//         if (i == A.length - 1) {
//             return true;
//         }

//         int compare = Integer.compare(A[i], A[i+1]);

//         for (; i< A.length - 1; i++) {
//             if (A[i] != A[i+1] && Integer.compare(A[i], A[i+1]) != compare) {
//                 return false;
//             }
//         }

//         return true;

//     }
}