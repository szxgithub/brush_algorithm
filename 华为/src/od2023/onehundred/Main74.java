package od2023.onehundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main74 {

    /*

     最多几个直角三角形  todo
     有N条线段，长度分别为a[1] - a[N]
      现在要求你计算这N条线段最多可以组合成几个直角三角形
      每条线段只能使用一次，每个三角形包含三条线段

     输入描述：
        第一行输入正整数T，表示有T组测试数据
        对于每组测试数据，接下来有T行，每行一个整数N，表示线段隔宿，后面接着是N个整数，表示线段长度
     输出描述：
        每组测试数据输出一行，每行包括一个整数，表示最多能组合的直角三角形个数



输入：
1
7 3 4 5 6 5 12 13
输出：
2

1
7 3 4 5 12 13 84 85
2

     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // T组测试用例
        int T = sc.nextInt();
        int[][] cases = new int[T][];

        for (int i = 0; i<T; i++){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j<n; j++){
                arr[j] = sc.nextInt();
            }
            cases[i] = arr;
        }

        getResult(cases);

    }

    private static void getResult(int[][] cases) {

        for (int[] arr : cases){
            Arrays.sort(arr);
            // 所有能组合成直角三角形的组合
            ArrayList<Integer[]> res = new ArrayList<>();

            dfs(arr,0,new LinkedList<>(),res);

            int[] count = new int[100];
            for (int i : arr){
                count[i]++;
            }

            ArrayList<Integer> ans = new ArrayList<>();
            canCombine(res,0,count,0,ans);
            System.out.println(ans.stream().max((a,b) -> a-b).orElse(0));

        }

    }

    /**
     *
     *  求解当前组合中不超用线段数的最多组合数
     *
     * @param res  所有组合结果
     * @param index 起始位置
     * @param count  每个字符出现次数统计
     * @param num  能组合的三角形个数
     * @param ans  存放结果集，包含所有可能组合出来三角形的个数
     */
    private static void canCombine(ArrayList<Integer[]> res, int index, int[] count, int num, ArrayList<Integer> ans) {

        // 扫描完所有的组合结果
        if (index >= res.size()){
            ans.add(num);
            return;
        }

        for (int i = index; i < res.size(); i++){
            Integer[] integers = res.get(i);
            int a = integers[0];
            int b = integers[1];
            int c = integers[2];

            if (count[a] > 0 && count[b] > 0 && count[c] > 0){
                count[a]--;
                count[b]--;
                count[c]--;
                num++;
                canCombine(res,i+1,count,num,ans);
                num--;
                count[a]++;
                count[b]++;
                count[c]++;
            }

        }

        ans.add(num);

    }

    /**
     *
     * 从n个数里面选3个组合
     *
     * @param arr
     * @param index
     * @param path
     * @param res
     */
    private static void dfs(int[] arr, int index, LinkedList<Integer> path, ArrayList<Integer[]> res) {

        if (path.size() == 3){
            if (isRightTriangle(path)){
                res.add(path.toArray(new Integer[3]));
            }
            return;
        }

        for (int i = index; i<arr.length; i++){
            path.add(arr[i]);
            dfs(arr,i+1,path,res);
            path.removeLast();
        }
    }

    public static boolean isRightTriangle(LinkedList<Integer> path){
        int x = path.get(0);
        int y = path.get(1);
        int z = path.get(2);

        return x*x + y*y == z*z;

    }

}
