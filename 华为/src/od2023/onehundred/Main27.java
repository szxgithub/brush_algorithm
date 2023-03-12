package od2023.onehundred;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main27 {

    /*

    核酸检测人员安排

    在系统、网络均正常的情况下组织核算采样，采样效率为N人/小时
    由于外界变化，效率会以M人/小时为粒度发生变化， M = N*10%， 输入保证N*10%的结果为整数，

    采样员需要一名志愿者协助才能正常发挥效率，在此基础上每增加一名志愿者，效率提升1M,最多提升3M，如果没有志愿者协助，效率下降2M


    求怎么安排速度最快？  总最快检测效率，为各采样人员效率值相加

    输入描述:
        采样人员数、志愿者人数
        各采样人员基准效率值
    输出描述：
        总最快检测效率

     */

    /*
    动态规划解法
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //采样员数量
        int N = sc.nextInt();
        //志愿者数量
        int V = sc.nextInt();

        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();     //采集员采样效率
        }

        int[] arrM = new int[N];
        for (int i = 0; i < N; i++) {
            arrM[i] = nums[i]/10;       //采集员浮动效率
        }

        int count = 0;
        // dp[i][j]表示 前i个采样员，搭配j个志愿者的最大效率
        int[][] dp = new int[N+1][V+1];
        for (int i = 1; i < N+1; i++) {
            count += (nums[i-1] - 2*arrM[i-1]);
            dp[i][0] = count;   //没有志愿者的采集员采样效率
        }

        for (int i = 1; i < N+1; i++) {     //采集员数量
            for (int j = 1; j < V+1; j++) {     //志愿者数量
                dp[i][j] = Math.max( dp[i-1][j]+nums[i-1]-2*arrM[i-1], dp[i-1][j-1]+nums[i-1]);     //志愿者大于等于1
                dp[i][j] = Math.max( dp[i][j], j-2 >= 0 ? dp[i-1][j-2]+nums[i-1]+arrM[i-1] : 0);    //志愿者大于等于2
                dp[i][j] = Math.max( dp[i][j], j-3 >= 0 ? dp[i-1][j-3]+nums[i-1]+2*arrM[i-1] : 0);  //志愿者大于等于3
                dp[i][j] = Math.max( dp[i][j], j-4 >= 0 ? dp[i-1][j-4]+nums[i-1]+3*arrM[i-1] : 0);  //志愿者大于等于4（题目强调最多提示3M）
            }
        }

        System.out.println(dp[N][V]);
    }

    /**
     *
     * 逻辑分析
     * 利用一个优先队列解法
     *
     * @param arr
     * @param x  采样员人数
     * @param y  志愿者人数
     * @return
     */
    public int getResult(Integer[] arr, int x, int y){
        //堆按增加一个志愿者，提升效率最多降序排列
        PriorityQueue<Sampler> pq  = new PriorityQueue<>((a,b)-> (int) (getAdd(b) - getAdd(a)));
        for (int base : arr){
            pq.offer(new Sampler(0,base));
        }

        while (y > 0){
            if (pq.isEmpty() || pq.peek().volunteer == 4){
                break;
            }

            Sampler poll = pq.poll();
            poll.total += getAdd(poll);
            poll.volunteer += 1;

            pq.offer(poll);
            y--;
        }

        double ans = 0;

        while (!pq.isEmpty()){
            ans += pq.poll().total;
        }

        return (int)ans;
    }

    /*
    增加一名志愿者能提升的效率
     */
    public double getAdd(Sampler sampler){
        if (sampler.volunteer == 0){
            return sampler.base*0.2;
        }else if (sampler.volunteer <= 3){
            return sampler.base*0.1;
        }else {
            return 0;
        }
    }

    class Sampler{
        int volunteer = 0;
        double base = 0;
        double total = 0;
        public Sampler(int volunteer, double base){
            this.volunteer = volunteer;
            this.base = base;
            // 初始时没有搭配志愿者，效率
            this.total = base*0.8;
        }
    }



}
