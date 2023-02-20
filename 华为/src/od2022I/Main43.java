package od2022I;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main43 {

    /***
     *
     * 数组组成的最小数字
     *
     * 输入：
     * 21,30,62,5,31
     * 输出：
     * 21305
     *
     * */

    public static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] strings = sc.nextLine().split(",");

        int len = strings.length;

        int res = 0;
        if (len == 1){
            res = Integer.parseInt(strings[0]);
        }else {
            List<Integer> numList = new ArrayList<>();
            for (int i = 0; i < len; i++){
                numList.add(Integer.parseInt(strings[i]));
            }

            // 排序
            Collections.sort(numList);

            int numslen;
            if (len == 2){
                numslen = 2;
            }else {
                numslen = 3;
            }

            int[] ints = new int[numslen];
            for (int i = 0; i < numslen; i++){
                ints[i] = numList.get(i);
            }

             // 全排列
            fullArr(ints,0,numslen);

            // 将所有的全排列结果进行排序，找出最小
            res = Collections.min(list);
        }

        System.out.println(res);

    }

    /***
     *
     * 对ints中的数字全排列
     *
     * @param ints 所有要排列的元素
     * @param cursor 起始位置
     * @param end
     */
    private static void fullArr(int[] ints, int cursor, int end) {

        if (cursor == end){
            String s = "";
            for (int i : ints){
                s+=i;
            }
            list.add(Integer.parseInt(s));
        }else {
            for (int i = cursor; i<end; i++){
                swap(ints,cursor,i);
                fullArr(ints,cursor + 1,end);
                swap(ints,cursor,i);
            }
        }

    }

    public static void swap(int[] ints, int a, int b){
        int temp = ints[a];
        ints[a] = ints[b];
        ints[b] = temp;
    }

}
