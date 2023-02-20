package od2022I;

import java.util.*;

public class Main51 {

    /*

    字符统计及重排

    输入：xyxyXX
    输出：x:2;y:2;X:2;

    输入：abababb
    输出：b:4;a:3;


     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        // 保证key值按照自然顺序
        // 存小写字母
        TreeMap<Character, Integer> lowerMap = new TreeMap<>();
        // 存大写字母
        TreeMap<Character, Integer> upperMap = new TreeMap<>();

        char[] array = str.toCharArray();

        for (int i =0; i< array.length; i++){
            if (Character.isLowerCase(array[i])){
                lowerMap.put(array[i],lowerMap.getOrDefault(array[i],0) + 1);
            }else {
                upperMap.put(array[i],upperMap.getOrDefault(array[i],0) + 1);
            }
        }

        ArrayList<Map.Entry<Character, Integer>> list1 = new ArrayList<>(lowerMap.entrySet());
        ArrayList<Map.Entry<Character, Integer>> list2 = new ArrayList<>(upperMap.entrySet());

        // 按照字母出现次数从大到小排序
        list1.sort(((o1, o2) -> o2.getValue() - o1.getValue()));
        list2.sort(((o1, o2) -> o2.getValue() - o1.getValue()));

        String res = "";
        for (Map.Entry<Character,Integer> entry : list1){
            res += entry.getKey() + ":" + entry.getValue() + ";";
        }
        for (Map.Entry<Character,Integer> entry : list2){
            res += entry.getKey() + ":" + entry.getValue() + ";";
        }

        System.out.println(res);


    }

}
