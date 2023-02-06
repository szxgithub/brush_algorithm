package middle;

import java.util.*;

public class Item210 {

    /*

        课程表 II
        返回学完课程所安排的学习顺序，如果不可能，返回一个空数组

     */
    List<Integer> postorder = new ArrayList<>();
    boolean hasCycle = false;
    // 防止重复遍历同一个节点
    boolean[] visited;
    // 记录经过的路径
    boolean[] onPath;
    public int[] findOrder(int numCourses, int[][] prerequisites){

        List<Integer>[] graph = buildGraph(numCourses,prerequisites);
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];

        // 遍历图 因为图中并不是所有节点都相连，所以要用一个 for 循环将所有节点都作为起点调用一次 DFS 搜索算法。
        for (int i = 0; i < numCourses; i++){
            traverse(graph,i);
        }

        // 有环无法进行拓扑排序
        if (hasCycle){
            return new int[]{};
        }

        Collections.reverse(postorder);

        // 逆后序遍历结果即为拓扑排序结果
        int[] res = new int[numCourses];
        for (int i = 0; i< numCourses; i++){
            res[i] = postorder.get(i);
        }

        return res;

    }

    private void traverse(List<Integer>[] graph, int s) {

        if (onPath[s]){
            hasCycle = true;
        }
        if (visited[s] || hasCycle){
            return;
        }

        onPath[s] = true;
        visited[s] = true;
        for (int t : graph[s]){
            traverse(graph,t);
        }

        postorder.add(s);
        onPath[s] = false;

    }

    /*
        采用邻接表存储图
     */
    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {

        List<Integer>[] graph = new LinkedList[numCourses];

        for (int i = 0; i < numCourses; i++){
            graph[i] = new LinkedList<>();
        }

        for (int[] edge : prerequisites){
            int from = edge[1];
            int to = edge[0];
            graph[from].add(to);
        }

        return graph;
    }

    public static void main(String[] args) {

        Item210 item210 = new Item210();

        int numCourses = 4;
        int[][] prerequisites = {
                {1,0},{2,0},{3,1},{3,2}
        };

        int[] order = item210.findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(order));

    }


}
