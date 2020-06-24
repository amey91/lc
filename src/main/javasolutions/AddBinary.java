package javasolutions;

public class AddBinary {
    // 67. Add Binary
// https://leetcode.com/problems/add-binary/

    class Solution {

        // add each number from the end and maintain carry. If one of the number ends, keep adding the number that is left
        // if the carry is still reaminng at end, include it in answer
        // space = max(N, M)
        // time = max(N, M)
        public String addBinary(String a, String b) {

            StringBuilder sb = new StringBuilder();

            char[] A = a.toCharArray();
            char[] B = b.toCharArray();

            int i = A.length -1 ;
            int j = B.length - 1;
            int carry = 0;
            while (i >=0 && j >= 0) {
                int[] sum = addNumbers(A[i], B[j], carry);
                sb.append(sum[0]);
                carry = sum[1];
                i--;j--;
            }

            while (i >=0) {
                int[] sum = addNumbers(A[i--], carry);
                sb.append(sum[0]);
                carry = sum[1];
            }


            while (j >=0) {
                int[] sum = addNumbers(B[j--], carry);
                sb.append(sum[0]);
                carry = sum[1];
            }

            if (carry == 1) {
                sb.append(carry);
            }

            return sb.reverse().toString();
        }

        private int[] addNumbers(char a_, char b_, int carry) {
            int a =  a_ == '1'? 1 : 0;
            int b = b_ =='1'? 1 : 0;
            int sum = a + b + carry;

            int result[] = new int[2];
            if (sum == 3) {
                result[0] = 1;
                result[1] = 1;
            } else if (sum == 2) {
                result[0] = 0;
                result [1] = 1;
            } else {
                result[0] = sum;
            }
            return result;

        }

        private int[] addNumbers(char a_, int carry) {
            int a =  a_ == '1'? 1 : 0;
            int sum = a + carry;

            int result[] = new int[2];
            if (sum == 2) {
                result[0] = 0;
                result [1] = 1;
            } else {
                result[0] = sum;
            }
            return result;
        }
    }
}