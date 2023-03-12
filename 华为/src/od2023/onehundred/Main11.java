package od2023.onehundred;

import java.util.*;

public class Main11 {

    /*

    最小的调整次数

    小A依次执行2n个指令往队列中添加数据 和 移除数据，
    其中n个指令是添加数据（可能从头部添加，也可能从尾部添加），依次添加1-n
        n个指令是移除数据, 移除只能从头部移除
    现要求移除数据顺序为1-n

    指令为：
        “head add x"
        "tail add x"
        "remove"

    用一个双端队列结构

    输入：
    5
    head add 1
    tail add 2
    remove
    head add 3
    tail add 4
    head add 5
    remove
    remove
    remove
    remove
    输出：1

     */

    /*
    逻辑分析
     */
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);

        // n 表示数据的范围
        int n = sc.nextInt();
        sc.nextLine();

        Deque<Integer> deque = new ArrayDeque<>();

        // 调整次数
        int res = 0;
        // 删除的整数 相当于索引
        int index = 1;
        for (int i = 0; i<2*n; i++){
            String[] strings = sc.nextLine().split(" ");
            if (strings.length == 1){
                if (deque.peekFirst() != index){

                    // 移除元素不满足要求，调整队列顺序一次
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
