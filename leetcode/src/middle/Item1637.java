package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Item1637 {

    /*

    两点之间不包含任何点的最宽垂直区域


     */

    public int maxWidthOfVerticalArea(int[][] points) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < points.length; i++){
            list.add(points[i][0]);
        }

        list.sort((a,b)->a-b);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i + 1 < list.size(); i++){
            int i1 = list.get(i + 1) - list.get(i);
            max = Math.max(max,i1);
        }

        return max;
    }

    public static void main(String[] args) {
        Item1637 item1637 = new Item1637();
        // int[][] points = {{8,7},{9,9},{7,4},{9,7}};
        int[][] points = {{3,1},{9,0},{1,0},{1,4},{5,3},{8,8}};
        int i = item1637.maxWidthOfVerticalArea(points);
        System.out.println(i);
    }

}
