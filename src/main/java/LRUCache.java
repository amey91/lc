import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    
    private LinkedHashMap<Integer,Integer> map = null;
    private int capacity;
    
    public LRUCache(final int capacity) {
        assert capacity>0;
        //set accessOrder to true. accessOrder includes inserts as well as reads.
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest){
                return size()>capacity;                
            }
        };
        this.capacity=capacity;
    }
    
    public int get(int key) {
        return map.containsKey(key)? map.get(key) : -1;
    }
    
    public void set(int key, int value) {
        map.put(key, value);
    }
}