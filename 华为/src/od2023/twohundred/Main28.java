package od2023.twohundred;

import java.util.*;

public class Main28 {

    /*

    快速开租建站
    建站是指在一个全新环境部署一套IT服务
        有一系列部署任务，每个任务部署完成时间都是固定和相等的，设为1
        任务之间可能有依赖
        任务有多个依赖任务，则需要等待依赖任务部署完，才能部署
        没有依赖的任务可以并行部署

    输入描述：
        第一行任务数taskNum
        第二行任务依赖关系数relationsNum
        接下来几行，每行包含两个id,描述一个依赖关系
        依赖之间不会存在环
    输出描述：
        一个整数，表示一个站点的最短开站时间

     */

    /*

    从顶点入度分析
    将入度为0的顶点依次消除，消除的次数就是最短用时

    任务数为n, 顶点编号为[0,n)

     */
    public static int getResult(int[][] relations, int taskNum) {
        HashMap<Integer, ArrayList<Integer>> next = new HashMap<>();
        int[] inDegree = new int[taskNum];

        for (int[] relation : relations) {
            int a = relation[0];
            int b = relation[1];

            next.putIfAbsent(a, new ArrayList<>());
            next.get(a).add(b); // a的下一个顶点有b
            inDegree[b]++; // b顶点的入度++
        }

        // 新建一个队列，用于存放度为0的顶点
        LinkedList<Integer[]> queue = new LinkedList<>();
        int t = 1;

        for (int i = 0; i < taskNum; i++) {
            if (inDegree[i] == 0) {
                queue.add(new Integer[] {i, t}); // i含义是入度为0的顶点，t含义是该顶点所处建站时间
            }
        }

        while (queue.size() > 0) {
            Integer[] tmp = queue.removeFirst(); // 注意这里为了维持t，一定要使用队列先进先出，出队代表删除某顶点
            int task = tmp[0];
            int time = tmp[1];

            if (next.containsKey(task) && next.get(task).size() > 0) {
                for (Integer nxt : next.get(task)) {
                    // 该顶点被删除，则其后继点的入度值--，若--后入度为0，则将成为新的出队点
                    if (--inDegree[nxt] == 0) {
                        t = time + 1; // 此时建站时间+1
                        queue.add(new Integer[] {nxt, t});
                    }
                }
            }
        }

        return t;
    }

}
