package od2023.onehundred;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main21 {

    /*
    计算至少需要多少个快递主站点（快递业务站）

    快递业务范围有N个站点，如果A-B可达，B-C可达，则A-C可达
    现在给n个站点编号，0,1,...n-1, 用s[i][j]表示i-j可达
    s[i][j] = 1表示可达，为0表示不可达
    用二维数组给定N个站点的可达关系，请计算至少选择几个主站点出发，才能可达所有站点

     */

    /*
    回溯方法
     */
    public static int[][] s;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 站点个数
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
        还可以用并查集思想
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

    public int getResult(int[][] matrix, int n){
        UnionFindSet unionFindSet = new UnionFindSet(n);
        for (int i = 0; i < n; i++){
            for (int j = 0; j<n; j++){
                if (matrix[i][j] == 1){
                    unionFindSet.union(i,j);
                }
            }
        }

        return unionFindSet.count;
    }

    /**
     * 并查集
     */
    class UnionFindSet{
        int[] fa;
        int count;

        public UnionFindSet(int n){
            this.count = n;
            this.fa = new int[n];
            for (int i = 0; i<n; i++){
                this.fa[i] = i;
            }
        }

        public int find(int x){
            if (x != this.fa[x]){
                return this.fa[x] = this.find(this.fa[x]);
            }
            return x;
        }

        public void union(int x, int y){
            int x_fa = this.find(x);
            int y_fa = this.find(y);

            if (x_fa != y_fa){
                this.fa[y_fa] = x_fa;
                this.count--;
            }
        }
    }

}
