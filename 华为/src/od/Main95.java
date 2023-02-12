package od;

import java.util.Scanner;

public class Main95 {

    /*

    任务混部
     */

    /*
    双层循环
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

}
