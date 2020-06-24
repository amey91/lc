package javasolutions.bitmanipulation;

public class BitwiseAndForNumbersInRange {
// 201. Bitwise AND of Numbers Range
// https://leetcode.com/problems/bitwise-and-of-numbers-range/


    class Solution {
        public int rangeBitwiseAnd(int m, int n) {


            int i = 0;

            // each time we add 1, one of the bits flips. Thus the AND result would be 0 for all bits that are flipped between the 2 numbers.

            // find how many bits are flipped/different for the two numbers and store the result in i
            while (m != n) {
                m = m >> 1;
                n = n >> 1;
                i++;
            }

            // left shift the number by i so that all flipped bits are zero
            return m << i;
        }
    }
}
