package od2023;

import java.util.*;

public class Main63 {

    /*
    任务总执行时长

    input：1,2,3
    output:[3, 4, 5, 6]
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
