package middle;

import java.util.LinkedHashMap;

public class Item146 {

    /*
    LRU 缓存
     */

    static class LRUCache {
        int cap;
        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
        public LRUCache(int capacity) {
            this.cap = capacity;
        }

        public int get(int key) {
            if (!map.containsKey(key)){
                return -1;
            }
            Integer value = map.get(key);
            map.remove(key);
            map.put(key,value);
            return value;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)){
                map.remove(key);
                map.put(key,value);
                return;
            }
            if (map.size() >= this.cap){
                Integer oldestKey = map.keySet().iterator().next();
                map.remove(oldestKey);
            }
            map.put(key,value);
        }
    }

    public static void main(String[] args) {

        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }

}
