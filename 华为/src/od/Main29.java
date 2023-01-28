package od;

import java.util.*;

public class Main29 {

    /**
     *
     * 最大N个数与最小N个数的和
     *
     * 输入
     * 5
     * 95 88 83 64 100
     * 2
     * 输出
     * 342
     *
     * 输入
     * 5
     * 3 2 3 4 2
     * 2
     * 输出
     * -1
     *
     *
     * */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();

        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i= 0; i<M; i++) {
            int tmp = sc.nextInt();
            treeSet.add(tmp);
        }

        int N = sc.nextInt();

        int ans = 0;

        if(treeSet.size() < N*2){
            ans += -1;
        }else {
            for (int i = 0; i <N;i++){
                ans += treeSet.pollFirst() + treeSet.pollLast();
            }
        }

        System.out.println(ans);

    }

}
