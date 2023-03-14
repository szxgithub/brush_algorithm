package od2023.onehundred;

import java.util.*;

public class Main56 {

    /*

    人数最多的站点
    园区站点编号如1-2-3-4
    通过对公司N个员工调研统计到每个员工的坐车区间，包含前后站点
    设计一个程序计算出小火车在哪个园区站点时人数最多

    输入描述：
        调研员工人数
        每个员工的上车站点 和 下车站点
    输出描述：
        人数最多时园区站点编号，最多人数相同时，返回编号最小的站点


     */

    /*

    最大重叠区间个数问题， 只需要找到具有最大重叠部分区间的起点就是本题的题解

     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 调研员工人数
        int n = Integer.valueOf(sc.nextLine());

        // 每个员工的上车站点 和 下车站点
        int[][] ranges = new int[n][2];
        for (int i =0; i<n; i++){
            ranges[i][0] = sc.nextInt();
            ranges[i][1] = sc.nextInt();
        }

        // 为了解决存在环状区间问题
        Integer last = Arrays.stream(ranges).map(range -> Math.max(range[0], range[1])).max((a, b) -> a - b).orElse(0);

        // 考虑到可能有[3，2]这种坐车区间，需要拆分为[3,4] 和 [1,2]
        ArrayList<Integer[]> tmp = new ArrayList<>();
        for (int[] range : ranges){
            int s = range[0];
            int e = range[1];
            // 说明存在环的情况
            if (s > e){
                tmp.add(new Integer[]{s,last});
                tmp.add(new Integer[]{1,e});
            }else {
                tmp.add(new Integer[]{s,e});
            }
        }

        // 按起始点进行升序排序
        tmp.sort((a,b) -> a[0] - b[0]);

        // 小顶堆中存放区间的结束点，堆中的个数就是重叠区间的个数
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        // 存放最多人数
        int max = 0;
        // 存放最多人数的站点编号
        int ans = tmp.get(0)[0];
        for (Integer[] range : tmp){
            int s = range[0];
            int e = range[1];

            while (queue.size() > 0){
                Integer peek = queue.peek();
                if (peek < s){
                    queue.poll();
                }else {
                    break;
                }
            }
            // 下车站点入队
            queue.offer(e);
            if (queue.size() > max){
                max = queue.size();
                ans = s;
            }
        }

        System.out.println(ans);

    }

}
