package od2023.onehundred;

import java.util.*;

public class Main72 {

    /*

    最佳对手

    给定n个队伍的实力值，对其进行两两匹配，两支队伍实力差距在允许的最大差距d内，则可以匹配

    要求在匹配队伍最多的情况下匹配出的各组实力差距的总和最小

    输入描述：
        第一行 n，d  队伍个数n，允许的最大实力差距d
        第二行, n个队伍的实力值空格分割
    输出描述：
        匹配后，各组对战的实力差值的总和，若没有队伍可以匹配，则输出-1

输入：
6 30
81 87 47 59 81 18
输出：
57

     */

    /*
    贪心思维  该算法160分
    分两步：
        从前往后筛选一下符合实力差距的队伍，并求出最短差距和
        从后往前筛选一下符合实力差距的队伍，并求出最短差距和
        取上面两步的最小值

     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int p = scanner.nextInt();
        int[] in = new int[num];
        for (int i = 0; i < num; i++) {
            in[i] = scanner.nextInt();
        }

        // 先排序，方便获取最短差距
        in = Arrays.stream(in).sorted().toArray();

        int result1 = 0;
        for (int i = 0; i < in.length - 1; i++) {
            if (! (in[i + 1] - in[i] > p)) {
                result1 += (in[i + 1] - in[i]);
                i ++;
            }
        }

        int result2 = 0;
        for (int i = in.length - 1; i >= 1; i--) {
            if (! (in[i] - in[i - 1] > p)) {
                result2 += (in[i] - in[i - 1]);
                i --;
            }
        }

        int result = Math.min(result1, result2);
        System.out.println(result == 0 ? -1 : result);
    }

    /*
    本题还可以用DFS搜索
     */

}
