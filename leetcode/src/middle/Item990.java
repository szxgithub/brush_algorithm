package middle;

import java.util.HashMap;
import java.util.Map;

public class Item990 {

    /*
        等式方程的可满足性

     */

    public boolean equationsPossible(String[] equations){

        UF uf = new UF(26);
        for (String eq : equations){
            if (eq.charAt(1) == '='){
                char x = eq.charAt(0);
                char y = eq.charAt(3);
                uf.union(x - 'a',y-'a');
            }
        }

        for (String eq : equations){
            if (eq.charAt(1) == '!'){
                char x= eq.charAt(0);
                char y = eq.charAt(3);
                if (uf.connected(x - 'a',y-'a')){
                    return false;
                }
            }
        }
        return true;

    }

    class  UF{
        // 记录连通分量个数
        private int count;
        // 存储若干颗树
        private int[] parent;
        // 记录树的重量
        private int[] size;

        public UF(int n){
            this.count = n;
            parent = new int[n];
            size = new int[n];
            for (int i =0; i <n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        public void union(int p, int q){
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ){
                return;
            }
            if (size[rootP] > size[rootQ]){
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            }else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            count--;
        }

        public boolean connected(int p, int q){
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }

        private int find(int x){
            while (parent[x] != x){
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public int count(){
            return count;
        }
    }

    public boolean equationsPossible2(String[] equations){
        Map<Character,Character> father = new HashMap<>();

        // 第一次处理相等的
        for (String s : equations){
            char[] chars = s.toCharArray();
            if (chars[1] == '='){
                char first = chars[0];
                char second = chars[3];
                while (father.containsKey(first)) {
                    first = father.get(first);
                }

                while (father.containsKey(second)){
                    second = father.get(second);
                }
                if (first == second){
                    continue;
                }else {
                    father.put(first,second);
                }
            }
        }

        // 第二次处理不相等的
        for (String s : equations){
            char[] chars = s.toCharArray();
            if (chars[1] == '!'){
                char first = chars[0];
                char second = chars[3];
                while (father.containsKey(first)){
                    first = father.get(first);
                }
                while (father.containsKey(second)){
                    second = father.get(second);
                }
                if (first == second){
                    return false;
                }
            }
        }

        return true;

    }


    public static void main(String[] args) {

        Item990 item990 = new Item990();

        String[] eq = {
                "a==b","b==c","a==c"
        };

        boolean b = item990.equationsPossible(eq);
        System.out.println(b);

    }



}
