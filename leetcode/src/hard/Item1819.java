package hard;

import java.util.Arrays;

public class Item1819 {


    public int countDifferentSubsquenceGCDs(int[] nums){

        int ans = 0, max = 0;
        max = Arrays.stream(nums).max().getAsInt();

        boolean[] has = new boolean[max + 1];

        for (int i = 0; i < nums.length; i++){
            int num = nums[i];
            has[num] = true;
        }

        // 枚举i的倍数
        for (int i = 1; i<= max; i++){
            // 0 和任何数 x 的最大公约数都是 x
            int g = 0;
            for (int j = i; j <= max && g != i;j += i){
                if (has[j]){
                    g = gcd(g,j);
                }
            }
            if (g == i){
                ans++;
            }
        }

        return ans;

    }

    private int gcd(int a, int b) {

        while (a != 0){
            int tmp = a;
            a = b%a;
            b = tmp;
        }

        return b;
    }


}
