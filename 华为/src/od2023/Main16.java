package od2023;

import java.util.*;
import java.util.stream.Collectors;

public class Main16 {

    /*

    组合出合法最小数

    使用经典的全排列算法

     */

    public static List<String> list = new ArrayList<>();
    public static boolean isExistZeroPrefix = false;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        String[] s = str.split(" ");

        for (int i = 0; i <s.length; i++){
            if (!s[i].startsWith("0")){
                isExistZeroPrefix = true;
                break;
            }
        }

        // 全排列
        quanpailie(s, 0,s.length);

        int min = Integer.MAX_VALUE;
        for (int i =0 ; i<list.size(); i++){
            min = Math.min(min,Integer.parseInt(list.get(i)));
        }

        System.out.println(min);
    }

    private static void quanpailie(String[] s, int index, int end) {

        if (index == s.length){
            // 对于存在非0开头排列的要去掉0开头的排列
            if (isExistZeroPrefix){
                if (s[0].startsWith("0") && s.length > 1){
                    return;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i =0; i<s.length; i++){
                sb.append(s[i]);
            }
            list.add(sb.toString());
            return;
        }
        for (int i = index; i<s.length; i++){
            swap(s,i,index);
            quanpailie(s,index+1,end);
            swap(s,i,index);
        }

    }

    private static void swap(String[] s, int i, int index) {
        String temp = s[i];
        s[i] = s[index];
        s[index] = temp;
    }

}
