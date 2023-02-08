package od2023;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main61 {

    /*
    计算至少需要多少个快递主站点
     */

    /*
    回溯方法
     */
    public static int[][] s;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        s = new int[N][N];

        for (int i =0; i<N; i++){
            for (int j = 0; j<N; j++){
                s[i][j] = sc.nextInt();
            }
        }

        // 已有连通的站点
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int i = 0; i<N; i++){
            // 站点已有连通，无需处理
            if (set.contains(i)){
                continue;
            }
            // 相互连通站点的集合
            Set<Integer> temp = new HashSet<>();
            temp.add(i);
            dfs(temp,i);
            set.addAll(temp);
            res++;
        }
        System.out.println(res);

    }

    private static void dfs(Set<Integer> set, int index) {

        for (int i =0; i<s.length; i++){
            if (set.contains(i)){
                continue;
            }
            if (index != i && s[index][i] == 1 ){
                set.add(i);
                dfs(set,i);
            }
        }

    }


    /*
        并查集思想
     */
    public static void main2(){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        s = new int[N][N];
        for (int i =0; i<N; i++){
            for (int j = 0; j<N; j++){
                s[i][j] = sc.nextInt();
            }
        }

        int[] roots = new int[N];
        for (int i = 0; i < N; i++) {
            roots[i] = i;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(s[i][j] == 1){
                    union(roots,i,j);
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(findRoot(roots,i));
        }
        System.out.println(set.size());
    }

    public static int findRoot(int[] roots,int a){
        if(roots[a] == a){
            return a;
        }else {
            return findRoot(roots,roots[a]);
        }
    }
    public static void union(int[] roots,int a,int b){
        int root_a = findRoot(roots,a);
        int root_b = findRoot(roots,b);
        roots[root_a] = root_b;
    }

}
