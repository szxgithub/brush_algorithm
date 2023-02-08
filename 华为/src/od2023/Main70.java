package od2023;

import java.util.*;

public class Main70 {

    /*

    最小的调整次数

    用一个双端队列结构
     */

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        Deque<Integer> deque = new ArrayDeque<>();
        String[] arr = new String[n];

        int res = 0;
        // 删除的整数 相当于索引
        int index = 1;
        for (int i = 0; i<2*n; i++){
            String[] strings = sc.nextLine().split(" ");
            if (strings.length == 1){
                if (deque.peekFirst() != index){

                    Object[] objects = deque.toArray();
                    Arrays.sort(objects);
                    deque.clear();
                    for (int j = 0; j < objects.length; j++){
                        deque.addLast((Integer)objects[j]);
                    }
                    res++;
                }
                deque.pollFirst();
                index++;
            }else {
                int num = Integer.valueOf(strings[2]);
                if (strings[0].equals("head")){
                    deque.addFirst(num);
                }else {
                    deque.addLast(num);
                }
            }
        }
        System.out.println(res);
    }

}
