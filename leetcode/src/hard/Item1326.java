package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Item1326 {

    /*

     灌溉花园的最少水龙头数目

     花园长度为 n，从点 0 开始，到点 n 结束
     花园里总共有n+1个水龙头，分别位于[0,1,...n]

     请你返回可以灌溉整个花园的最少水龙头数目， 如果始终无法灌溉，则返回-1

     */

    public int minTaps(int n, int[] ranges){

        // 土地  index = 0 表示 0-1土地  index = 1表示1-2土地
        int[] land = new int[n];

        for (int i = 0; i< ranges.length; i++){
            int l = Math.max(i-ranges[i],0);
            int r = Math.min(i + ranges[i],n);

            for (int j = l; j < r; j++){
                land[j] = Math.max(land[j],r);
            }
        }

        // 需要的最少水龙头数目
        int cnt  = 0;
        int cur = 0;
        while (cur < n ){
            if (land[cur] == 0){
                return  -1;
            }
            cur = land[cur];
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {

        Item1326 item1326 = new Item1326();
        int n = 5;
        int[] ranges = {3,4,1,1,0,0};
        int i = item1326.minTaps(n, ranges);
        System.out.println(i);

    }

}
