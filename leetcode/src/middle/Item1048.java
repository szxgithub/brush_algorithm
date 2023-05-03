package middle;

import java.util.*;

public class Item1048 {

    /*
    最长字符串链
     */

    private Map<String,Integer> map = new HashMap<>();
    public int longestStrChain(String[] words){

        for (String str : words){
            map.put(str,0);
        }
        int ans = 0;
        for (String s : map.keySet()){
            ans = Math.max(ans,dfs(s));
        }
        return ans;
    }

    private int dfs(String s){
        int res = map.get(s);
        if (res > 0){
            return res;
        }
        for (int i = 0; i < s.length(); i++){
            String t = s.substring(0,i) + s.substring(i + 1);
            if (map.containsKey(t)){
                res = Math.max(res,dfs(t));
            }
        }
        map.put(s,res + 1);
        return res + 1;
    }

    public static void main(String[] args) {
        Item1048 item1048 = new Item1048();
        String[] words = {"a","b","ba","bca","bda","bdca"};
        int i = item1048.longestStrChain(words);
        System.out.println(i);
    }



}
