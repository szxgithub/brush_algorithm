package middle;

import java.util.HashMap;
import java.util.Map;

public class Item1590 {

    /*
    使数组和能被 P 整除
    返回需要移除的最短子数组的长度，如果无法满足要求，则返回-1

     */
    /*
    使用前缀和 哈希表
     */
    public int minSubarray(int[] nums, int p){
        int n = nums.length, mod = 0;
        for(int num : nums){
            mod = (mod + num) % p;
        }
        if(mod == 0){
            return 0;
        }
        int res = n, subMod = 0;
        Map<Integer, Integer> hashmap = new HashMap<>();
        hashmap.put(0, -1);
        for(int i = 0; i < n; i++){
            subMod = (subMod + nums[i]) % p;
            int target = (subMod - mod + p) % p;
            if(hashmap.containsKey(target)){
                res = Math.min(res, i - hashmap.get(target));
                if(res == 1 && res != n){
                    return res;
                }
            }
            hashmap.put(subMod, i);
        }
        if(res == n){
            return -1;
        }
        return res;
    }

    public static void main(String[] args) {



    }

}
