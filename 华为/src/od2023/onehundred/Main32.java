package od2023.onehundred;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main32 {

    /*
    木板（最短木板长度）
    小明有n块木板，第i块木板长度为ai
    小明买了一块长度为m的木料，这块木料可以任意切割，为了让最短的木板尽量长，请问，加长后的最短木板长度是多少

    加长木板后，最短的木板长度最大可以为多少

    输入：
    5 3
    4 5 3 5 5
    输出：
    5

     */

    /*
    贪心思维
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 木板数
        int n = sc.nextInt();
        // 木料长度
        int m = sc.nextInt();

        int[] wood = new int[n];
        for (int i = 0; i<wood.length; i++){
            wood[i] = sc.nextInt();
        }


        Arrays.sort(wood);

        while (m>0){
            m--;    //木材一段一段的截
            for(int i=1; i<n; i++){
                if(wood[i] > wood[i-1]){
                    wood[i-1] ++;   //碰到比后面的短的就加一截
                    break;
                }
                if(i == n-1){
                    wood[i] ++; //所有木材一样长则在最后一根加一截
                }
            }
        }

        System.out.println(wood[0]);

    }

    /*
    利用优先队列 贪心思维解法
     */
    public int getResult(int m, int[] arr){
        HashMap<Integer,Integer> woods = new HashMap<>();

        for (Integer integer : arr){
            if (woods.containsKey(integer)){
                woods.put(integer,woods.get(integer)+1);
            }else {
                woods.put(integer,1);
            }
        }

        // 按长度升序排序，长度越短，优先级越高
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a,b)->a[0] - b[0]);

        for (Integer wood : woods.keySet()){
            pq.offer(new Integer[]{wood,woods.get(wood)});
        }

        while (m > 0){
            if (pq.size() == 1){
                Integer[] poll = pq.poll();
                int len = poll[0];
                int count = poll[1];
                return len + m/count;
            }

            Integer[] min1 = pq.poll();
            Integer[] min2 = pq.peek();

            int diff =  min2[0] - min1[0];
            int total = diff*min1[1];

            if (total > m){
                return min1[0] + m/min1[1];
            }else if (total == m){
                return min2[0];
            }else {
                m -= total;
                min2[1] += min1[1];
            }
        }

        return pq.peek()[0];
    }




}
