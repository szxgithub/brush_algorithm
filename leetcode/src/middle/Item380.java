package middle;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

public class Item380 {



}

/**
 * 变长数组 + Hash表
 *
 */
class RandomizedSet{

    HashMap<Integer,Integer> map;
    ArrayList<Integer> nums;
    Random random;

    public RandomizedSet(){
        map = new HashMap<>();
        nums = new ArrayList<Integer>();
        random = new Random();
    }


    public boolean insert(int val){
        if (map.containsKey(val)){
            return false;
        }
        int index = nums.size();
        nums.add(val);
        map.put(val,index);
        return true;
    }

    public boolean remove(int val){
        if (!map.containsKey(val)){
            return false;
        }else {
            Integer index = map.get(val);
            int last = nums.get(nums.size() - 1);
            // 把当前要删除的元素，用最后一个索引元素替换
            nums.set(index,last);
            // 更新最后一个元素的索引
            map.put(last,index);
            // 删除最后一个索引的元素
            // 删除变长数组的最后一个元素。该操作的时间复杂度是 O(1)O(1)O(1)，且可以保证在删除操作之后变长数组中的所有元素的下标都连续
            nums.remove(nums.size() - 1);
            map.remove(val);
            return true;
        }
    }

    public int getRandom(){

        int randomIndex = random.nextInt(nums.size());
        return nums.get(randomIndex);

    }
}
