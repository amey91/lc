import java.util.Arrays;

public class MajorityElement_1 {
      public int majorityElement(int[] num) {
                Arrays.sort(num);
                        return num[num.length/2];
                            }
}
