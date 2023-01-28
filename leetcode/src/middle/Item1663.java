package middle;

import java.util.Arrays;

public class Item1663 {

    /*
    *
    * 具有给定数值的最小字符串
    *
    *
    *
    * */

    public String getSmallestString(int n, int k){

        char[] ans = new char[n];

        Arrays.fill(ans,'a');

        int i = n-1;
        int d = k - n;

        for (;d > 25; d-=25){
            ans[i--] = 'z';
        }

        ans[i] = (char)('a' + d);
        return String.valueOf(ans);

    }

    public static void main(String[] args) {

        Item1663 item1663 = new Item1663();

        int n = 3, k = 29;

        String smallestString = item1663.getSmallestString(n, k);
        System.out.println(smallestString);

    }

}
