package od2023.twohundred;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main30 {

    /*
    组装新的数组
    给你一个整数M和数组N，N中的元素为连续整数，要求根据N中的元素组装成新的数组R，规则：
        R中元素总和加起来等于M
        R中的元素可以从N中重复选取
        R中的元素最多只能有1个不在N中，且比N中的数字都要小

    在数组N中任意选取多个元素，同一个元素可以重复选取，只要最终选取的所有元素之和为M，

   输入描述：
    第一行 输入连续数组N，采用空格分隔
    第二行输入数字M
   输出描述：
        输出的是组装办法数量，int类型

输入：
2 3
5
输出：
2

     */

    /*
    使用回溯算法
     */
    public static int M;
    public static int min;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 输入数组N，为连续整数
        String[] strings = sc.nextLine().split(" ");
        M = sc.nextInt();

        Integer[] arr = Arrays.stream(strings).map(Integer::parseInt).toArray(Integer[]::new);

        int result = getResult(arr, M);

        System.out.println(result);
    }

    public static int getResult(Integer[] arr, int m){
        // 排除N数组中比M大的数字， 减少搜索时间复杂度
        Integer[] newArr = Arrays.stream(arr).filter(val -> val <= m).toArray(Integer[]::new);
        min = newArr[0];
        return dfs(newArr,0,0,0);

    }

    /**
     *
     * @param arr  数组元素
     * @param index 选取元素的起始位置
     * @param sum 累加和
     * @param count 组合数量统计
     * @return
     */
    public static int dfs(Integer[] arr,int index,int sum, int count){
        if (sum > M){
            return count;
        }
        if (sum == M || (M - sum < min && M - sum > 0)){
            return ++count;
        }

        // 同一个元素可以重复取
        for (int i = index; i < arr.length; i++){
            sum += arr[i];
            count = dfs(arr,i,sum,count);
        }
        return count;
    }

}
