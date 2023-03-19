package od2023.onehundred;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main47 {

    /*

    整理扑克牌

    不同类型的组合牌由大到小排列规则：炸弹 葫芦 三张 对子 单张

    当存在多个组合方案时，按如下规则排序取最大的一个组合方案
        “炸弹”为相同数字的4张
        3张相同 + 2张相同牌面，组合牌为”葫芦“
        3张相同的，称为”三张“
        2张相同的，称为”对子“
        剩余没有相同的，则为”单张“


    输入描述:
        第一行为空格分隔的N个正整数，每个整数取值的范围是[1,13]，N的取值的范围为[1,1000]
    输出描述：
        经过重新排列的扑克牌数字列表，每个数字以空格分隔

输入：
4 4 2 1 2 1 3 3 3 4
输出：
4 4 4 3 3 2 2 1 1 3

     */

    /*
    满分答案  逻辑分析题
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        // 1 3 3 3 2 1 5
        String[] split = s.split(" ");
        // 数字的范围是1-13
        int[] puke = new int[14];
        for (String num : split) {
            puke[Integer.parseInt(num)]++;
        }

        // 优先筛选出炸弹
        ArrayList<String> zhadan = new ArrayList<>();
        int i = 13;
        while (i >= 1) {
            if (puke[i] >= 4) {
                puke[i] -= 4;
                String num = Integer.toString(i);
                zhadan.add(num + num + num + num);
                continue;
            }
            i--;
        }

        // 相同类型组合牌牌面数字加总 由大到小排序
        zhadan.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o2) - Integer.parseInt(o1);
            }
        });

        // 再搞定三张
        ArrayList<String> sanzhang = new ArrayList<>();
        i = 13;
        while (i >= 1) {
            if (puke[i] >= 3) {
                puke[i] -= 3;
                String num = Integer.toString(i);
                sanzhang.add(num + num + num);
                continue;
            }
            i--;
        }

        //搞定对子
        ArrayList<String> duizi = new ArrayList<>();
        i = 13;
        while (i >= 1) {
            if (puke[i] >= 2) {
                puke[i] -= 2;
                String num = Integer.toString(i);
                duizi.add(num + num);
                continue;
            }
            i--;
        }

        // 最后统计单张
        ArrayList<String> danzhang = new ArrayList<>();
        i = 13;
        while (i >= 1) {
            if (puke[i] >= 1) {
                puke[i] -= 1;
                String num = Integer.toString(i);
                danzhang.add(num);
                continue;
            }
            i--;
        }

        // 三对+两对凑葫芦
        ArrayList<String> hulu = new ArrayList<>();
        while (sanzhang.size() > 0){
            if (duizi.size() == 0 && sanzhang.size() == 1){
                break;
            }

            // 最大的三张
            String s1 = sanzhang.get(0);
            // 第二大的三张
            String s2 = sanzhang.get(1);

            String s3 = duizi.get(0);

            if (Integer.valueOf(s2) > Integer.valueOf(s3)){
                // 拆分第二大的三张为一个对子和一个单张
                String tmpDuizi = s2.substring(0, 2);
                String tmpDanzhang = s2.substring(2, 3);
                hulu.add(s1 + tmpDuizi);
                danzhang.add(tmpDanzhang);
                sanzhang.remove(0);
                sanzhang.remove(0);
            }else {
                hulu.add(s1 + s3);
                sanzhang.remove(0);
                duizi.remove(0);
            }
        }

        // 输出
        ArrayList<String> result = new ArrayList<>();
        result.addAll(zhadan);
        result.addAll(hulu);
        result.addAll(sanzhang);
        result.addAll(duizi);
        result.addAll(danzhang);

        for (String item : result) {
            char[] chars = item.toCharArray();
            for (char c : chars){
                System.out.print(c + " ");
            }
        }
    }
}
