package od2023;

import java.net.ServerSocket;
import java.util.*;

public class Main25 {

    /*

    快速开租建站
     */

    public static Map<Integer, Set<Integer>> map = new HashMap<>();
    public static int res = 1;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 任务数
        int taskNum = sc.nextInt();

        // 任务依赖关系数
        int relationsNum = sc.nextInt();

        // 用来记录需要依赖的服务数
        int[] taskInts = new int[taskNum];

        for (int i =0; i< relationsNum; i++){
            Set<Integer> set;
            int k = sc.nextInt();
            int v = sc.nextInt();

            if (map.containsKey(k)){
                set = map.get(k);
            }else {
                set = new HashSet<>();
            }

            set.add(v);
            map.put(k,set);
            taskInts[v]++;
        }

        // 已经部署的服务
        Set<Integer> taskStart = new HashSet<>();
        // 等待部署的服务
        Set<Integer> taskWait = new HashSet<>();

        for (int i = 0; i < taskNum; i++){
            if (taskInts[i] == 0){
                taskStart.add(i);
            }else {
                taskWait.add(i);
            }
        }

        handle(taskStart,taskWait);

        System.out.println(res);

    }

    private static void handle(Set<Integer> taskStart, Set<Integer> taskWait) {

        // 还有服务等待部署
        if (taskWait.size() != 0){
            // 接下来可以部署的服务
            Set<Integer> temp = new HashSet<>();
            for (int i: taskStart){
                if (map.containsKey(i)){
                    temp.addAll(map.get(i));
                }
            }

            for (int i : map.keySet()){
                if (!taskStart.contains(i)){
                    // 移除那些还需要依赖的服务
                    temp.removeAll(map.get(i));
                }
            }

            taskStart.addAll(temp);
            taskWait.removeAll(temp);
            // 部署过一次
            res++;
            handle(taskStart,taskWait);
        }

    }

}
