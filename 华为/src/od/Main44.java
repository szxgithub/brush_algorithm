package od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main44 {

    /**
     *
     * 篮球比赛
     *
     * */

    public static List<Integer> nums = new ArrayList<>();
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] strings = sc.nextLine().split(" ");

        int len = strings.length;

        int[] ints = new int[len];

        int count = 0;

        for (int i =0; i<len; i++){
            int temp = Integer.parseInt(strings[i]);
            ints[i] = temp;
            count += temp;
        }

        combine(ints,5,new ArrayList<>(),0);

        int min = Integer.MAX_VALUE;

        for (int i =0; i < nums.size(); i++){
            min = Math.min(Math.abs(count - nums.get(i)*2),min);
        }

        System.out.println(min);
    }

    /***
     *
     * 经典的M个字符中取N个字符的全排列算法
     *
     * @param ints 所有队员
     * @param n 需要队员的个数
     * @param list 加入的队员
     * @param index 队员下标
     */
    private static void combine(int[] ints, int n, ArrayList<Integer> list, int index) {
        if (n == 0){
            int res =0;
            for (int i =0;i < list.size(); i++){
                res += list.get(i);
            }
            nums.add(res);
        }else {
            for (int i = index; i <ints.length; i++){
                list.add(ints[i]);
                combine(ints,n-1,list,i+1);
                list.remove(list.size()-1);
            }
        }
    }

}
