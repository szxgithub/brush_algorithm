package od2023.onehundred;

import javax.swing.*;
import java.util.*;

public class Main73 {

    /*

    统一限载货物数最小值  todo
    火车站货物中转站负责将货物运往仓库，小明在中转战负责调度2K辆中转车（K辆干货，K辆湿货）

    输入描述：
        第一行length供货商的数量
        第二行goods表示供货数数组
        第三行types表示对应货物类型，types[i]等于0表示干货，1代表湿货
        第四行k表示单类中转车数量
    输出描述：
        输出一个整数，表示中转车统一限载货物数

     提示：
        中转车最多跑一趟仓库

    本题可以参考：Leetcode-1723

输入：
4
3 2 6 3
0 1 1 0
2
输出：
6
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 供货商数量
        int n = sc.nextInt();

        // 供货数数组
        int[] goods = new int[n];
        for (int i = 0; i < n; i++) {
            goods[i] = sc.nextInt();
        }

        // 供货货物类型
        int[] types = new int[n];
        for (int i = 0; i < n; i++) {
            types[i] = sc.nextInt();
        }

        // 单类中专车数量
        int k = sc.nextInt();

        System.out.println(getResult(n, goods, types, k));
    }

    /**
     * @param n 供货商数量
     * @param goods 供货数数组
     * @param types 表示对应货物类型，types[i]等于0或者1，其中0代表干货，1代表湿货
     * @param k 表示单类中转车数量
     * @return 中转车的统一限载货物数最小值为多少
     */
    public static int getResult(int n, int[] goods, int[] types, int k) {
        // 干货列表
        ArrayList<Integer> dry = new ArrayList<>();
        // 湿货列表
        ArrayList<Integer> wet = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (types[i] == 0) {
                dry.add(goods[i]);
            } else {
                wet.add(goods[i]);
            }
        }

        return Math.max(getMinMaxWeight(dry, k), getMinMaxWeight(wet, k));
    }

    public static int getMinMaxWeight(ArrayList<Integer> weights, int k) {
        int n = weights.size();

        if (n <= k) {
            return weights.stream().max((a, b) -> a - b).orElse(0);
        }

        weights.sort((a, b) -> b - a);

        // 最小限载货量为最大值，因为小了，就意味着有一家货物会被拆分，不符合题意
        int min = weights.get(0);
        int max = weights.stream().reduce(Integer::sum).get();

        // 根据二分搜索优化查找
        while (min < max) {
            int mid = (min + max) >> 1;

            int[] buckets = new int[k];
            if (check(0, weights, buckets, mid)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        return min;
    }

    /**
     * 能否将单一类型的货物总数 划分到 k个 车中
     * @param index
     * @param weights
     * @param buckets
     * @param limit
     * @return
     */
    public static boolean check(int index, ArrayList<Integer> weights, int[] buckets, int limit) {
        if (index == weights.size()) {
            return true;
        }

        int select = weights.get(index);
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] + select <= limit) {
                buckets[i] += select;
                if (check(index + 1, weights, buckets, limit)) return true;
                buckets[i] -= select;
                if (buckets[i] == 0) return false;
            }
        }

        return false;
    }

    /**
     * 考虑装货顺序
     * 满分100%
     *
     * @param n 供货商数量
     * @param goods  供货数数组
     * @param types  供货类型
     * @param k  中转车数量
     * @return
     */
    public int getResult2(int n, int[] goods, int[] types, int k){
        int minLimit = 0;
        int maxLimit = 0;
        for (int i = 0; i <n; i++){
            minLimit = Math.max(minLimit,goods[i]);
            maxLimit += goods[i];
        }

        while (minLimit <= maxLimit){
            int limit = (minLimit + maxLimit)/2;
            if (canLimit(limit,n,goods,types,k)){
                maxLimit = limit - 1;
            }else {
                minLimit = limit + 1;
            }
        }

        return minLimit;
    }

    /**
     * 判断是否可以完成装载，能完成，说明是一个解
     * @param limit
     * @param n
     * @param goods
     * @param types
     * @param k
     * @return
     */
    public boolean canLimit(int limit, int n, int[] goods, int[] types, int k){
        int dryCarCount  = 0, wetCarCount = 0;
        int dryCarSum = 0, wetCarSum = 0;

        for (int i = 0; i < n; i++){
            if (types[i] == 0){
                if (dryCarSum + goods[i] <= limit){
                    dryCarSum += goods[i];
                }else {
                    if (dryCarCount + 1 == k){
                        return false;
                    }else {
                        dryCarCount += 1;
                        dryCarSum = goods[i];
                    }
                }
            }else {
                if (wetCarSum + goods[i] <= limit){
                    wetCarSum += goods[i];
                }else {
                    if (wetCarCount + 1 == k){
                        return false;
                    }else {
                        wetCarCount += 1;
                        wetCarSum = goods[i];
                    }
                }
            }
        }

        return true;
    }



}
