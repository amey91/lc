package javalang.bitmanipulation;

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

            while (num != 0) {

                int last4 = num & 15;
                sb.insert(0, HEX[last4]);
                num = num >>> 4;
            }

            return sb.toString();
        }
    }
}
