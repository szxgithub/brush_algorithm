package easy;

import java.util.*;
import java.util.stream.Collectors;

public class Item2418 {

    /*
    按身高排序

     */

    public String[] sortPeople(String[] names, int[] heights) {

        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < heights.length; i++){
            map.put(heights[i],names[i]);
        }
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        List<Map.Entry<Integer, String>> collect = entries.stream().sorted(new Comparator<Map.Entry<Integer, String>>() {
            @Override
            public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
                return o2.getKey() - o1.getKey();
            }
        }).collect(Collectors.toList());

        List<String> list = new ArrayList<>();
        for (Map.Entry<Integer,String> entry : collect){
            list.add(entry.getValue());
        }

        String[] strings = list.toArray(new String[list.size()]);
        return strings;

    }

    public String[] sortPeople2(String[] names, int[] heights){
        int n = names.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i <n; i++){
            indices[i] = i;
        }
        Arrays.sort(indices,(a,b)->heights[b] - heights[a]);
        String[] res = new String[n];
        for (int i = 0; i <n; i++){
            res[i] = names[indices[i]];
        }
        return res;
    }

}
