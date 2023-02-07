package od2023;

import java.util.*;

public class Main53 {

    /*

    箱子之形摆放

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
