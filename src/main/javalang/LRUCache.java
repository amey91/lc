package javalang;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {


    public class LRUCache_newSolution2020 {
// 1.41
//     Algorithm
// get:
//     if map contains key then return node.value
//     else return -1
// put
//     if map contains entry
//         connect prev and next pointers of node
//         insert node to front of list()
//     else
//         insert node into map
//         insert node to front of list()
//         if capacity < map.size()
//             delete the last entry in list
//             delete corresponding map entry

        class Node {
            Node next;
            Node prev;
            int val;
            int key;

            public Node() {
                next = null;
                prev = null;
                val = -1;
                key = -1;
            }
        }

        Node head;
        Node tail;
        Map<Integer, Node> map;
        int capacity;

        public LRUCache_newSolution2020(int capacity) {
            this.head = new Node();
            this.tail = new Node();
            this.map = new HashMap<>();
            this.head.prev = tail;
            this.tail.next = head;
            this.capacity = capacity;
        }

        // tail - head
        public int get(int key) {
            if (map.containsKey(key)) {
                bringToFront(map.get(key));
                return map.get(key).val;
            }
            return -1;
        }

        public void put(int key, int value) {
            new LinkedHashMap<Integer, Integer>(10, 0.1f, true);
            if (map.containsKey(key)) {
                map.get(key).val = value;
                bringToFront(map.get(key));
                return;
            }
            Node n = new Node();
            n.val = value;
            n.key = key;
            map.put(key, n);
            insertInFront(n);
            checkCapacity();
        }

        private void bringToFront(Node n) {
            n.prev.next = n.next;
            n.next.prev = n.prev;
            insertInFront(n);
        }

        private void insertInFront(Node n) {
            head.prev.next = n;
            n.prev = head.prev;
            n.next = head;
            head.prev = n;
        }

        private void checkCapacity() {
            if (capacity < map.size()) {
                // deleteLast
                Node toBeDeleted = tail.next;
                tail.next = tail.next.next;
                tail.next.prev = tail;
                map.remove(toBeDeleted.key);

                // clear all pointers for deleted node
                toBeDeleted.next = null;
                toBeDeleted.prev = null;
            }
        }
    }


    public class LRUCache_oldSolution2016 {
        private LinkedHashMap<Integer, Integer> map = null;
        private int capacity;

        public LRUCache_oldSolution2016(final int capacity) {
            assert capacity > 0;
            //set accessOrder to true. accessOrder includes inserts as well as reads.
            map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                    return size() > capacity;
                }
            };
            this.capacity = capacity;
        }

        public int get(int key) {
            return map.containsKey(key) ? map.get(key) : -1;
        }

        public void set(int key, int value) {
            map.put(key, value);
        }
    }
}