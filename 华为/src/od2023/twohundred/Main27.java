package od2023.twohundred;

import java.util.Arrays;
import java.util.Scanner;

public class Main27 {

    /*

        查找充电设备组合
        充电站，可提供n个充电设备，任意个充电设备组合的输出功率的总和，构成功率集合P的一个元素。
        功率集合P的最优元素，表示最接近充电站最大输出功率p_max的元素

        输入描述：
            第一行为充电设备个数n
            第二行为每个充电设备的输出功率
            第三行为充电站最大输出功率p_max
        输出描述：
            功率集合P的最优元素


     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 充电设备个数
        int n = sc.nextInt();

        int[] p = new int[n];
        for (int i =0; i<p.length; i++){
            p[i] = sc.nextInt();
        }

        // 充电站最大输出功率
        int p_max = sc.nextInt();

        // 求功率集合P的最优元素
        Arrays.sort(p);
        int sum = 0;
        for (int i = 0; i < p.length; i++){
            sum += p[i];
            if (sum > p_max){
                sum -= p[i];
                break;
            }
        }

        System.out.println(sum);

    }

    /*
    通过回溯算法对所有充电设备求和
     */
    public static int p_max;
    public static int max;
    public static void main2(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        String[] strs = sc.nextLine().split(" ");
        p_max = sc.nextInt();

        int[] ints = Arrays.stream(strs).mapToInt(Integer::parseInt).toArray(); //字符串数组转化为正数数组
        int count = Arrays.stream(ints).sum();  //求出数组的总和

        if(count <= p_max){
            System.out.println(count);  //总和小于等于p_max则直接输出总和
        }else {

            dfs(ints, 0, 0);

            System.out.println(max);
        }
    }

    /**
     *  经典的m个数中求n个数的算法（强烈建议大家记住这个算法，很多地方可以套用）
     * @param ints      正数数组
     * @param sum       功率和
     * @param index     索引
     */
    public static void dfs(int[] ints, int sum, int index){
        if (sum >= p_max || index == ints.length){
            if (sum == p_max){
                max = sum;
            }else if (sum < p_max){
                max = Math.max(max,sum);
            }else {
                max = Math.max(max,sum - ints[index-1]);
            }
        }else {
            for (int i =index; i<ints.length; i++){
                sum += ints[i];
                dfs(ints,sum,i+1);
                sum -= ints[i];
            }
        }
    }

}
