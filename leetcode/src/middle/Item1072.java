package middle;

import java.util.HashMap;
import java.util.Map;

public class Item1072 {

    /*
    按列翻转得到最大值等行数
     */

    public int maxEqualRowsAfterFlips(int[][] matrix){
        Map<String,Integer> cnt = new HashMap<>();
        int ans = 0, n = matrix[0].length;
        for (int[] row : matrix){
            char[] cs = new char[n];
            for (int i = 0; i <n; i++){
                cs[i] = (char) (row[0]^row[i]);
            }
            ans = Math.max(ans,cnt.merge(String.valueOf(cs),1,Integer::sum));
        }
        return ans;
    }

    public static void main(String[] args) {
        Item1072 item1072 = new Item1072();
        int[][] matrix = {
                {0,1},{1,1}
        };
        int i = item1072.maxEqualRowsAfterFlips(matrix);

        System.out.println(i);
    }

}
