package od2023;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main78 {

    /*

    获得完美走位
     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        int len = str.length();

        // 求出各个方向所需要的个数
        int count = len/4;

        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i <len; i++){
            map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0) + 1);
        }

        // 计算各个方向多余的个数
        for (Map.Entry<Character,Integer> entry : map.entrySet()){
            entry.setValue(entry.getValue() - count);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i<len; i++){
            char c = str.charAt(i);
            int res = 0;
            Map<Character,Integer> copyMap = new HashMap<>(map);
            if (copyMap.get(c) > 0){
                for (int j = i; j <len; j++){
                    char tmp = str.charAt(j);
                    copyMap.put(tmp,copyMap.get(tmp) - 1);
                    res++;
                    if (isTrue(copyMap)){
                        break;
                    }
                }
            }

            if (isTrue(copyMap)){
                min = Math.min(min,res);
            }
        }

        System.out.println(min);

    }

    public static boolean isTrue(Map<Character,Integer> map){
        for (Integer i : map.values()){
            if (i > 0){
                return false;
            }
        }
        return true;
    }

}
