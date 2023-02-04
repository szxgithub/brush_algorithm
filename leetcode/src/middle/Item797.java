package middle;

import sun.security.krb5.internal.PAData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class Item797 {

    /*

        所有可能的路径

     */

    public static List<List<Integer>> res;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph){

        res = new ArrayList<>();
        TreeMap<Integer,List<Integer>> map = new TreeMap<>();

        dfs(graph,new ArrayList<>(),0);

        return res;

    }

    /*
        dfs暴力搜索  时间复杂度为O(n^2)

     */
    private void dfs(int[][] graph,List<Integer> path, int index) {
        path.add(index);
        if (index == graph.length-1){
            res.add(new ArrayList<>(path));
            return;
        }
        // 递归遍历每个邻接点
        for (int next : graph[index]){
            dfs(graph,path,next);
            path.remove(path.size()-1);
        }

    }

    public static void main(String[] args) {

        Item797 item797 = new Item797();

        int[][] graph = {
                {4,3,1},{3,2,4},{3},{4},{}
        };

        List<List<Integer>> lists = item797.allPathsSourceTarget(graph);

        System.out.println(lists);


    }

}
