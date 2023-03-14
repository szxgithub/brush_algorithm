package od2023.onehundred;

import java.util.*;

public class Main48 {

    /*
    任务总执行时长
    有两种任务，一种执行时长为TaskA，另一种执行时长为TaskB

    请编写一个方法，生成每次编排后的任务所有可能的总执行时长，数组形式返回所有总时长，按从小到大排列

    输入描述：
        第一行输入分别为 第一种任务执行时长taskA，第二种任务执行时长taskB, 这次要编排的任务个数num，以逗号分隔
    输出描述：
        数组形式返回所有总执行时长，需要按从小到大排序


    input：1,2,3
    output:[3, 4, 5, 6]
     */

    /*
    逻辑分析
    只有两个任务，所以可以用一层for循环搞定
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str  = sc.nextLine();
        String[] split = str.split(",");
        int taskATime = Integer.parseInt(split[0]);
        int taskBTime = Integer.parseInt(split[1]);
        int num = Integer.parseInt(split[2]);

        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i<=num; i++){
            int time = i*taskATime + (num - i) * taskBTime;
            set.add(time);
        }

        System.out.println(set);
    }

}
