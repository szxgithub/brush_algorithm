package hard;

import java.util.*;

public class Item1210 {

    /*

    穿过迷宫的最少移动次数

     */

    private static int[][] DIRS = {
            {1, 0, 0}, // 向下移动
            {0, 1, 0}, // 向右移动
            {0, 0, 1}  // 旋转
    };

    public int minimumMoves(int[][] grid) {
        int n = grid.length;
        boolean[][][] vis = new boolean[n][n][2];
        ArrayList<int[]> q = new ArrayList<>();
        vis[0][0][0] = true;
        q.add(new int[]{0, 0, 0}); // 初始位置
        for (int step = 1; !q.isEmpty(); ++step) {
            ArrayList<int[]> tmp = q;
            q = new ArrayList<>();
            for (int[] t : tmp) {
                for (int[] d : DIRS) {
                    int x = t[0] + d[0], y = t[1] + d[1], s = t[2] ^ d[2]; // 蛇尾
                    int x2 = x + s, y2 = y + (s ^ 1); // 蛇头
                    if (x2 < n && y2 < n &&
                            !vis[x][y][s] &&
                            grid[x][y] == 0 && grid[x2][y2] == 0 &&
                            (d[2] == 0 || grid[x + 1][y + 1] == 0)) {
                        if (x == n - 1 && y == n - 2){
                            return step; // 此时蛇头一定在 (n-1,n-1)
                        }
                        vis[x][y][s] = true;
                        q.add(new int[]{x, y, s});
                    }
                }
            }
        }
        return -1;
    }

    /**************************BFS解法****************/

    public int minimumMoves2(int[][] grid) {
        int n = grid.length;
        int[][][] dist = new int[n][n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dist[i][j], -1);
            }
        }
        dist[0][0][0] = 0;
        Queue<int[]> queue = new ArrayDeque<int[]>();
        queue.offer(new int[]{0, 0, 0});

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int x = arr[0], y = arr[1], status = arr[2];
            if (status == 0) {
                // 向右移动一个单元格
                if (y + 2 < n && dist[x][y + 1][0] == -1 && grid[x][y + 2] == 0) {
                    dist[x][y + 1][0] = dist[x][y][0] + 1;
                    queue.offer(new int[]{x, y + 1, 0});
                }
                // 向下移动一个单元格
                if (x + 1 < n && dist[x + 1][y][0] == -1 && grid[x + 1][y] == 0 && grid[x + 1][y + 1] == 0) {
                    dist[x + 1][y][0] = dist[x][y][0] + 1;
                    queue.offer(new int[]{x + 1, y, 0});
                }
                // 顺时针旋转 90 度
                if (x + 1 < n && y + 1 < n && dist[x][y][1] == -1 && grid[x + 1][y] == 0 && grid[x + 1][y + 1] == 0) {
                    dist[x][y][1] = dist[x][y][0] + 1;
                    queue.offer(new int[]{x, y, 1});
                }
            } else {
                // 向右移动一个单元格
                if (y + 1 < n && dist[x][y + 1][1] == -1 && grid[x][y + 1] == 0 && grid[x + 1][y + 1] == 0) {
                    dist[x][y + 1][1] = dist[x][y][1] + 1;
                    queue.offer(new int[]{x, y + 1, 1});
                }
                // 向下移动一个单元格
                if (x + 2 < n && dist[x + 1][y][1] == -1 && grid[x + 2][y] == 0) {
                    dist[x + 1][y][1] = dist[x][y][1] + 1;
                    queue.offer(new int[]{x + 1, y, 1});
                }
                // 逆时针旋转 90 度
                if (x + 1 < n && y + 1 < n && dist[x][y][0] == -1 && grid[x][y + 1] == 0 && grid[x + 1][y + 1] == 0) {
                    dist[x][y][0] = dist[x][y][1] + 1;
                    queue.offer(new int[]{x, y, 0});
                }
            }
        }

        return dist[n - 1][n - 2][0];
    }

    public static void main(String[] args) {

        int[][] grid = {
                {0,0,0,0,0,1},
                {1,1,0,0,1,0},
                {0,0,0,0,1,1},
                {0,0,1,0,1,0},
                {0,1,1,0,0,0},
                {0,1,1,0,0,0},
        };

        Item1210 item1210 = new Item1210();
        int i = item1210.minimumMoves2(grid);
        System.out.println(i);
    }

}
