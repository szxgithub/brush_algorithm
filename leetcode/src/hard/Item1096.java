package hard;

import java.util.*;

public class Item1096 {

    /*
    花括号展开 II
     */

    /*
    BFS解法思想
     */
    public List<String> braceExpansionII(String expression){

        LinkedList<String> queue = new LinkedList<>();

        queue.add(expression);

        Set<String> res = new HashSet<>();

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()){
            String poll = queue.poll();
            // 如果队列中的字符串没有花括号处理了，说明处理完了，放入结果集合中
            if (poll.indexOf("{") == -1){
                res.add(poll);
                continue;
            }

            int i = 0;

            // 表达式的一对括号的坐标
            int left = 0;
            int right = 0;

            while (poll.charAt(i) != '}'){
                if (poll.charAt(i) == '{'){
                    left = i;
                }
                i++;
            }
            right = i;

            String before = poll.substring(0,left);

            String after = poll.substring(right + 1);

            String[] strs = poll.substring(left + 1,right).split(",");

            for (String str : strs){
                sb.setLength(0);
                queue.add(sb.append(before).append(str).append(after).toString());
            }
        }

        List<String> ans = new ArrayList<>(res);
        Collections.sort(ans);
        return ans;

    }

}
