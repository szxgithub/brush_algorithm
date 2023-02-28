package easy;

import java.util.*;

public class Item2363 {

    /*

    合并相似的物品


     */

    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2){

        Map<Integer,Integer> map = new TreeMap<>();
        for (int i = 0; i<items1.length; i++){
            map.put(items1[i][0],map.getOrDefault(items1[i][0],0) + items1[i][1]);
            // map.merge(items1[i][0],items1[i][1],Integer::sum);
        }

        for (int i = 0; i<items2.length; i++){
            map.put(items2[i][0],map.getOrDefault(items2[i][0],0) + items2[i][1]);
            // map.merge(items2[i][0],items2[i][1],Integer::sum);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            res.add(new ArrayList<>(Arrays.asList(entry.getKey(),entry.getValue())));
        }

        return res;
    }

    public static void main(String[] args) {

        int[][] items1 = {{1,1},{4,5},{3,8}};
        int[][] items2 = {{3,1},{1,5}};

        Item2363 item2363 = new Item2363();
        List<List<Integer>> lists = item2363.mergeSimilarItems(items1, items2);
        System.out.println(lists);

    }

}
