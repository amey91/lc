package javasolutions.bitmanipulation;

public class ConvertNumberToHexadecimal {
    // 405. Convert a Number to Hexadecimal
// https://leetcode.com/problems/convert-a-number-to-hexadecimal/

    class Solution {

        private final char[] HEX = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

        // algo: one hex digit corresponds to the last 4 bits of the number. Convert each 4 bits to hex
        public String toHex(int num) {
            if (num == 0) {
                return "0";
            }

            StringBuilder sb = new StringBuilder();

            // IMPORtANT: I had written while(num > 0) which will not work for -ve numbers
            while (num != 0) {

                int last4 = num & 15;
                sb.insert(0, HEX[last4]);

                // IMPORTANT: >>> is logical shift and does not preserve negative number sign
                // And >> is numerical shift and preserves the sign. We need logical shift here!!
                num = num >>> 4;
            }

            return sb.toString();
        }
    }
}
