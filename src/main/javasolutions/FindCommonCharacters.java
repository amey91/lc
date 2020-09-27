package javasolutions;

import java.util.ArrayList;
import java.util.List;

// #1002. Find Common Characters
// https://leetcode.com/problems/find-common-characters/

public class FindCommonCharacters {

    // this solution parses each string and gets char counts into a frequancy array and maintains a running sum of min counts
    // from all strings since we need intersection
    // time = M (length of all strings in input)
    // space = 1 since chars are fixed
    class Solution {
        public List<String> commonChars(String[] A) {

            if (A == null || A.length == 0) {
                return null;
            }

            int[] intArr = getIntArray(A[0]);

            for (int i = 1; i < A.length; i++) {
                int[] currIntArray = getIntArray(A[i]);
                convergeArraysToMinValues(intArr, currIntArray);
            }

            List<String> list = new ArrayList<>();
            for (int i = 0; i < 26; i++) {
                int count = intArr[i];
                while (count > 0) {
                    count--;
                    list.add(String.valueOf((char) ('a' + i)));
                }
            }
            return list;
        }

        private int[] getIntArray(String s) {
            int[] result = new int[26];
            char[] sChar = s.toCharArray();
            for (int i = 0; i < sChar.length; i++) {

                // Good way to downsize all lowercase chars to indices between 0 and 25
                result[sChar[i] - 'a']++;
            }
            return result;
        }

        private void convergeArraysToMinValues(int[] arr1, int[] arr2) {
            for (int i = 0; i < 26; i++) {
                arr1[i] = Math.min(arr1[i], arr2[i]);
            }
        }
    }
}
