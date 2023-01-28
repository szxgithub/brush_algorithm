package middle;

import java.util.ArrayList;
import java.util.List;

public class Item1664 {

    /**
     *
     * 生成平衡数组的方案数
     *
     * */

    /**
     *
     * 暴力搜索 超时
     *
     * */
    public int waysToMakeFair(int[] nums){

        int ans = 0;

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i<nums.length; i++){
            list.add(nums[i]);
        }

        for (int i = 0; i<nums.length; i++){
            list.remove(i);

            int evenSum = 0;
            int orderSum = 0;

            for (int j = 0; j<list.size(); j++){
                if (j%2== 0){
                    evenSum += list.get(j);
                }else {
                    orderSum += list.get(j);
                }
            }
            list.add(i,nums[i]);
            if (evenSum == orderSum){
                ans++;
            }
        }

        return ans;

    }


    /**
     *
     * 动态规划
     *
     * */
    public int waysToMakeFair2(int[] nums){
        int[] dp = new int[nums.length + 1];

        // dp[i]表示(0,1,2,3,...i-1)的奇偶数之差
        for (int i = 1; i < dp.length; i++){
            dp[i] = dp[i-1] + ((i&1) == 0 ? nums[i-1] : -nums[i-1]);
        }

        int rev = 0;
        for (int i = 1; i < dp.length; i++){
            if (dp[i-1] == dp[nums.length] - dp[i]){
                rev++;
            }
        }

        return rev;
    }

    public int waysToMakeFair3(int[] nums) {
        int n=nums.length;

        // 创建两个数组， 一个放奇数下标的和 一个放偶数下标的和
        int[] odd=new int[n];
        int[] even=new int[n];
        even[0]=nums[0];
        for(int i=1;i<n;i++){
            if(i%2==0){
                even[i]=even[i-1]+nums[i];
                odd[i]=odd[i-1];
            }else{
                odd[i]=odd[i-1]+nums[i];
                even[i]=even[i-1];
            }
        }
        int res=0;
        for(int i=0;i<n;i++){
            int left_odd=i-1>=0?odd[i-1]:0;
            int left_even=i-1>=0?even[i-1]:0;

            int right_odd=odd[n-1]-odd[i];
            int right_even=even[n-1]-even[i];

            if(left_odd+right_even==left_even+right_odd){
                res++;
            }
        }
        return res;
    }


    public static void main(String[] args) {

        int[] nums = {1,1,1};

        Item1664 item1664 = new Item1664();
        int i = item1664.waysToMakeFair3(nums);
        System.out.println(i);

    }

}
