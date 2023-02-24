package od2023.onehundred;

import javax.swing.plaf.IconUIResource;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main5 {

    /*

    获得完美走位

    在第一人称射击游戏中，玩家通过ASDW四个按键控制人物移动方向

    玩家在操作一定次数的键盘并且各个方向的步数相同时，此时游戏任务必定回到原点，则称此次走位为 完美走位

    请通过更换其中一段连续走位的方式使得成为一个完美走位，请返回待更换的连续走位的最小长度

    输入：WASDAASD
    输出：1

    输入：AAAA
    输出：3

     */

    public static void main2(String[] args) {

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


    public static void main(String[] args) {
        // String str = "WASDAASD";
        String str = "AAAA";
        int result = getResult(str);
        System.out.println(result);
    }
    /*

    滑动窗口解法

     */
    static public int getResult(String str){
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            map.put(c,map.getOrDefault(c,0) + 1);
        }

        // 平衡时 ASWD的数量
        int avg = str.length()/4;

        // 记录多余字母的总数
        int total = 0;

        // 当前是否平衡的标志
        boolean flag = true;
        for (Character c : map.keySet()){
            if (map.get(c) > avg){
                flag = false;
                map.put(c,map.get(c) - avg);
                total += map.get(c);
            }else {
                map.put(c,0);
            }
        }

        if (flag){
            return 0;
        }

        int i = 0; // 代表滑窗左边界
        int j = 0; // 代表滑窗右边界
        int minLen = str.length() + 1;
        while (j < str.length()){
            char c = str.charAt(j);
            if (map.get(c) > 0){
                total--;
            }
            map.put(c,map.get(c) - 1);
            while (total == 0){
                minLen = Math.min(minLen,j - i + 1);
                char c1 = str.charAt(i);
                if (map.get(c1) >= 0){
                    total++;
                }
                map.put(c1,map.get(c1) + 1);
                i++;
            }
            j++;
        }

        return minLen;

    }


}
