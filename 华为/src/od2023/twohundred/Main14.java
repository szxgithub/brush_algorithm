package od2023.twohundred;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main14 {

    /*

    统计差异值大于相似值二元组个数（二进制差异数）

    对于任意两个正整数A和B，定义它们之间的差异值和相似值

    差异值：A,B的二进制的每一位，，对应位置bit值不相同为1，否则为0
    相似值：A，B的二进制的每一位，对应位置的bit值都为1则为1，否则为0

    输入描述：
        一个n，接下来n个正整数
    输出描述：
        满足差异值大于相似值的对数

     */

    /*
    暴力求解 逻辑非常简单 时间复杂度O(n^2)
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i< nums.length; i++){
            nums[i] = sc.nextInt();
        }

        List<int[]> list = new ArrayList<>();
        for (int i =0 ;i < nums.length; i++){
            for (int j = i+1; j < nums.length; j++){
                // 异或运算
                int chayi = nums[i]^nums[j];
                // 与运算
                int xiangsi = nums[i]&nums[j];
                if (chayi > xiangsi){
                    list.add(new int[]{i,j});
                }
            }
        }

        System.out.println(list.size());

    }

    /*
    优化时间复杂度解法
     */
    public int getResult(int[] arr){
        // highBit[i] 代表最高位1处于第i位的元素的个数
        int[] highBit = new int[60];

        for (int a : arr){
            String s = Integer.toBinaryString(a);
            int len = s.length();
            if ("0".equals(s)){
                highBit[0]++;
            }else {
                highBit[len]++;
            }
        }

        int ans = 0;
        for (int i = 0; i < highBit.length; i++){
            for (int j = i + 1; j < highBit.length; j++){
                ans += highBit[i]*highBit[j];
            }
        }
        return ans;
    }

}
