package od2023.onehundred;

import java.util.Scanner;

public class Main55 {

    /*
    机房布局

    规划一个大型数据中心机房，为了使机柜上的机器都能正常工作，需要确保每个机柜边上至少要有一个电箱

    假设机房是一整排，M表示机柜，I表示间隔，请你返回这整排机柜，至少需要多少个电箱，如果无解，返回-1

输入：
IMIM
输出：1


     */

    /*
    逻辑分析

    遍历字符串
    当碰到M时，判断后面是否为I
    如果是I，直接安装电箱，且紧接后面的机柜可以公用此电箱，跳过，索引+2
    如果不是I，则查看前面的是否为I
    如果是I，则在前面安装
    如果也不是I，则返回-1，表示无解
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // 输入为一排机柜
        String str = sc.nextLine();


        int ans = 0;
        for (int i =0; i<str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'M'){
                // 优先考虑右边是否可以放电箱
                if (i + 1 < str.length() && str.charAt(i+1) == 'I'){
                    ans++;
                    i+=2;
                }else if (i-1 >= 0 && str.charAt(i-1) == 'I'){
                    ans++;
                }else {
                    ans = -1;
                    break;
                }
            }

        }

        System.out.println(ans);

    }



}
