package middle;

import easy.Item2303;

import java.util.Arrays;

public class Item1828 {

    /**
     *
     * 统计一个圆中点的数目
     *
     * */

    public int[] countPoints(int[][] points, int[][] queries){

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++){

            int x = queries[i][0];
            int y = queries[i][1];
            int r = queries[i][2];

            for (int j = 0; j < points.length; j++){
                int tmpX = points[j][0];
                int tmpY = points[j][1];

                double sqrt = Math.sqrt(Math.pow(tmpX - x, 2) + Math.pow(tmpY - y, 2));
                if (sqrt <= r){
                    ans[i]++;
                }

            }

        }

        return ans;

    }

    public static void main(String[] args) {

       /* int[][] points = {{1,3},{3,3},{5,3},{2,2}};
        int[][] queries = {{2,3,1},{4,3,1},{1,1,2}};
*/

        int[][] points = {{1,1},{2,2},{3,3},{4,4},{5,5}};
        int[][] queries = {{1,2,2},{2,2,2},{4,3,2},{4,3,3}};


        Item1828 item1828 = new Item1828();
        int[] ints = item1828.countPoints(points, queries);

        System.out.println(Arrays.toString(ints));

    }

}
