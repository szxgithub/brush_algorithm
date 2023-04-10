package easy;

import java.util.HashMap;
import java.util.Map;

public class Item2399 {

    /*
    检查相同字母间的距离

     */

    public boolean checkDistances(String s, int[] distance) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (!map.containsKey(c)){
                map.put(c,i);
            }else {
                map.put(c,i - map.get(c) - 1);
            }
        }

        for (Map.Entry<Character,Integer>  entry : map.entrySet()){
            int index = entry.getKey() - 'a';
            if (distance[index] != entry.getValue()){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Item2399 item2399 = new Item2399();
        String s = "abaccb";
        int[] distance = {1,3,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        boolean b = item2399.checkDistances(s, distance);
        System.out.println(b);

    }

}
