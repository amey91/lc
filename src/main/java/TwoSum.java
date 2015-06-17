import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0; i<numbers.length;i++){
            if(hm.containsKey(target-numbers[i])){
                int bigger;
                int smaller;
                result[0] = hm.get(target-numbers[i])+1;
                result[1] = i+1;
                return result;
            } else {
                hm.put(numbers[i], i);
            }
            
        }
        return result;
    }
}