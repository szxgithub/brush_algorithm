package hard;

public class Item1223 {

    /*

    掷骰子模拟

     */

    /*
    定义状态d[i][j][k]表示已经完成了i次掷骰子，第i次掷的是j，并且连续掷了k次j的合法序列数
     */
    public static final int MOD = 10^9 + 7;
    public int dieSimulator(int n, int[] rollMax) {
        int[][][] d = new int[n+1][6][16];
        for (int j = 0; j< 6; j++ ){
            d[1][j][1] = 1;
        }

        for (int i = 2; i<= n; i++){
            for (int j = 0; j<6; j++){
                for (int k = 1 ;k <= rollMax[j];k++){
                    for (int p = 0; p < 6; p++){
                        if (p != j){
                            d[i][p][1] = (d[i][p][1] + d[i-1][j][k]) % MOD;
                        }else if (k + 1 <= rollMax[j]){
                            d[i][p][k+1] = (d[i][p][k+1] + d[i-1][j][k]) %MOD;
                        }
                    }
                }
            }
        }

        int res = 0;
        for (int j = 0; j <6; j++){
            for (int k = 1;k<= rollMax[j];k++){
                res = (res + d[n][j][k])%MOD;
            }
        }

        return res;
    }

    public static void main(String[] args) {

    }

}
