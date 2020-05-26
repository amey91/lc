package javalang;

import java.util.HashMap;
import java.util.Map.Entry;

public class SingleNumberIIMethod1 {
    public int singleNumber(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int k : A){
            if(map.containsKey(k)){
                int count = map.get(k);
                if(count==2)
                    map.remove(k);
                else 
                    map.put(k,count+1);
            } else{
                map.put(k,1);    
            }
        }
        int k=0;
        for(Entry<Integer, Integer> entry : map.entrySet())
            k = entry.getKey();
        return k;
    }
}