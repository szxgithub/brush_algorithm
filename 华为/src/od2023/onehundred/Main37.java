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
                    clearHappy(i,j);
                    res++;
                }
            }
        }

        System.out.println(res);

    }

    private static void clearHappy(int i, int j) {

        if (i > 0){
            if (matrix[i-1][j] == 1){
                matrix[i-1][j] = 0;
                clearHappy(i-1,j);
            }
            if (j > 0){
                if (matrix[i-1][j-1] == 1){
                    matrix[i-1][j-1] = 0;
                    clearHappy(i-1,j-1);
                }
            }
            if (j < M-1){
                if (matrix[i-1][j+1] == 1){
                    matrix[i-1][j+1] = 0;
                    clearHappy(i-1,j+1);
                }
            }
        }

        if (i < N-1){
            if (matrix[i+1][j] == 1){
                matrix[i+1][j] = 0;
                clearHappy(i+1,j);
            }
            if (j > 0){
                if (matrix[i+1][j-1] == 1){
                    matrix[i+1][j-1] = 0;
                    clearHappy(i+1,j-1);
                }
            }
            if (j < M-1){
                if (matrix[i+1][j+1] == 1){
                    matrix[i+1][j+1] = 0;
                    clearHappy(i+1,j+1);
                }
            }
        }

        if (j > 0){
            if (matrix[i][j-1] == 1){
                matrix[i][j-1] = 0;
                clearHappy(i,j-1);
            }
        }

        if (j < M-1){
            if (matrix[i][j+1] == 1){
                matrix[i][j+1] = 0;
                clearHappy(i,j+1);
            }
        }

    }

    /*

    也可以用并查集解决
     */
    public int getResult(int[][] martix, int n, int m){
        UnionFindSet ufs = new UnionFindSet(n*m);
        Integer[][] offsets = {{-1,-1},{-1,0},{-1,1},{0,-1},
                                {0,1},{1,-1},{1,0},{1,1}};

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
