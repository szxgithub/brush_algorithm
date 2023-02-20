package od2022I;

import java.util.Scanner;

public class Main22 {

    /**
     *
     * 服务器广播
     *
     *
     *
     * */

    // 服务器连通对集合
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = 0, num = 0;

        String[] s = sc.nextLine().split(" ");//获取每行的数据
        size = s.length;//一行有几列

        int[][] gbs = new int[size][size];
        for(int i=0;i<size;i++){
            gbs[0][i] = Integer.valueOf(s[i]);
        }

        for(int i=1;i<size;i++){
            for(int j=0;j<size;j++){
                gbs[i][j] = sc.nextInt(); //将数据保存至二维数组
            }
        }

        System.out.println(find(gbs));
    }
    public static int find(int[][] gbs) {
        int length = gbs.length;
        boolean[] visited = new boolean[length];
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (!visited[i]) {
                dfs(gbs, visited, i);
                count++;
            }
        }
        return count;
    }

    public static void dfs(int[][] gbs, boolean[] visited, int i) {
        for (int j = 0; j < gbs.length; j++) {
            if (gbs[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(gbs, visited, j);
            }
        }
    }
}
