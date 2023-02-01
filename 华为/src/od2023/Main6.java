package od2023;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.ToIntFunction;

public class Main6 {

    /*

    查找树中元素

    根据输入的坐标，将查询到的内容输出，{内容}，若查不到，输出{}

     通过回溯法求出所有数据加入集合中，再求出集合中索引为y的值

    输入：
    6
    10 1 2
    -21 3 4
    23 5
    14
    35
    66
    1 1
    输出：{23}



     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int size = Integer.parseInt(sc.nextLine());

        int[][] nodes = new int[size][];

        for (int i = 0; i<nodes.length; i++){
            nodes[i] = parseOneLine(sc.nextLine());
        }

        int[] xy = parseOneLine(sc.nextLine());
        String result = doQuery(nodes,xy[0],xy[1]);
        System.out.println(result);

    }

    private static String doQuery(int[][] nodes, int x, int y) {

        if (x < 0 || y < 0){
            return "{}";
        }

        //存放所求层的数据集合
        List<Integer> list = new ArrayList<>();
        // 从根节点索引开始
        handle(nodes,0,x,list);

        // 层数节点数超出所求坐标范围
        if ( y >= list.size()){
            return "{}";
        }

        return "{" + list.get(y) + "}";
    }

    /**
     *
     * 求出n层所有数据并加入list集合中
     *
     * @param nodes  节点信息的二维数组
     * @param index 子节点的索引
     * @param n     树的层数 (层数递减)
     * @param list  所求层的数据集合
     */
    private static void handle(int[][] nodes, int index, int n, List<Integer> list){

        int[] node = nodes[index];

        // 表示已经找到目标层次了
        if (n == 0){
            list.add(node[0]);
            return;
        }

        // 说明没有子节点
        if (node.length == 1){
            return;
        }

        for (int i = 1; i < node.length; i++){
            // 各数组中的0元素代表其值 后面的代表子节点， 所以从1开始遍历
            handle(nodes,node[i],n-1,list);
        }

    }

    private static int[] parseOneLine(String nextLine) {

        ByteArrayInputStream stream = new ByteArrayInputStream(nextLine.getBytes(StandardCharsets.UTF_8));

        Scanner in = new Scanner(stream);

        List<Integer> list = new ArrayList<>();

        while (in.hasNext()){
            list.add(in.nextInt());
        }
        return list.stream().mapToInt(value -> value).toArray();
    }


}
