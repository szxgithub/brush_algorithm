package hard;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class Item460 {

    /*
    LFU 缓存
     */

    class LFUCache{
        HashMap<Integer,Integer> keyToVal;
        HashMap<Integer,Integer> keyToFreq;
        HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;
        int minFreq;
        int cap;
        public LFUCache(int capacity){
            this.cap = capacity;
            this.minFreq = 0;
            keyToVal = new HashMap<>();
            keyToFreq = new HashMap<>();
            freqToKeys = new HashMap<>();
        }

        public int get(int key){
            if (!keyToVal.containsKey(key)){
                return -1;
            }
            increaseFreq(key);
            return keyToVal.get(key);
        }

        public void put(int key, int value){
            if (this.cap <= 0){
                return;
            }
            if (keyToVal.containsKey(key)){
                keyToVal.put(key,value);
                increaseFreq(key);
                return;
            }
            if (this.cap <= keyToVal.size()){
                removeMinFreqKey();
            }
            keyToVal.put(key,value);
            keyToFreq.put(key,1);
            freqToKeys.putIfAbsent(1,new LinkedHashSet<>());
            freqToKeys.get(1).add(key);
            this.minFreq = 1;
        }

        private void increaseFreq(int key){
            int freq = keyToFreq.get(key);
            keyToFreq.put(key,freq + 1);
            freqToKeys.get(freq).remove(key);
            freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<>());
            freqToKeys.get(freq + 1).add(key);
            if (freqToKeys.get(freq).isEmpty()){
                freqToKeys.remove(freq);
                if (freq == this.minFreq){
                    this.minFreq++;
                }
            }
        }

        private void removeMinFreqKey(){
            LinkedHashSet<Integer> keyList = freqToKeys.get(this.minFreq);
            Integer deletedKey = keyList.iterator().next();
            keyList.remove(deletedKey);
            if (keyList.isEmpty()){
                freqToKeys.remove(this.minFreq);
            }
            keyToVal.remove(deletedKey);
            keyToFreq.remove(deletedKey);
        }
    }

}
