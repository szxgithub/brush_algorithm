package od2023;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main58 {

    /*

    整理扑克牌

    不同类型的组合牌由大到小排列规则：炸弹 葫芦 三张 对子 单张

     */

    /*
    满分答案
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        // 1 3 3 3 2 1 5
        String[] split = s.split(" ");
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
//        Collections.sort(zhadan);
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
        int size = Math.min(sanzhang.size(), duizi.size());
        for (int j = 0; j < size; j++) {
            hulu.add(sanzhang.get(0) + duizi.get(0));
            sanzhang.remove(0);
            duizi.remove(0);
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
