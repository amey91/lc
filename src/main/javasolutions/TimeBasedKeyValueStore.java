package javasolutions;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeBasedKeyValueStore {

    // 981. Time Based Key-Value Store
// https://leetcode.com/problems/time-based-key-value-store/

    // we store all main key and map it to treemap since we need ordering from within the values associated with the key
    // Time = logn for insertion + logN for retrieval
    // space = N
    class TimeMap {

        /** Initialize your data structure here. */

        Map<String, TreeMap<Integer, String>> map;

        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            if (!map.containsKey(key)) {
                map.put(key, new TreeMap<>());
            }

            map.get(key).put(timestamp, value);
        }

        public String get(String key, int timestamp) {
            if (!map.containsKey(key)) {
                return "";
            }

            TreeMap<Integer, String> inner = map.get(key);

            if (inner.containsKey(timestamp)) {
                return inner.get(timestamp);
            }

            Map.Entry<Integer, String> e =  inner.floorEntry(timestamp);
            return e == null ? "" : e.getValue();
        }
    }

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
}
