package middle;

public class Item1039 {

    /*
    多边形三角剖分的最低得分

     */
    private int n;
    private int[] values;
    //用于记忆化搜索
    private int[][] f;
    public int minScoreTriangulation(int[] values) {
        n = values.length;
        this.values = values;
        f = new int[n][n];
       return dfs(0,n-1);
    }

    private int dfs(int i, int j) {
        if (i + 1 == j){
            return 0 ;
        }
        if (f[i][j] != 0){
            return f[i][j];
        }
        int ans = 1<<30;
        for (int k = i+1; k <j;k++){
            ans = Math.min(ans,dfs(i,k) + dfs(k,j) + values[i]*values[k]*values[j]);
        }
        return f[i][j] = ans;
    }

    public static void main(String[] args) {
        Item1039 item1039 = new Item1039();
        int[] values = {1,3,1,4,1,5};
        int i = item1039.minScoreTriangulation(values);
        System.out.println(i);
    }

}
