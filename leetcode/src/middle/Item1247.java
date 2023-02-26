package middle;

import java.util.Arrays;

public class Item1247 {

    /*
    交换字符使得字符串相同

     */

    public int minimumSwap(String s1, String s2){

        int[] cnt = new int[2];
        int n = s1.length();
        for (int i = 0; i < n; i++){
            if (s1.charAt(i) != s2.charAt(i)){
                cnt[s1.charAt(i)%2]++;
            }
        }
        int d = cnt[0] + cnt[1];
        return d%2 != 0 ? -1:d/2 + cnt[0]%2;
    }

    public static void main(String[] args) {

        Item1247 item1247 = new Item1247();
        String s1 = "xy";
        String s2 = "yx";
        int i = item1247.minimumSwap(s1, s2);
        System.out.println(i);

    }

}
