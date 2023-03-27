package middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Item763 {

    /*
    划分字母区间
     */

    /*
    逻辑分析
    暴力破解
     */
    public List<Integer> partitionLabels(String s){

        HashMap<Character, Integer[]> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (!map.containsKey(c)){
                int first = s.indexOf(c);
                int last = s.lastIndexOf(c);
                map.put(c,new Integer[]{first,last});
            }
        }
        List<Integer[]> ans = new ArrayList<>();
        List<Integer[]> collect = map.values().stream().collect(Collectors.toList());
        collect.sort((a,b)->{
            return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
        });
        // 合并区间
        for (int i = 0; i <collect.size(); i++){
            Integer[] tmp = new Integer[2];
            Integer[] fisrt = collect.get(i);
            tmp[0] = fisrt[0];
            tmp[1] = fisrt[1];
            for (int j = i+1; j < collect.size(); j++){
                Integer[] second = collect.get(j);
                if (second[0] < tmp[1] && second[1] > tmp[1]){
                    tmp[1] = second[1];
                    i++;
                }
                if (second[0] < tmp[1] && second[1] < tmp[1]){
                    i++;
                }
            }
            ans.add(tmp);
        }
        List<Integer> res = new ArrayList<>();
        for (Integer[] integer : ans){
            int i = integer[1] - integer[0] + 1;
            res.add(i);
        }
        return res;

    }

    /*
    贪心思想
     */
    public List<Integer> partitionLabels2(String s){
        int[] last = new int[26];
        int length = s.length();
        for (int i = 0; i <length; i++){
            last[s.charAt(i)-'a'] = i;
        }

        List<Integer> partition = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++){
            end = Math.max(end,last[s.charAt(i) - 'a']);
            if (i == end){
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }

}
