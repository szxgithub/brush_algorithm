package com.leetcode.hot100.middle;

import java.util.*;

public class Item207 {

    /*

        课程表

     */

    public boolean canFinish(int numCourses, int[][] prerequisities){

        // 邻接表的准备  用map构造
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // 事先创建空的
        for (int i = 0; i< numCourses; i++){
            graph.put(i, new LinkedList<>());
        }

        // 存储每个点的度
        int[] inDegrees = new int[numCourses];
        for (int[] node : prerequisities){

            // node[1] -> node[0]
            int cur = node[0];
            int pre = node[1];

            // 入度加1
            inDegrees[cur]++;
            //将邻接点加入
            graph.get(pre).add(cur);
        }

        // 广度优先搜索
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            // 如果度为0，则入队
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            // 队列出队=入度为0的出队
            int node = queue.remove();

            // 课程完成拓扑数-1
            numCourses--;

            for (int next : graph.get(node)) {
                inDegrees[next]--;
                if (inDegrees[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        // 完成拓扑排序的课程数量减0，说明完成所有的先修课程
        return numCourses == 0;

    }

}
