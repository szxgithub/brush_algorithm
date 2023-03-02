package od2023.onehundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main65 {

    /*

    组合出合法最小数
    给一个数组，数组里面都是代表非负整数的字符串，将数组里所有的数值排列组合拼接起来组成一个数字，输出拼接成的最小的数字

    输入描述：
        数组里面都是非负整数的字符串，可以是0开头的
    输出描述：
        如果过最终结果是多位数字，要优选选择输出不是0开头的最小数字
        如果拼出来的都是0开头的，输出最小的，且去掉前导0

    使用经典的全排列算法

     */

    public static List<String> list = new ArrayList<>();
    public static boolean isExistZeroPrefix = false;
    public static void main2(String[] args) {

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
            quanpailie(s,i+1,end);
            swap(s,i,index);
        }

    }

    private static void swap(String[] s, int i, int index) {
        String temp = s[i];
        s[i] = s[index];
        s[index] = temp;
    }

    /*
    采用全排列算法可能会超时,因为数组的范围[1-50]，全排列算法的时间复杂度为O(n!)
    下面的算法时间复杂度为O(n)

     */
    public static String getResult(String[] strs){

        // 对于两个字符串a和b组合，比较大小
        Arrays.sort(strs,(a,b) -> (a+b).compareTo(b+a));

        if (strs[0].charAt(0) == '0'){
            for (int i = 1; i < strs.length; i++){
                if (strs[i].charAt(0) != '0'){
                    strs[0] = strs[i] + strs[0];
                    strs[i] = "";
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String str : strs){
            sb.append(str);
        }

        return sb.toString().replaceAll("^0+","");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        System.out.println(getResult(strs));
    }



}
