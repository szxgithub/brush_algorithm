package od2023.onehundred;

import java.util.*;

public class Main72 {

    /*

    最佳对手

    给定n个队伍的实力值，对其进行两两匹配，两支队伍实力差距在允许的最大差距d内，则可以匹配

    要求在匹配队伍最多的情况下匹配出的各组实力差距的总和最小

    输入描述：
        第一行 n，d  队伍个数n，允许的最大实力差距d
        第二行, n个队伍的实力值空格分割
    输出描述：
        匹配后，各组对战的实力差值的总和，若没有队伍可以匹配，则输出-1

    输入：
    6 30
    81 87 47 59 81 18
    输出：
    57

     */

    /*
    贪心思维
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();

        int[] arr = new int[n];
        for (int i= 0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }

        int res = getResult(arr,n,d);

        System.out.println(res);
    }

    private static int getResult(int[] arr, int n, int d) {

        Arrays.sort(arr);

        ArrayList<Integer[]> diffs = new ArrayList<>();

        for (int i = 1; i < arr.length; i++){
            int diff = arr[i] - arr[i-1];
            if (diff <= d){
                diffs.add(new Integer[]{i-1,i,diff});
            }
        }

        if (diffs.size() == 0){
            return -1;
        }

        ArrayList<Integer[]> res = new ArrayList<>();
        dfs(diffs,0,new LinkedList<>(),res);

        // 匹配队伍数量相同时，按实力差距总和升序排序
        res.sort((a,b) -> Objects.equals(a[0],b[0]) ? a[1] - b[1] : b[0] - a[0]);

        return res.get(0)[1];

    }

    /*
    组合之间进行搜索  再次组合
     */
    public static void dfs(List<Integer[]> diffs, int index, LinkedList<Integer[]> path,List<Integer[]> res){

        for (int i = index; i < diffs.size(); i++){
            if (path.size() == 0 || path.getLast()[1] < diffs.get(i)[0]){
                path.add(diffs.get(i));
                dfs(diffs,i+1,path,res);

                // 匹配的队伍数量
                int count = path.size();
                // 求组合的实力差值之和
                int sumDiff = path.stream().map(e -> e[2]).reduce((p,c) -> p + c).orElse(0);

                res.add(new Integer[]{count,sumDiff});
                path.removeLast();
            }
        }

    }

}
