package od2023.twohundred;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main8 {

    /*

    最大平分数组

    给定一个数组nums, 将元素分为若干个组，使得每组和相等，求出满足条件的所有分组中，组内元素和得最小值, 最大的平分组个数

    第一行输入m 接着输入m个数，表示此数组 数据范围 1<=M<=50  1<=nums[i] <= 50


输入：
7
4 3 2 3 5 2 1
输出：4

输入：
9
5 2 1 5 2 1 5 2 1
输出：
4

     */

    /*
    这道题类似
    leetcode698--划分k个子集
    华为机试--叠积木
    华为机试--等和子数组最小和
     */
    public static void main(String[] args) {

       Scanner sc = new Scanner(System.in);
       //m个数
       int m = sc.nextInt();
       int[] ints = new int[m];
       for (int i =0; i<m; i++){
           ints[i] = sc.nextInt();
       }

       List<Integer> collect = Arrays.stream(ints).boxed().collect(Collectors.toList());

       int res = getResult(collect,m);

       System.out.println(res);

    }

    private static int getResult(List<Integer> collect, int m) {

        // 降序排序
        collect.sort((a,b)->b-a);

        int sum = 0;
        for (Integer ele : collect){
            sum += ele;
        }

        while (m >= 1){
            LinkedList<Integer> link_cp = new LinkedList<>(collect);
            // 是否可以划分为K个子集
            if (canPartitionMSubsets(link_cp,sum,m)){
                return m;
            }
            m--;
        }

        return 1;
    }

    /**
     *
     * @param linkCp
     * @param sum
     * @param m  划分成m个子集
     * @return
     */
    private static boolean canPartitionMSubsets(LinkedList<Integer> linkCp, int sum, int m) {

        // 如果不能整除，数组元素之和无法均分
        if (sum % m != 0){
            return false;
        }

        // 可以划分的每个子集之和
        int subSum = sum/m;

        if (subSum < linkCp.get(0)){
            return false;
        }

        // 去除掉不用划分的等于subSum的单个子集和
        while (linkCp.size() > 0 && linkCp.get(0) == subSum){
            linkCp.removeFirst();
            m--;
        }

        // 将剩余数组元素划分到这个m个桶里面
        int[] buckets = new int[m];

        return partition(linkCp,0,buckets,subSum);

    }

    /**
     * 这里采用回溯思想
     * @param linkCp
     * @param index
     * @param buckets
     * @param subSum
     * @return
     */
    private static boolean partition(LinkedList<Integer> linkCp, int index, int[] buckets, int subSum) {

        if (index == linkCp.size()){
            return true;
        }
        Integer select = linkCp.get(index);
        for (int i = 0; i < buckets.length; i++){
            if (i > 0 && buckets[i] == buckets[i-1]){
                continue;
            }
            if (select + buckets[i] <= subSum){
                buckets[i] += select;
                if (partition(linkCp,index + 1, buckets, subSum)){
                    return true;
                }
                buckets[i]-=select;
            }
        }

        return false;

    }


}
