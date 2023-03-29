package middle;

import java.util.*;

public class Item1641 {

    /*
     统计字典序元音字符串的数目
     */
    // leetcode刷题 成员变量最好不要定义成static，因为系统静态成员变量可能存放多次测试结果，造成输出结果错误
    private int count;
    public int countVowelStrings(int n) {

        char[] ch = {'a','e','i','o','u'};
        dfs(ch,0,n,new LinkedList<>());
        return count;
    }

    private void dfs(char[] ch, int index, int n, LinkedList<Character> queue) {

        if (queue.size() == n){
            count++;
            return;
        }

        for (int i = index; i<ch.length; i++){
            queue.add(ch[i]);
            dfs(ch,i,n,queue);
            queue.removeLast();
        }
    }

    public static void main(String[] args) {
        Item1641 item1641 = new Item1641();
        int n = 2;
        int i = item1641.countVowelStrings(n);
        System.out.println(i);
    }

}
