package middle;

import java.util.HashSet;
import java.util.Set;

public class Item752 {

    /*

    打开转盘锁


     */


    /*
    双向BFS解法
     */
    public int openLock(String[] deadends, String target){

        Set<String> deads = new HashSet<>();

        for (String s : deadends){
            deads.add(s);
        }

        // 记录已经穷举过的密码，防止走回头路
        Set<String> visited = new HashSet<>();

        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();

        int step = 0;
        q1.add("0000");
        q2.add(target);

        visited.add("0000");

        while (!q1.isEmpty() && !q2.isEmpty()){

            if (q1.size() > q2.size()) {
                // 交换 q1 和 q2
                Set<String> tempQ = q1;
                q1 = q2;
                q2 = tempQ;
            }

            Set<String> temp = new HashSet<>();

            // 将当前队列中的所有节点向周围扩散
            for (String cur : q1){

                if (deads.contains(cur)){
                    continue;
                }

                if (q2.contains(cur)){
                    return step;
                }

                visited.add(cur);

                // 将一个节点的相邻节点加入队列
                for (int j = 0; j < 4; j++){
                    String up = plusOne(cur,j);
                    if (!visited.contains(up)){
                        temp.add(up);
                    }
                    String down = minusOne(cur,j);
                    if (!visited.contains(down)){
                        temp.add(down);
                    }
                }
            }
            step++;
            q1 = q2;
            q2 = temp;
        }
        // 如果穷举完都没有找到目标，那就是找不到了
        return -1;
    }


    private String plusOne(String cur, int j) {

        char[] chars = cur.toCharArray();
        if (chars[j] == '9'){
            chars[j] = '0';
        }else {
            chars[j] +=1;
        }
        return new String(chars);
    }

    private String minusOne(String cur, int j){
        char[] chars = cur.toCharArray();
        if (chars[j] == '0'){
            chars[j] = '9';
        }else {
            chars[j] -= 1;
        }
        return new String(chars);
    }

}
