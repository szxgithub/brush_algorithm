package od2023.twohundred;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main34 {

    /*

    工单调度策略
    当小区通信设备上报时，系统会自动生成待处理的订单

    输入描述：
        第一行为一个整数N，表示工单的数量
        接下来N行，每行包括两个参数之间，工单的SLA时间、该工单的积分

    输出描述：
        输出一个整数，可以获得的最大积分

     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 工单数量
        int n = sc.nextInt();

        // 工单时间和工单积分
        int[][] wos = new int[n][2];
        for (int i = 0; i < n; i++) {
            wos[i][0] = sc.nextInt();
            wos[i][1] = sc.nextInt();
        }

        System.out.println(getResult(n, wos));
    }

    /**
     *
     * 利用一个优先队列
     *
     * @param n 工单数量
     * @param wos 工单的 [SLA, 积分]
     * @return 可以获得的最大积分
     */
    public static int getResult(int n, int[][] wos) {
        // 按时间先后顺序排序
        Arrays.sort(wos, (a, b) -> a[0] - b[0]);
        // 按积分升序 堆顶是积分最小的工单
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);

        // 定义一个当前时间
        int curTime = 0;
        // 记录拿到的积分
        int ans = 0;
        for (int[] wo : wos) {
            int endTime = wo[0];
            int score = wo[1];

            if (endTime >= curTime + 1) {
                pq.offer(score);
                ans += score;
                curTime++;
            } else {
                if (pq.size() == 0) {
                    continue;
                }

                int min_score = pq.peek();
                if (score > min_score) {
                    pq.poll();
                    pq.offer(score);
                    ans += score - min_score;
                }
            }
        }

        return ans;
    }

}
