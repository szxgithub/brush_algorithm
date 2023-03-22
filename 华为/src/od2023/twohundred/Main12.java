package od2023.twohundred;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main12 {

    /*

    查找树中元素
    根据输入的坐标x,y，将查询到的内容输出，{内容}，若查不到，输出{}
    其中x表示节点所在的层数，根节点位于第0层，根节点的子节点位于第1层，依次类推，从左到右，第一个节点偏移0，第二个节点偏移1，依次类推

    输入描述：
        先录入节点数量
        然后逐行录入节点
        最后录入查询的位置
    输出描述：
        查询到内容时，输出{内容}，若查不到，输出{}

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


    /*

    这道题是个多叉树

    通过深度优先搜索 求出所有数据加入集合中，再求出集合中索引为y的值
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 节点的数量
        int size = Integer.parseInt(sc.nextLine());

        // 输入每行的节点
        int[][] nodes = new int[size][];
        for (int i = 0; i<nodes.length; i++){
            nodes[i] = parseOneLine(sc.nextLine());
        }

        // 要查询的位置
        int[] xy = parseOneLine(sc.nextLine());

        String result = doQuery(nodes,xy[0],xy[1]);
        System.out.println(result);

    }


    /**
     *
     * @param nodes
     * @param x  要查询的节点的层数
     * @param y  要查询的节点在x层内的偏移
     * @return
     */
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
     * 这里采用DFS搜索
     * 求出n层所有数据并加入list集合中
     *
     * @param nodes  节点信息的二维数组
     * @param index 子节点的索引
     * @param n     树的层数 (层数递减)
     * @param list  所求层的数据集合
     */
    private static void handle(int[][] nodes, int index, int n, List<Integer> list){

        // 取出index层的节点
        int[] node = nodes[index];

        // 表示已经找到目标层次了
        if (n == 0){
            list.add(node[0]);
            return;
        }

        // 说明index层只有一个节点，且该节点没有子节点
        if (node.length == 1){
            return;
        }

       // 各数组中下标为0的元素代表其值 后面的代表子节点， 所以从1开始遍历
        for (int i = 1; i < node.length; i++){
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
