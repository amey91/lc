package javalang.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstructionByHeight {

    class Solution {

//     406. Queue Reconstruction by Height
//     https://leetcode.com/problems/queue-reconstruction-by-height/

        // space = N
        // time = N
        // sort people in descending order and then their indexes in the input turn into actual incremental indexes!
        public int[][] reconstructQueue(int[][] people) {

            // arrange in descending order of height and ascending order of index for same height
            Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < people.length; i++) {
                int[] person = people[i];

                // add in the order of index in the input. Since there are no numbers smaller that this current height in the result at the moment,
                // the index in input is the acutal index of the element at this point in the list
                list.add(person[1], person);
            }

            return list.toArray(new int[people.length][]);
        }


        // I initially solved it using ascending sorted heights. The smallest hieght is the actual index in the answer. For each incremental
        // height, we have to skip empty slots and also skip numbers greater than or equal to current height. When we ahve skipped enough, we have arrived!
        // time = N^2
        // space = N
        public int[][] reconstructQueue_usingIncreasingHeightLogic(int[][] people) {
            Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

            int[][] result = new int[people.length][];

            for (int i = 0; i < people.length; i++) {

                int[] person = people[i];
                int skip = person[1];

                int currSkip = 0;
                int currIndex = 0;
                while (currIndex < people.length && currSkip < skip) {
                    if (result[currIndex] == null || result[currIndex][0] >= person[0]) {
                        currIndex++;
                        currSkip++;
                    } else {
                        currIndex++;
                    }
                }

                while (currIndex < people.length && result[currIndex] != null) {
                    currIndex++;
                }

                result[currIndex] = person;
            }

            return result;
        }
    }
}
