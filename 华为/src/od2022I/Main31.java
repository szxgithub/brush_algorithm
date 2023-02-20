package od2022I;

import java.util.Arrays;
import java.util.Scanner;

public class Main31 {

    /***
     *
     *
     * 流水线
     * 输出处理完所有作业的总时长
     *
     * 输入：
     * 3 5
     * 8 4 3 2 10
     * 输出：
     * 13
     *
     * */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 流水线个数
        int m = sc.nextInt();
        // 作业数
        int n = sc.nextInt();
        // 作业数组
        int[] time = new int[n];

        for (int i = 0; i < n; i++){
            time[i] = sc.nextInt();
        }

        // 对作业升序排序
        Arrays.sort(time);

        int ans = 0;
        // 流水线数组
        int[] pipline = new int[m];
        int index = 0;

        // 对作业数进行遍历
        for (int i = 0; i <n; i++){
            int res = Arrays.stream(pipline).min().getAsInt();
            //找出流水线中最短时间线的下标
            for (int j = 0; j<m; j++){
                if (res == pipline[j]){
                    index = j;
                    break;
                }
            }
            pipline[index] += time[i];
        }

        // 获取流水线中最长的时间
        ans = Arrays.stream(pipline).max().getAsInt();

        System.out.println(ans);

    }

}
