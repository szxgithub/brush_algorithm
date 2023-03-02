package od2023.onehundred;

import java.util.HashMap;
import java.util.Scanner;

public class Main25 {
    /*

    机器人活动区域
    现有一个机器人，可放置在MxN的网格

    每个网格都包含一个非负整数编号，当相邻网格的数字编号差值的绝对值小于等于1时，机器人可以在网格间移动
    输出一行，包含一个数字，表示最大活动区域的网格点数目

     */

    public static int M;
    public static int N;
    public static int[][] region;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();

        region = new int[M][N];

        for (int i = 0; i<M; i++){
            for (int j = 0; j<N; j++){
                region[i][j] = sc.nextInt();
            }
        }

        int max = 0;
        for (int i =0; i<M; i++){
            for (int j = 0; j<N; j++){
                if (region[i][j] != -1){
                    int move = move(i, j, region[i][j]);
                    max = Math.max(max,move);
                }
            }
        }

        System.out.println(max);

    }

    public static int move(int row, int col, int val){
        // 越界了，返回0
        if (row < 0 || col <0 || row >= M || col >= M){
            return 0;
        }

        int currentNum = region[row][col];

        if (currentNum == -1 || Math.abs(currentNum - val) > 1){
            return 0;
        }

        // 已经统计过的网格置为-1
        region[row][col] = -1;
        // 符合要求的+1
        int count = 1;
        count += move(row -1,col,currentNum);
        count += move(row+1,col,currentNum);
        count += move(row,col-1,currentNum);
        count += move(row,col+1,currentNum);

        return count;
    }

    /*

    上面的方法采用了DFS，也可也采用并查集，求最大连通分量

     */

    public static int getResult(int[][] matrix, int m, int n) {
        UnionFindSet ufs = new UnionFindSet(m * n);

        // 上下左右的偏移量
        int[][] offsets = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 注意下面这层for是常量级的，就四次循环，因此，这里的时间复杂度还是O(n*m)，即
                for (int[] offset : offsets) {
                    int newI = i + offset[0];
                    int newJ = j + offset[1];

                    if (newI < 0 || newI >= m || newJ < 0 || newJ >= n){
                        continue;
                    }

                    // 当相邻网格的数字编号差值的绝对值小于等于 1 时，机器人可以在网格间移动，即表示网格连通，可以合并
                    if (Math.abs(matrix[i][j] - matrix[newI][newJ]) <= 1) {
                        ufs.union(i * n + j, newI * n + newJ);
                    }
                }
            }
        }

        int total = m * n;

        // ufs.count是连通分量的个数，如果只有一个连通分量，那么代表所有的点都可达
        if (ufs.count == 1) return total;

        // 这个for循环是有必要的，确保每个点都指向祖先
        for (int i = 0; i < total; i++) {
            ufs.find(i);
        }

        // 统计指向同一个祖先下点的个数，即每个连通分量下的点个数
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i : ufs.fa) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }

        // 取最大个数，这里必然有值，因此不需要在get前判空
        return count.values().stream().max((a, b) -> a - b).get();
    }

    // 并查集
    static class UnionFindSet {
        int[] fa;
        // 优化并查集的查找效率
        int[] rank;
        // 连通分量的个数
        int count;

        public UnionFindSet(int n) {
            this.fa = new int[n];
            this.rank = new int[n];
            this.count = n;
            for (int i = 0; i < n; i++){
                this.fa[i] = i;
            }
        }

        public int find(int x) {
            if (x != this.fa[x]) {
                return (this.fa[x] = this.find(this.fa[x]));
            }
            return x;
        }

        public void union(int x, int y) {
            int x_fa = this.find(x);
            int y_fa = this.find(y);

            if (x_fa != y_fa) {

                if (rank[x_fa] > rank[y_fa]){
                    fa[y_fa] = x_fa;
                }else if (rank[x_fa] < rank[y_fa]){
                    fa[x_fa] = y_fa;
                }else {
                    fa[y_fa] = x_fa;
                    rank[x_fa]++;
                }

                this.count--;
            }
        }
    }

}
