package javalang.arrayprocessing;

public class PlusOne {
    // 66. Plus One
// https://leetcode.com/problems/plus-one/
    class Solution {

        // add 1 to the numbers and maintain carry value always
        public int[] plusOne(int[] digits) {

            // add 1 to the number
            int carry = 1;

            for (int i = digits.length - 1; i >= 0; i--) {
                int sum = digits[i] + carry;
                if (sum > 9) {
                    sum = sum % 10;
                    carry = 1;
                } else {
                    carry = 0;
                }
                digits[i] = sum;
            }

            int[] result = digits;

            // if there is a final carry, add it to the result
            if (carry > 0) {
                result = new int[digits.length + 1];
                System.arraycopy(digits, 0, result, 1, digits.length);
                result[0] = carry;
            }

            return result;
        }
    }
}
