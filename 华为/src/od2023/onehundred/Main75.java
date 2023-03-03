package od2023.onehundred;

import java.util.ArrayList;
import java.util.Scanner;

public class Main75 {

    /*

     服务中心选址

     给你一个数组positions,其中position[i] = [left,right]表示第i个区域在街道上的位置，其中left代表区域的左侧起点，right代表区域的右侧终点

     选择最佳的服务中心位置为location，请返回最佳的服务中心位置到所有区域的距离总和的最小值

     输入描述：
        第一行，一个整数N表示区域个数
        后面N行，每行两个整数，表示区域的左右起点终点
     输出描述：
        输出结果为一个整数，表示服务中心位置到所有区域的距离总和的最小值

     */

    /*
    逻辑分析  暴力解法
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // N个区域
        int N = Integer.valueOf(sc.nextLine());

        double[][] regions = new double[N][2];
        for (int i =0; i<N; i++){
            regions[i][0] = sc.nextInt();
            regions[i][1] = sc.nextInt();
        }

        double res = getResult(N,regions);
        System.out.println(Math.round(res));
    }

    private static double getResult(int n, double[][] regions) {

        ArrayList<Double> tmp = new ArrayList<>();
        for (double[] pos : regions){
            tmp.add(pos[0]);
            tmp.add(pos[1]);
        }

        tmp.sort(Double::compareTo);

        double min = tmp.get(0);
        double max = tmp.get(tmp.size() - 1);
        double ans = Double.MAX_VALUE;

        // 遍历最小点和最大点之间的每一个点作为服务中心的地址
        /*
        因为目前这题所给的区域边界都是整数，
        因此根据中位数原则，任意两个整数点的中间点要么是整数，要么是带0.5小数。
        因此服务中心选址位置要么是整数，要么是带0.5的小数，所以在二分查找时，步长选0.5。
         */
        for (double i = min; i<= max; i+=0.5){
            // 求每个服务中心地址到各个区域的距离之和dis
            double dis = 0;
            for (double[] region : regions){
                double l = region[0];
                double r = region[1];
                if (r < i){
                    dis += i - r;
                }else if (i < l){
                    dis += l - i;
                }
            }
            System.out.println(i + "\t" + dis);
            ans = Math.min(ans,dis);
        }

        return  ans;
    }

    /*

        应该采用二分法求解  推荐这个方法

     */
    double getResult2(int n, double[][] regions){

        ArrayList<Double> tmp = new ArrayList<>();

        for (double[] region : regions){
            tmp.add(region[0]);
            tmp.add(region[1]);
        }
        tmp.sort(Double::compareTo);

        double min = tmp.get(0);
        double max = tmp.get(tmp.size() - 1);

        while (min < max){

            double mid = Math.ceil((min + max)/2);

            double midDis = getDistance(mid,regions);
            double midLDis = getDistance(mid - 0.5, regions);
            double midRDis = getDistance(mid + 0.5,regions);

            if (midDis <= midLDis && midDis <= midRDis){
                return midDis;
            }

            if (midDis < midLDis){
                min = mid + 0.5;
                continue;
            }

            if (midDis < midRDis){
                max = mid - 0.5;
            }
        }

        return 0;

    }

    public double getDistance(double t, double[][] regions){
        double dis = 0;
        for (double[] region : regions){
            double l = region[0];
            double r = region[1];
            if (r < t){
                dis += t -r;
            }else if (t < l){
                dis += l - t;
            }
        }
        return dis;
    }

}
