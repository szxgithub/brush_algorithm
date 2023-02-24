package od2023.onehundred;

import java.util.*;

public class Main13 {

    /*

    打印文件（打印机队列）

    有5台打印机，每台打印机都有自己的待打印队列，队列中的文件有1-10不同的优先级，其中数字越大优先级越高


    第一行输入事件发生的数量N
    接下来有N行，分别表示发生的事件：
        IN P NUM  表示拥有优先级NUM的文件放到了打印机P的待打印队列中
        OUT P 表示打印机进行了一次文件打印

   输入：
    7
    IN 1 1
    IN 1 2
    IN 1 3
    IN 2 1
    OUT 1
    OUT 2
    OUT 2
   输出：
    3
    4
    NULL

    输入：
    5
    IN 1 1
    IN 1 3
    IN 1 1
    IN 1 3
    OUT 1
    输出：2


     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());

        String[] str = new String[N];
        for (int i =0; i<N; i++){
            str[i] = sc.nextLine();
        }

        int sq = 0;

        // 存放 打印机编号 --- 该打印机中的文件的优先级队列
        HashMap<String, PriorityQueue<int[]>> map = new HashMap<>();
        for (int i =0; i<str.length; i++){
            String[] s = str[i].split(" ");
            if (s.length == 3){
                // new int[]{优先级，文件编号}
                PriorityQueue<int[]> orDefault = map.getOrDefault(s[1], new PriorityQueue<>((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]));
                int NUM = Integer.valueOf(s[2]);
                sq++;
                orDefault.add(new int[]{NUM,sq});
                map.put(s[1],orDefault);
            }else if (s.length == 2){
                PriorityQueue<int[]> ints = map.get(s[1]);
                if (!ints.isEmpty()){
                    int[] poll = ints.poll();
                    System.out.println(poll[1]);
                }else {
                    System.out.println("NULL");
                }
            }
        }

    }

}
