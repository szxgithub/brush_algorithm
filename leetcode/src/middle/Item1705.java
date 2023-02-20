package middle;

import java.util.PriorityQueue;

public class Item1705 {

    /*

    吃苹果的最大数目

    输入：apples = [1,2,3,5,2], days = [3,2,1,4,2]
    输出：7

     */

    public int eatenApples(int[] apples, int[] days){

        int ans = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        int n = apples.length;
        int i = 0;
        while (i < n){
            while (!queue.isEmpty() && queue.peek()[0] <= i){
                queue.poll();
            }
            // 腐烂日期
            int rottenDay = i + days[i];
            // 在该日期腐烂的苹果数
            int count = apples[i];
            if (count > 0){
                queue.offer(new int[]{rottenDay,count});
            }
            if (!queue.isEmpty()){
                int[] arr = queue.peek();
                arr[1]--;
                if (arr[1] == 0){
                    queue.poll();
                }
                ans++;
            }
            i++;
        }

        while (!queue.isEmpty()){
            while (!queue.isEmpty() && queue.peek()[0] <= i){
                queue.poll();
            }
            if (queue.isEmpty()){
                break;
            }
            int[] arr = queue.poll();
            int curr = Math.min(arr[0] - i,arr[1]);
            ans += curr;
            i += curr;
        }

        return ans;
    }

}
