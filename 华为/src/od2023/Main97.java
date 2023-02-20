package od2023;

import java.util.*;

public class Main97 {

    /*

    人数最多的站点

    设计一个程序计算出小火车在哪个园区站点时人数最多



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

        // 输出人数最多时的园区站点编号， 人数最多相同时，返回编号最小的园区站点

        Integer last = Arrays.stream(ranges).map(range -> Math.max(range[0], range[1])).max((a, b) -> a - b).orElse(0);

        // 考虑到可能有[3，2]这种坐车区间，需要拆分为[3,4] 和 [1,2]
        ArrayList<Integer[]> tmp = new ArrayList<>();
        for (int[] range : ranges){
            int s = range[0];
            int e = range[1];

            if (s > e){
                tmp.add(new Integer[]{s,last});
                tmp.add(new Integer[]{1,e});
            }else {
                tmp.add(new Integer[]{s,e});
            }
        }

        // 按起始点进行升序排序
        tmp.sort((a,b) -> a[0] - b[0]);

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int max = 0;
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
            queue.offer(e);
            if (queue.size() > max){
                max = queue.size();
                ans = s;
            }
        }

        System.out.println(ans);

    }

}
