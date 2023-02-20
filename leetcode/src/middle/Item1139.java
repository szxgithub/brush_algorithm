package middle;

public class Item1139 {

    /*

    最大的以 1 为边界的正方形
    给你一个由若干 0 和 1 组成的二维网格 grid，请你找出边界全部由 1 组成的最大 正方形 子网格，并返回该子网格中的元素数量。如果不存在，则返回 0。


     */

    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] rs = new int[m][n + 1], cs = new int[n][m + 1];
        for (int i = 0; i < m; ++i){
            for (int j = 0; j < n; ++j) {
                rs[i][j + 1] = rs[i][j] + grid[i][j]; // 每行的前缀和
                cs[j][i + 1] = cs[j][i] + grid[i][j]; // 每列的前缀和
            }
        }

        for (int d = Math.min(m, n); d > 0; --d){
            // 从大到小枚举正方形边长 d
            for (int i = 0; i <= m - d; ++i){
                for (int j = 0; j <= n - d; ++j){
                    // 枚举正方形左上角坐标 (i,j)
                    if (rs[i][j + d] - rs[i][j] == d && // 上边
                            cs[j][i + d] - cs[j][i] == d && // 左边
                            rs[i + d - 1][j + d] - rs[i + d - 1][j] == d && // 下边
                            cs[j + d - 1][i + d] - cs[j + d - 1][i] == d){   // 右边
                        return d * d;
                    }

                }
            }
        }

        return 0;
    }

}
