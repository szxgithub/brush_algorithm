package od2023.onehundred;

import java.util.Arrays;
import java.util.Scanner;

public class Main36 {

    /*

    优选核酸检测点

    要求将所有满足条件的核酸监测点按照优选规则排序列出：
    1、花费时间最少的核酸检测点排在前面
    2、花费时间一样，花费费用最少的核酸检测点排在前面
    3、时间费用一样，则ID值最小的排在前面

    输入描述：
        H1 M1  当前时间
        H2 M2  完成时间
        N      检测点个数
        ID1 D1 C1  核算点ID，距离，排队人数
        ID2 D2 C2
        ...
    输出描述：
        N  满足要求的个数
        I2 T2 M3  表示 ID，耗时，花费
        ...

输入：
10 30
14 50
3
1 10 19
2 8 20
3 21 3
输出：
2
2 80 80
1 190 100

     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 当前时间小时分钟数
        int h1 = sc.nextInt();
        int m1 = sc.nextInt();

        // 截至该时间点之前完成核酸检测
        int h2 = sc.nextInt();
        int m2 = sc.nextInt();

        // 所有核酸检测点个数
        int n = sc.nextInt();
        // 核酸检测点ID，检测点距离张三的距离，检测点当前检测人数
        int[][] idcs = new int[n][3];
        for (int i = 0; i < n; i++) {
            // 检测点ID
            idcs[i][0] = sc.nextInt();
            // 检测点距离张三的距离
            idcs[i][1] = sc.nextInt();
            // 检测点当前检测人数
            idcs[i][2] = sc.nextInt();
        }

        getResult(h1, m1, h2, m2, idcs);
    }

    /**
     * @param h1 当前时间的小时数
     * @param m1 当前时间的分钟数
     * @param h2 指定完成核算时间的小时数
     * @param m2 指定完成核算时间的分钟数
     * @param idcs [[核酸点的ID值, 核酸检测点距离张三的距离,核酸检测点当前检测的人数]]
     */
    public static void getResult(int h1, int m1, int h2, int m2, int[][] idcs) {
        int start = h1 * 60 + m1;
        int end = h2 * 60 + m2;

        int[][] ans =
                Arrays.stream(idcs)
                        .map(
                                idc -> {
                                    int id = idc[0];
                                    int distance = idc[1];
                                    int count = idc[2];

                                    int money = distance * 10;  // 每公里花费10元钱
                                    int road = distance * 10; // 花在路上的时间 每公里距离花费时间10分钟
                                    int arrived = start + road; // 到达核酸检测点的时间

                                    // 如果在8：00之前就赶到了，那么其实要等待到8:00才能排队，这里其实花费的时间应该包括等待的时间
                                    if (arrived < 8 * 60) {
                                        arrived = 8 * 60;
                                        road = arrived - start;
                                    }

                                    // 出发时间，到达核酸检测点做核酸的开始时间
                                    int[] ran1 = {start, arrived};

                                    // 和[8:00, 10:00]的交集，每分钟净增2人
                                    int[] ran2 = {8 * 60, 10 * 60};
                                    int add1 = getIntersection(ran1, ran2);
                                    if (add1 != -1) {
                                        count += 2 * add1;
                                    }

                                    // 和[10:00, 12:00]的交集，每分钟净减1人
                                    int[] ran3 = {10 * 60, 12 * 60};
                                    int min1 = getIntersection(ran1, ran3);
                                    if (min1 != -1) {
                                        count -= min1;
                                        count = Math.max(0, count); // 注意至多减到0
                                    }

                                    // 和[12:00, 14:00]的交集，每分钟净增9人
                                    int[] ran4 = {12 * 60, 14 * 60};
                                    int add2 = getIntersection(ran1, ran4);
                                    if (add2 != -1) {
                                        count += 9 * add2;
                                    }

                                    // 和[14:00, 20:00]的交集，每分钟净减1人
                                    int[] ran5 = {14 * 60, 20 * 60};
                                    int min2 = getIntersection(ran1, ran5);
                                    if (min2 != -1) {
                                        count -= min2;
                                        count = Math.max(0, count); // 注意至多减到0
                                    }

                                    return new int[] {id, count + road, money};
                                })
                        .filter(arr -> arr[1] <= end)  //如果做完核酸的时间超过了指定结束时间，则过滤掉
                        .sorted((a, b) -> a[1] != b[1] ? a[1] - b[1] : a[2] != b[2] ? a[2] - b[2] : a[0] - b[0])
                        .toArray(int[][]::new);

        System.out.println(ans.length);
        for (int[] arr : ans) {
            System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);
        }
    }

    // 获取交集长度，如果没有交集返回-1
    public static int getIntersection(int[] ran1, int[] ran2) {
        int s1 = ran1[0], e1 = ran1[1];
        int s2 = ran2[0], e2 = ran2[1];

        if (s1 < s2) {
            if (s2 >= e1) return -1;
            else return Math.min(e1, e2) - s2;
        } else if (s1 > s2) {
            if (s1 >= e2) return -1;
            else return Math.min(e1, e2) - s1;
        } else {
            return Math.min(e1, e2) - s1;
        }
    }

}
