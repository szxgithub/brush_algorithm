package od2023.onehundred;

import java.util.*;

public class Main22 {

    /*

    箱子之字形摆放
    有一批箱子按从上到下以之字形的顺序摆放在宽度为n的空地，请输出箱子的摆放位置

    最后一行不要输出额外的空行

    n = 3
    i = 0  i%n = 0
    i = 1 i%n = 1
    i = 2 i%n = 2

    i = 3  n-1-(i%n) = 3-1- 0 = 2
    i= 4   n-1-(i%n) = 3-1 -1 = 1
    i= 5  n-1-(i%n) = 3-1 -2 = 0

    根据上面可得规律：行数为 i%n 或 n-1-(i%n)

    初始 行数 i%n， 每当遇到 i%n == 0 i%n 和 n-1-(i%n) 互相切换使用


    输入：
    ABCDEFG 3
    输出：
    AFG
    BE
    CD
     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] strings = sc.nextLine().split(" ");

        // 箱子字符串
        String box = strings[0];
        // 空地的宽度
        int n = Integer.valueOf(strings[1]);

        Map<Integer, StringBuffer> map = new HashMap<>();
        for(int i=0; i<box.length(); i++){
            int index = i%n;
            int flag = i/n%2;  //用索引取余来确定箱子的位置
            char c = box.charAt(i);
            if (flag == 0){
                if(map.containsKey(index)){
                    map.get(index).append(c);
                }else {
                    map.put(index, new StringBuffer().append(c));
                }
            }else {
                if (map.containsKey(n - index - 1)) {
                    map.get(n-index-1).append(c);
                }else {
                    map.put(n-index-1,new StringBuffer().append(c));
                }
            }
        }

        for(StringBuffer sb : map.values()){
            System.out.println(sb);
        }

    }
}
