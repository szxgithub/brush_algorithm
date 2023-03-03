package middle;

import java.util.*;

public class Item1135 {

    public int minimumCost(int n, int[][] connections){

        UF uf = new UF(n+1);

        Arrays.sort(connections,(a,b)->a[2]-b[2]);

        // 记录最小生成树的权重之和
        int mst = 0;

        for (int[] edge : connections){
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            if (uf.connected(u,v)){
                continue;
            }
            mst += weight;
            uf.union(u,v);
        }

        // 按理说 uf.count() == 1 说明所有节点被连通
        // 但因为节点 0 没有被使用，所以 0 会额外占用一个连通分量
        return uf.count() == 2 ? mst : -1;
    }

    class UF {
        // 连通分量个数
        private int count;
        // 存储一棵树
        private int[] parent;
        // 记录树的「重量」
        private int[] size;

        // n 为图中节点的个数
        public UF(int n) {
            this.count = n;
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        // 将节点 p 和节点 q 连通
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ)
                return;

            // 小树接到大树下面，较平衡
            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            // 两个连通分量合并成一个连通分量
            count--;
        }

        // 判断节点 p 和节点 q 是否连通
        public boolean connected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }

        // 返回节点 x 的连通分量根节点
        private int find(int x) {
            while (parent[x] != x) {
                // 进行路径压缩
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        // 返回图中的连通分量个数
        public int count() {
            return count;
        }
    }

    /*
    prim算法
     */

    /**
     *
     * @param N  编号从1-N的N个城市
     * @param connections 城市之间的关联
     * @return
     */
    public int minimumCost2(int N, int[][] connections){
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : connections){
            int u = edge[0], v = edge[1], w = edge[2];
            List<int[]> list1 = graph.get(u);
            if (list1 == null){
                list1 = new ArrayList<>();
                graph.put(u,list1);
            }
            list1.add(new int[]{v,w});

            List<int[]> list2 = graph.get(v);
            if (list2 == null){
                list2 = new LinkedList<>();
                graph.put(v,list2);
            }
            list2.add(new int[]{u,w});
        }

        PriorityQueue<int[]> pq =new PriorityQueue<>((a,b) -> a[1] - b[1]);

        boolean[] added = new boolean[N + 1];

        pq.offer(new int[]{1,0});
        int cost = 0;
        for (int k = 0; k<N; k++){
            int[] min = findMin(pq,added);
            if (min == null){
                return -1;
            }

            int node = min[0];
            int dist = min[1];

            cost += dist;
            added[node] = true;

            List<int[]> list = graph.get(node);
            if (list != null){
                for (int[] e : list){
                    pq.offer(e);
                }
            }
        }
        return cost;
    }

    public int[] findMin(PriorityQueue<int[]> pq, boolean[] addedd){
        while (pq.size() > 0){
            int[] n = pq.poll();
            int node = n[0];
            if (!addedd[node]){
                return n;
            }
        }
        return null;
    }

}
