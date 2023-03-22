package od2023.twohundred;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main23 {

    /*
    去除多余空格
    去除文本多余空格，但是不去除配对单引号之间的多余空格，给出关键词的起始和结束下标，去除多余空格后更新下标

    条件约束：
        不考虑关键词起始和结束为空格的场景
         如果有单引号，必定成对出现
         单词的开始和结束下标保证涵盖一个完整的单词，中间不会有多余的空格


     输入描述：
        第一行，待去除多余空格的文本
        第二行，关键词的开始和结束坐标，关键词以逗号区分，关键词内的开始和结束位置以单空格区分
     输出描述：
        第一行，去除多余空格的文本
        第二行，关键词更新坐标后的新坐标

输入：
Life is painting a  picture, not doing 'a sum'.
8 15,20 26,43 45
输出：
Life is painting a picture, not doing 'a sum'.
[8,15][19,25][42,44]

     */


    /*
    逻辑分析题、

    先对文本进行多余空格去除，同时记录多余空格的位置
    遍历关键词坐标，让其与多余空格坐标比较
        有几个多余空格坐标在关键词坐标前，坐标就更新减多少

     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //去除首尾空格
        String s1 = sc.nextLine().trim();

        String resStr = "";
        // 记录要删除的多余空格的位置
        List<Integer> count = new ArrayList<>();

        int flag = 0;
        for (int i = 0; i < s1.length()-1; i++){
            if (s1.charAt(i) == '\''){
                flag++;
            }
            if (flag%2 == 0){
                // 判断是否存在多余空格字符
                if (s1.charAt(i) == ' ' && s1.charAt(i+1) == ' '){
                    count.add(i);
                    continue;
                }
            }
            resStr += s1.charAt(i);
        }
        // 处理完多余空格的字符串
        resStr += s1.charAt(s1.length() - 1);

        String s2 = sc.nextLine();
        String[] s2_1 = s2.split(",");
        List<Integer> resIndex = new ArrayList<>();
        for (String s : s2_1){
            String[] t = s.split(" ");
            int tem0 = Integer.parseInt(t[0]);
            resIndex.add(tem0 - fun(count,tem0));
            int tem1 = Integer.parseInt(t[1]);
            resIndex.add(tem1 - fun(count,tem1));
        }

        System.out.println(resStr);
        System.out.print("[");
        for (int i = 0; i < resIndex.size() - 1; i++){
            System.out.print(resIndex.get(i));
            if (i%2 == 0){
                System.out.print(", ");
            }else {
                System.out.print("][");
            }
        }
        System.out.print(resIndex.get(resIndex.size() - 1) + "]");
    }

    /**
     * 求出num位置之前多余的空格数
     * @param list
     * @param num
     * @return
     */
    public static int fun(List<Integer> list, int num){
        int result = 0;
        for (Integer integer : list){
            if (integer < num){
                result++;
            }
        }
        return result;
    }


}
