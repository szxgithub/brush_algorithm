package od2022I;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main95 {

    /*

    任务混部(最大化控制资源成本)

    有taskNum项任务，每个任务都有开始时间startTime、结束时间endTime、并行度parallelism三个属性

    请计算完成一批任务，最少需要多少服务器，从而最大化控制资源成本

     */

    /*
    双层循环暴力  可能会超时
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int taskNum = sc.nextInt();
        int[][] tasks = new int[taskNum][3];

        for (int i =0; i<taskNum; i++){
            tasks[i][0] = sc.nextInt();
            tasks[i][1] = sc.nextInt();
            tasks[i][2] = sc.nextInt();
        }

        int max = Integer.MIN_VALUE;
        for (int i =0; i<taskNum; i++){
            for (int j = i+1; j <taskNum; j++){
                if (tasks[i][1] > tasks[j][0] && tasks[i][0] < tasks[j][0]){
                    max = Math.max(max,tasks[i][2] + tasks[j][2]);
                }else {
                    max = Math.max(max,Math.max(tasks[i][2],tasks[j][2]));
                }
            }
        }

        System.out.println(max);

    }

    /*
    采用优先队列
     */
    public static void main2(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] ranges = new int[n][3];
        for (int i =0; i<n; i++){
            ranges[i][0] = sc.nextInt();
            ranges[i][1] = sc.nextInt();
            ranges[i][2] = sc.nextInt();
        }

        System.out.println(getResult(ranges));

    }

    private static int getResult(int[][] ranges) {

        Arrays.sort(ranges,(a,b) -> a[0] - b[0]);

        PriorityQueue<Integer[]> queue = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        int max = 0;
        int sum = 0;
        for (int[] range : ranges){
            int start = range[0];
            int end = range[1];
            int p = range[2];

            while (queue.size() > 0){
                Integer[] peek = queue.peek();
                if (peek[0] < start){
                    Integer[] poll = queue.poll();
                    sum -= poll[1];
                }else {
                    break;
                }
            }

            queue.offer(new Integer[]{end,p});
            sum += p;

            if (sum > max){
                max = sum;
            }
        }

        return max;
    }

}
