package od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main30 {

    /**
     *
     * 事件推送
     *
     * 同一个数轴X上有两个点的集合A={A1,A2,....} 和 B = {B1,B2,....},A、B已经按照从小到大拍好顺序了
     * A、B均不为空，给定一个距离R(正整数)，列出同时满足如下条件的所有（A , B ）数对
     *
     * 1）A <= B
     *
     * 2）A , B 之间的距离小于等于R
     *
     * 3）在满足1）2）的情况下，每个A 只需输出距离最近的B
     *
     * 4）输出结果按A 从小到大的顺序排序
     *
     * 输入：
     * 4 5 5
     * 1 5 5 10
     * 1 3 8 8 20
     * 输出：
     * 1 1
     * 5 8
     * 5 8
     *
     *
     *
     * */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        int r = sc.nextInt();

        int[] A = new int[m];
        for (int i = 0; i <m; i++){
            A[i] = sc.nextInt();
        }

        int[] B = new int[n];
        for (int i = 0; i < n; i++){
            B[i] = sc.nextInt();
        }

        List<int[]> ans = new ArrayList<>();
        for (int i =0 ; i<A.length; i++){
            for (int j = 0; j < B.length; j++){
                if (A[i] <= B[j] && B[j] - A[i] <= r){
                    int[] tmp = {A[i],B[j]};
                    ans.add(tmp);
                    break;
                }
            }
        }

        for (int[] arr : ans){
            System.out.println(arr[0] + " " + arr[1]);
        }

    }

}
