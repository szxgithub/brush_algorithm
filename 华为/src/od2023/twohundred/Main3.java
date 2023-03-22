package od2023.twohundred;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main3 {

    /*

    任务混部(最大化控制资源成本)

    有taskNum项任务，每个任务都有开始时间startTime、结束时间endTime、并行度parallelism三个属性
    并行度是指这个任务运行时将会占用的服务器数量

    请计算完成一批任务，最少需要多少服务器，从而最大化控制资源成本

    输入描述：
        taskNum
        接下来taskNum行，每行三个数 ，开始时间，结束时间，并行度
    输出描述：
        一个整数，表示最少需要的服务器数量

     */

    /*
    双层循环暴力  可能会超时
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int taskNum = sc.nextInt();
        int[][] tasks = new int[taskNum][3];

        for (int i =0; i<taskNum; i++){
            tasks[i][0] = sc.nextInt(); // 开始时间
            tasks[i][1] = sc.nextInt(); // 结束时间
            tasks[i][2] = sc.nextInt(); // 并行度
        }

        int max = Integer.MIN_VALUE;
        for (int i =0; i<taskNum; i++){
            for (int j = i+1; j <taskNum; j++){
                // 判断是否存在重叠区间
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
    类似求解 最大区间重叠个数的问题
    采用优先队列
     */
    private static int getResult(int[][] ranges) {

        // 先按起始点排序
        Arrays.sort(ranges,(a,b) -> a[0] - b[0]);

        // 存放每个区间的结束位置和权重   按结束位置升序
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

            // 队列中每个数组两个元素，区间的结束位置和并行度
            queue.offer(new Integer[]{end,p});
            sum += p;

            if (sum > max){
                max = sum;
            }
        }

        return max;
    }

}
