package middle;

import java.util.*;

public class Item1129 {

    /*
    颜色交替的最短路径

     */

    private static final int PATH_NUM = 2;

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        //准备工作
        List<List<Integer>> redTargetNodes = new ArrayList<>(n);
        List<List<Integer>> blueTargetNodes = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            redTargetNodes.add(new ArrayList<>());
            blueTargetNodes.add(new ArrayList<>());
        }
        for (int[] redEdge : redEdges) {
            redTargetNodes.get(redEdge[0]).add(redEdge[1]);
        }
        for (int[] blueEdge : blueEdges) {
            blueTargetNodes.get(blueEdge[0]).add(blueEdge[1]);
        }
        int[][] dist = intDist(n);
        return bfs(n, dist, redTargetNodes, blueTargetNodes);
    }

    /**
     * 根据节点数初始化距离矩阵
     *
     * @param nodeNum 节点数
     * @return 初始距离矩阵
     */
    private int[][] intDist(int nodeNum) {
        int[][] dist = new int[PATH_NUM][nodeNum];
        dist[0][0] = 0;
        dist[1][0] = 0;
        for (int i = 1; i < nodeNum; i++) {
            Arrays.fill(dist[0], 1, nodeNum, -1);
            Arrays.fill(dist[1], 1, nodeNum, -1);
        }
        return dist;
    }

    /**
     * bfs 方式寻找最短距离
     *
     * @param nodeNum         节点数
     * @param distanceArr     距离矩阵
     * @param redTargetNodes  可以通过红色边到达的节点
     * @param blueTargetNodes 可以通过蓝色边到达的节点
     * @return 最短路径矩阵
     */
    private int[] bfs(
            int nodeNum,
            int[][] distanceArr,
            List<List<Integer>> redTargetNodes,
            List<List<Integer>> blueTargetNodes) {
        int stepNum = 0;
        Queue<Integer> redStartNodeQueue = new LinkedList<>();
        Queue<Integer> blueStartNodeQueue = new LinkedList<>();
        redStartNodeQueue.offer(0);
        blueStartNodeQueue.offer(0);
        //# step 1 找到分别以红边开始和以蓝边开始的两条最短路径
        while (!redStartNodeQueue.isEmpty() || !blueStartNodeQueue.isEmpty()) {
            stepNum++;
            Queue<Integer> newRedStartNodeQueue = new LinkedList<>();
            Queue<Integer> newBlueStartNodeQueue = new LinkedList<>();
            while (!redStartNodeQueue.isEmpty()) {
                Integer redStartNode = redStartNodeQueue.poll();
                List<Integer> blueTargetNode = blueTargetNodes.get(redStartNode);
                for (int node : blueTargetNode) {
                    if (distanceArr[0][node] == -1) {
                        newBlueStartNodeQueue.offer(node);
                        distanceArr[0][node] = stepNum;
                    }
                }
            }
            while (!blueStartNodeQueue.isEmpty()) {
                Integer blueStartNode = blueStartNodeQueue.poll();
                List<Integer> redTargetNode = redTargetNodes.get(blueStartNode);
                for (int node : redTargetNode) {
                    if (distanceArr[1][node] == -1) {
                        newRedStartNodeQueue.offer(node);
                        distanceArr[1][node] = stepNum;
                    }
                }
            }
            redStartNodeQueue = newRedStartNodeQueue;
            blueStartNodeQueue = newBlueStartNodeQueue;
        }
        return margeDistance(nodeNum, distanceArr);
    }

    /**
     * 合并结果
     *
     * @param nodeNum     节点数
     * @param distanceArr 距离矩阵
     * @return 最短路径矩阵
     */
    private int[] margeDistance(int nodeNum, int[][] distanceArr) {
        int[] result = new int[nodeNum];
        for (int i = 0; i < nodeNum; i++) {
            if (distanceArr[0][i] == -1 && distanceArr[1][i] == -1) {
                result[i] = -1;
            } else if (distanceArr[0][i] != -1 && distanceArr[1][i] != -1) {
                result[i] = Math.min(distanceArr[0][i], distanceArr[1][i]);
            } else {
                result[i] = Math.max(distanceArr[0][i], distanceArr[1][i]);
            }
        }
        return result;
    }

}
