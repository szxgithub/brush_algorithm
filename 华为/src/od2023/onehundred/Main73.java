package od2023.onehundred;

import javax.swing.*;
import java.util.*;

public class Main73 {

    /*

    统一限载货物数最小值
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

    输入：
    4
    3 2 6 3
    0 1 1 0
    2
    输出：
        6


    //todo  这道题挺麻烦
     */

    public static int k;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int len = sc.nextInt();
        int[] goods = new int[len];
        for (int i = 0; i<len; i++){
            goods[i] = sc.nextInt();
        }

        int[] types = new int[len];
        for (int i = 0; i <len; i++){
            types[i] = sc.nextInt();
        }

        k = sc.nextInt();

        List<Integer> listDry = new ArrayList<>();
        List<Integer> listWet = new ArrayList<>();
        int countDry = 0;
        int countWet = 0;
        for (int i = 0; i <len; i++){
            int type = types[i];
            int good = goods[i];
            if (type == 0){
                listDry.add(good);
                countDry += good;
            }else {
                listWet.add(good);
                countWet += good;
            }
        }

        Collections.sort(listDry);
        Collections.sort(listWet);

        int minDry = 0;
        int minWet = 0;
        if (listDry.size() != 0){
            minDry = handle(listDry,countDry);
        }
        if (listWet.size() != 0){
            minWet = handle(listWet,countWet);
        }

        int res = Math.max(minDry,minWet);
        System.out.println(res);

    }

    private static int handle(List<Integer> goodList, int count) {
        // 最重货物
        int maxList = goodList.get(goodList.size()-1);
        // 平均每辆车放置的最低重量
        int minWeight = count%k == 0 ? count/k : count/k + 1;

        int min = Math.max(maxList,minWeight);
        int max = count;

        // 二分搜索法
        while (min < max){
            int mid = (min + max)/2;
            int[] vans = new int[k];
            // 检查使用k辆车，统一限载为mid的情况下，是否可以全部中转完
            if (check(goodList,0,vans,mid)){
                max = mid;
            }else {
                min = mid + 1;
            }
        }

        return min;
    }

    /*
    检查goods货物列表，使用限载为weight的vans辆货车能否全部中转完
     */
    public static boolean check(List<Integer> goods, int index, int[] vans, int weight){
        if (index == goods.size()){
            return true;
        }

        for (int i = 0; i < vans.length; i++){
            if (i > 0 && vans[i] == vans[i-1]){
                continue;
            }
            if (vans[i] + goods.get(index) <= weight){
                vans[i] = vans[i] + goods.get(index);
                if (check(goods,index + 1, vans, weight)){
                    return true;
                }
                vans[i] = vans[i] - goods.get(index);
            }
        }
        return false;
    }

}
