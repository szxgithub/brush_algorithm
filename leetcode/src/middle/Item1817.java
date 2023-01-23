package middle;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Item1817 {

    /**
     * 查找用户活跃分钟数
     *
     *
     */


    public int[] findingUsersActiveMinutes(int[][] logs, int k) {

        HashMap<Integer, Set<Integer>> map = new HashMap<>();

        for (int i = 0; i < logs.length; i++) {
            Set<Integer> orDefault = map.getOrDefault(logs[i][0],new HashSet<>());
            orDefault.add(logs[i][1]);
            map.put(logs[i][0], orDefault);
        }

        Collection<Set<Integer>> values = map.values();
        int[] res = new int[k];
        for (Set<Integer> set : values){
            if (set.size() >0 && set.size() <= k){
                res[set.size() - 1] += 1;
            }
        }

        return res;


    }

    public static void main(String[] args) {

    }

}
