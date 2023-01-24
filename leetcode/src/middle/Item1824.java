package middle;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Item1824 {

    /**
     *
     * 最少测跳次数
     *
     *
     * */

    public int minSideJumps(int[] obstacles){
        int n = obstacles.length;
        int[][] dis = new int[n][3];
        for (int i = 0; i < n; ++i)
            Arrays.fill(dis[i], n);
        dis[0][1] = 0;
        ArrayDeque q = new ArrayDeque<int[]>();
        q.add(new int[]{0, 1}); // 起点
        for (;;) {
            int[] p = (int[])q.pollFirst();
            int i = p[0], j = p[1], d = dis[i][j];
            if (i == n - 1) return d; // 到达终点
            if (obstacles[i + 1] != j + 1 && d < dis[i + 1][j]) { // 向右
                dis[i + 1][j] = d;
                q.addFirst(new int[]{i + 1, j}); // 加到队首
            }
            for (int k : new int[]{(j + 1) % 3, (j + 2) % 3}) // 枚举另外两条跑道（向上/向下）
                if (obstacles[i] != k + 1 && d + 1 < dis[i][k]) {
                    dis[i][k] = d + 1;
                    q.addLast(new int[]{i, k}); // 加到队尾
                }
        }
    }

    public static void main(String[] args) {

        // int[] obstacles = {0,1,2,3,0};
        // int[] obstacles = {0,1,1,3,3,0};
        int[] obstacles = {0,2,1,0,3,0};
        Item1824 item1824 = new Item1824();
        int i = item1824.minSideJumps(obstacles);
        System.out.println(i);

    }

}
