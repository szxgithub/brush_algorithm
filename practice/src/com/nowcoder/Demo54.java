package com.nowcoder;

/**
 *
 * 24点游戏算法
 *
 * 描述
 * 给出4个1-10的数字，通过加减乘除运算，得到数字为24就算胜利,除法指实数除法运算,本题对数字选取顺序无要求，但每个数字仅允许使用一次，且需考虑括号运算
 * 此题允许数字重复，如3 3 4 4为合法输入，此输入一共有两个3，但是每个数字只允许使用一次，则运算过程中两个3都被选取并进行对应的计算操作。
 * 输入描述：
 * 本题有多组案例。对于每组案例读入4个[1,10]的整数，数字允许重复，测试用例保证无异常数字。
 */
import java.util.*;
import java.io.*;
public class Demo54{
    static int[] nums = new int[4];
    static boolean[] visit = new boolean[4];
    static int flag = 0;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String[] a = in.nextLine().split(" ");
            for(int i = 0; i < 4; i ++)
                nums[i] = Integer.parseInt(a[i]);
            dfs(0, 0);
            System.out.println( flag == 1 );
        }

    }

    // tmp是前面n个数字运算结果，u表示已经使用了多少个数字
    static boolean dfs(int u,float tmp){
        // 递归终止条件：已经使用了数组四个元素，同时结果为24，满足题意
        if(tmp == 24 && u == 4){
            flag = 1;
            return true;
        }

        for(int i = 0; i < 4; i ++){
            if(visit[i] == false){
                visit[i] = true;
                // 加减乘除当前数字num[i]
                if( dfs(u + 1, tmp + nums[i]) ||
                        dfs(u + 1, tmp - nums[i])  ||
                        dfs(u + 1,tmp * nums[i]) ||
                        dfs(u + 1, tmp / nums[i])){
                    return true;
                }
                // 相当于回溯
                visit[i] = false;
            }
        }
        return false;
    }
}
/*

import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = br.readLine()) != null) {
            String[] numstrs = str.split(" ");
            int[] nums = new int[4];
            nums[0] = Integer.parseInt(numstrs[0]);
            nums[1] = Integer.parseInt(numstrs[1]);
            nums[2] = Integer.parseInt(numstrs[2]);
            nums[3] = Integer.parseInt(numstrs[3]);
            boolean flag = false;
            for(int i = 0; i < 4; i++) {
                if(is24(nums, 1 << i, nums[i])) {
                    flag = true;
                    break;
                }
            }
            System.out.println(flag);
        }

    }
    private static boolean is24(int[] nums, int stu, int val) {
        if(val == 24) return true;
        else if (stu == 7) return false;
        for(int i = 0; i < 4; i++) {
            int temp = 1 << i;
            if ((temp & stu) == 0) {
                temp |= stu;
                if(is24(nums, temp, val + nums[i])
                   ||is24(nums, temp, val - nums[i])
                   ||is24(nums, temp, val * nums[i])
                   ||(val % nums[i] == 0 && is24(nums, temp, val / nums[i])))
                   return true;
            }
        }
        return false;
    }
}
 */


