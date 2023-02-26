package od2023.onehundred;

import java.util.*;

public class Main3 {

    /*

    字符串重新排序

    给定一个字符串s, s包括以空格分隔的若干个单词

    输入：
    This is an apple
    输出：
    an is This aelpp

     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        String[] s = str.split(" ");

        TreeMap<String,Integer> map= new TreeMap<>();

        // 对每个单词内部字母按字典排序
        for (int i =0; i <s.length; i++){
            char[] array = s[i].toCharArray();
            Arrays.sort(array);
            s[i] = new String(array);
            // 单词间按字典顺序放进map中统计
            map.put(s[i],map.getOrDefault(s[i],0) + 1);
        }

        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort((o1, o2) -> {
            // 按次数降频排序
            if (o1.getValue() > o2.getValue()){
                return -1;
            }else if (o1.getValue() < o2.getValue()){
                return 1;
            }else {
                // 出现次数相同时，按照单词的长度升序排序
                return o1.getKey().length() - o2.getKey().length();
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String,Integer> entry : list){
            for (int i = 0; i < entry.getValue(); i++){
                sb.append(entry.getKey());
                sb.append(" ");
            }
        }

        String substring = sb.substring(0, sb.length() - 1);
        System.out.println(substring);


    }

}
