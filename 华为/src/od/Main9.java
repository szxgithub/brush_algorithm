package od;

import java.util.Arrays;

public class Main9 {

    /**
     *
     * 哥哥弟弟分玩具 弟弟计算玩具重量方法是不带进位的二进制加法
     * 要求兄弟所得玩具重量在弟弟眼中相同 求哥哥最大玩具重量
     *
     *
     *
     *
     *
     *
     * */

    public int abc(int[] nums){

        int n = nums.length;
        int sum = nums[0];

        for (int i = 1;i < n; i++ ){
            sum ^= nums[i];
        }

        if (sum != 0){
            return  -1;
        }

        sum = Arrays.stream(nums).sum();
        int minWeights = Arrays.stream(nums).min().getAsInt();
        return sum - minWeights;

    }

}
