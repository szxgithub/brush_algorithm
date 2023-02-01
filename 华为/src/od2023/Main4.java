package od2023;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main4 {

    /*

    红黑图

    输入：
    4 3
    0 1
    1 2
    2 3
    输出：
    8

     */

    public static void main(String[] args) {

        Scanner sc  = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();

        // 相连节点的集合
        List<int[]> list = new ArrayList<>();

        for (int i =0; i <m; i++){
            int[] points = new int[2];
            points[0] = sc.nextInt();
            points[1] = sc.nextInt();
            list.add(points);
        }

        // n个节点有2^n个红黑搭配
        int total = (int)Math.pow(2,n);
        int res = total;

        for (int i =0; i < total; i++){
            int temp = i;
            // 0 表示红 1表示黑
            int[] ints =new int[n];
            for (int j = 0; j<n; j++){
                ints[j] = temp%2;
                temp /= 2;
            }

            // 判断每一条边的相连节点
            for (int[] points : list){
                if (ints[points[0]] == 0 && ints[points[1]] == 0){
                    // 相连的节点都是红色，表示不符合
                    res--;
                    break;
                }
            }
        }

        System.out.println(res);

    }

}
