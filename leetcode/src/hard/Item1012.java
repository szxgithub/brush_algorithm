package hard;

import java.util.Arrays;
import java.util.HashSet;

public class Item1012 {

    /*
    至少有1位重复的数字
     */

    /*
    暴力搜索 超时 109/129
     */
    public int numDupDigitsAtMostN(int n) {
        int res = 0;
        for (int i = 1; i<=n; i++){
            String s = String.valueOf(i);
            char[] chars = s.toCharArray();
            int[] count = new int[10];
            for (int j = 0; j<chars.length; j++){
                int index = chars[j] - '0';
                count[index]++;
                if (count[index] > 1){
                    res++;
                    break;
                }
            }
        }
        return res;
    }

    //这题涉及数位DP，todo
    public int numDupDigitsAtMostN2(int n) {

        return 0;
    }

}
