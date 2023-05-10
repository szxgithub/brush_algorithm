package easy;

import java.util.Arrays;
import java.util.Comparator;

public class Item2432 {

    /*
     处理用时最长的那个任务的员工

     */
    public int hardestWorker(int n, int[][] logs){
        for (int i = logs.length-1; i > 0; i--){
            logs[i][1] = logs[i][1] - logs[i-1][1];
        }
        Arrays.sort(logs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1] == 0 ? o1[0] - o2[0] : o2[1] - o1[1];
            }
        });

        return logs[0][0];
    }

    public static void main(String[] args) {
        Item2432 item2432 = new Item2432();
        int n = 26;
        // int[][] logs = {{0,3},{2,5},{0,9},{1,15}};
        int[][] logs = {{1,1},{3,7},{2,12},{7,17}};
        int i = item2432.hardestWorker(n, logs);
        System.out.println(i);
    }

}
