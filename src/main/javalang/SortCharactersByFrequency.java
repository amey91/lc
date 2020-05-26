package javalang;

// #451. Sort Characters By Frequency
public class SortCharactersByFrequency {

    class Solution {
        public String frequencySort(String s) {
            if (s == null || s.length() == 0) {
                return s;
            }

            // all inputs fit within this array!! this handles all upper, lower and numbers
            // SO you can either count frequencies using map.getOrDefault() or use this chars[index]++
            int[] counts = new int[128];
            char[] resultS = s.toCharArray();
            for (char c: resultS) {

                // I can directly map all chars to array indexes!
                counts[c]++;
            }
            int currentIndex = 0;
            while (currentIndex < resultS.length) {
                int maxCount = 0;
                int index = 0;

                for (int i = 0; i < 128; i++) {
                    if (counts[i] > maxCount) {
                        maxCount = counts[i];
                        index = i;
                    }
                }
                while(maxCount > 0) {
                    maxCount --;

                    // Reuse input array because this is much faster than StringBuilder
                    resultS[currentIndex++] = (char)index;
                }
                counts[index] = 0;
            }
            return new String(resultS);
        }
    }
}
