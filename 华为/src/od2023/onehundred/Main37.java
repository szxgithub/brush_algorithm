package od2023.onehundred;

import java.util.Scanner;

public class Main37 {

    /*
    开心消消乐

    给定一个N行M列的二维矩阵，矩阵中的每个位置的数字取值为1或0
    求最少点击几次后，所有数字均为0

    输入：
    4 4
    1 1 0 0
    0 0 0 1
    0 0 1 1
    1 1 1 1
    输出：
    2
     */

    /*
    深度优先搜索
     */
    public static int[][] matrix;
    public static int N;
    public static int M;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        matrix = new int[N][M];
        for (int i =0; i<matrix.length; i++){
            for (int j = 0; j<matrix[i].length; j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        // 求最少点击几次后，所有数字均为0
        int res = 0;
        for (int i = 0; i<N; i++){
            for (int j = 0; j<M; j++){
                if (matrix[i][j] == 1){
                    matrix[i][j] = 0;
                    dfs(i,j);
                    res++;
                }
            }
        }

        System.out.println(res);

    }

    private static void dfs(int i, int j) {

        // 上
        if (i > 0){
            // 正上
            if (matrix[i-1][j] == 1){
                matrix[i-1][j] = 0;
                dfs(i-1,j);
            }
            // 左上
            if (j > 0){
                if (matrix[i-1][j-1] == 1){
                    matrix[i-1][j-1] = 0;
                    dfs(i-1,j-1);
                }
            }
            // 右上
            if (j < M-1){
                if (matrix[i-1][j+1] == 1){
                    matrix[i-1][j+1] = 0;
                    dfs(i-1,j+1);
                }
            }
        }

        // 下
        if (i < N-1){
            // 正下
            if (matrix[i+1][j] == 1){
                matrix[i+1][j] = 0;
                dfs(i+1,j);
            }
            // 左下
            if (j > 0){
                if (matrix[i+1][j-1] == 1){
                    matrix[i+1][j-1] = 0;
                    dfs(i+1,j-1);
                }
            }
            // 右下
            if (j < M-1){
                if (matrix[i+1][j+1] == 1){
                    matrix[i+1][j+1] = 0;
                    dfs(i+1,j+1);
                }
            }
        }

        // 左
        if (j > 0){
            if (matrix[i][j-1] == 1){
                matrix[i][j-1] = 0;
                dfs(i,j-1);
            }
        }

        // 右
        if (j < M-1){
            if (matrix[i][j+1] == 1){
                matrix[i][j+1] = 0;
                dfs(i,j+1);
            }
        }

    }

    /*
    可以发现，只要是不连通的1，包含八个方向，点击任意1，会蔓延到其他1，因此本题重点不是在于哪个1，
    而是有多少块连在一起的1，即孤岛问题，求不连通的岛屿数量。
    也可以用并查集解决
     */
    public int getResult(int[][] martix, int n, int m){
        UnionFindSet ufs = new UnionFindSet(n*m);
        Integer[][] offsets = {{-1,-1}, // 左上
                                {-1,0}, // 正上
                                {-1,1}, // 右上
                                {0,-1}, //左
                                {0,1},  // 右
                                {1,-1}, // 左下
                                {1,0},  // 正下
                                {1,1}}; // 右下

        for (int i = 0; i<n; i++){
            for (int j = 0; j<m;j++){
                if (matrix[i][j] != 1){
                    ufs.count--;
                    continue;
                }
                for (Integer[] integer : offsets){
                    int newI = i + integer[0];
                    int newJ = j + integer[1];
                    if (newI >= 0 && newI <n && newJ >= 0 && newJ < m && martix[newI][newJ] == 1){
                        ufs.union(i*m + j, newI*m + newJ);
                    }
                }
            }
        }

        return ufs.count;
    }
    class UnionFindSet{
        int[] parent;
        // 记录连通分量个数
        int count;
        UnionFindSet(int n){
            this.parent = new int[n];
            for (int i = 0; i<n; i++){
                parent[i] = i;
            }
            this.count = n;
        }

        public void union(int x, int y){
            int x_p = find(x);
            int y_p = find(y);
            if (x_p != y_p){
                parent[x_p] = y_p;
                this.count--;
            }
        }

        public int find(int x){
            if (x != this.parent[x]){
                return this.parent[x] = this.find(parent[x]);
            }
            return x;
        }

    }

}
