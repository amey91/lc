package javalang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

//  #380  https://leetcode.com/problems/insert-delete-getrandom-o1/submissions/
public class InsertDeleteRandomO1 {
    class RandomizedSet {

        // key to index
        Map<Integer, Integer> map;

        // keys of map
        List<Integer> list;

        Random random;

        /** Initialize your data structure here. */
        public RandomizedSet() {
            map = new HashMap<>(50);
            list = new ArrayList<>(50);
            random = new Random();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            list.add(val);
            map.put(val, list.size()-1);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            Integer index = map.remove(val);
            if (index == list.size()-1) {
                list.remove(list.size()-1);
                return true;
            }
            Integer lastElement = list.get(list.size()-1);
            list.set(index, lastElement);
            list.remove(list.size()-1);
            map.put(lastElement, index);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            if (list.isEmpty()) {
                return 0;
            }
            return list.get(random.nextInt(list.size()));

        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
