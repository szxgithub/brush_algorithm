package middle;

import java.util.LinkedList;
import java.util.Queue;

public class Item785 {

    /*

    判断二分图

     */

    // 标记是否是二分图
    public boolean isBipartite = true;
    // false和true表示两种不同的颜色
    public static boolean[] color;
    public static boolean[] visited;
    public boolean isBipartite(int[][] graph){

        visited = new boolean[graph.length];
        color = new boolean[graph.length];
        for (int i = 0; i<graph.length; i++){
            if (!visited[i]){
                traverse(graph,visited,i);
            }
        }
        return isBipartite;
    }

    private void traverse(int[][] graph, boolean[] visited, int index) {

        if (!isBipartite){
            return;
        }

        visited[index] = true;

        for (int i =0; i < graph[index].length; i++){
            if (!visited[graph[index][i]]){
                color[graph[index][i]] = !color[index];
                traverse(graph,visited,graph[index][i]);
            }else {
                if (color[graph[index][i]] == color[index]){
                    isBipartite = false;
                }
            }
        }

    }

    /*

       BFS算法

     */
    public void bfs(int[][] graph, int index){
        Queue<Integer> queue = new LinkedList<>();
        visited[index] = true;
        queue.offer(index);

        while (!queue.isEmpty() && isBipartite){
            Integer poll = queue.poll();
            for (int neighbor : graph[poll]){
                if (!visited[neighbor]){
                    color[neighbor] = !color[poll];
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }else {
                    if (color[neighbor] == color[poll]){
                        isBipartite = false;
                        return;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Item785 item785 = new Item785();

        int[][] graph = {
                {1,3},
                {0,2},
                {1,3},
                {0,2}
        };

        boolean bipartite = item785.isBipartite(graph);
        System.out.println(bipartite);
    }

}
