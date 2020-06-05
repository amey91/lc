package javalang;

public class AddStrings {

    // https://leetcode.com/problems/add-strings/submissions/
// 415. Add Strings
    class Solution {
        public String addStrings(String num1, String num2) {

            int l1 = num1.length() - 1;
            int l2 = num2.length() - 1;
            StringBuilder sb = new StringBuilder();
            int carry = 0;
            while (l1 >= 0 && l2 >= 0) {
                int sum = num1.charAt(l1) - '0' + num2.charAt(l2) - '0';
                sb.append((carry + sum) % 10);
                carry = (carry + sum) / 10;
                l1--;
                l2--;
            }

            while (l1 >= 0) {
                int sum = carry + num1.charAt(l1) - '0';
                sb.append((int) sum % 10);
                carry = sum / 10;
                l1--;
            }

            while (l2 >= 0) {
                int sum = carry + num2.charAt(l2) - '0';
                sb.append(sum % 10);
                carry = sum / 10;
                l2--;
            }


            // IMP dont forget this!!
            if (carry > 0) {
                sb.append(carry);
            }

            return sb.reverse().toString();

        }
    }
}
