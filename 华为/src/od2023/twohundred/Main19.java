package od2023.twohundred;

import java.util.*;

public class Main19 {

    /*

    最差产品奖

    对N个产品评选最差奖
    首先对每个产品评分，然后根据评分区间计算相邻几个产品中最差的产品
    依次找到从当前产品开始前M个产品中最差的产品，请给出最差产品的评分序列

    输入描述：
        第一行，数字M，表示评分区间的长度
        第二行，产品的评分序列，比如[12,3,8,6,5]，产品数量N范围是-10000 < N <10000
    输出描述：
        评分区间内最差产品的评分序列

输入：
3
12,3,8,6,5
输出：3,3,5

     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int M = Integer.parseInt(sc.nextLine());

        String str = sc.nextLine();
        String[] split = str.split(",");
        int[] ints = Arrays.stream(split).mapToInt(value -> Integer.parseInt(value)).toArray();

        // List<Integer> res = getResult1(M, ints);
        String result3 = getResult3(M, ints);

        System.out.println(result3);

    }

    private static List<Integer> getResult1(int M, int[] ints) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i< ints.length; i++){
            int[] tmp;
            if (i+ M < ints.length){
                tmp = Arrays.copyOfRange(ints, i, i + M);
                int asInt = Arrays.stream(tmp).min().getAsInt();
                res.add(asInt);
            }else {
                tmp = Arrays.copyOfRange(ints, i, ints.length);
                int asInt = Arrays.stream(tmp).min().getAsInt();
                res.add(asInt);
                break;
            }
        }
        return res;
    }


    public static void main2(String[] args){
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        sc.nextLine();

        String[] strs = sc.nextLine().split(",");
        List<Integer> res = getResult2(M, strs);

        System.out.println(res);
    }

    /*
    双层for循环求出一定区间的最小值
     */
    private static List<Integer> getResult2(int M, String[] strs) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < strs.length - M + 1; i++){
            int min = Integer.MAX_VALUE;
            for (int j = i; j <i+ M; j++){
                min = Math.min(min,Integer.valueOf(strs[j]));
            }
            res.add(min);
        }
        return res;
    }

    /*
    这题最优解法，应该用滑动窗口
    */
    public static String getResult3( int m, int[] arr){
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <m; i++){
            min = Math.min(min,arr[i]);
        }

        ArrayList<Integer> ans  = new ArrayList<>();
        ans.add(min);

        int j = m;
        while (j < arr.length){
            if (arr[j - m] > min){
                min = Math.min(min,arr[j]);
            }else {
                if (arr[j] <= min){
                    min = arr[j];
                }else {
                    min = arr[j - m + 1];
                    for (int i = j-m+2; i <= j; i++){
                        min = Math.min(min,arr[i]);
                    }
                }
            }
            ans.add(min);
            j++;
        }

        StringJoiner sj = new StringJoiner(",");
        for (Integer an : ans){
            sj.add(an + "");
        }
        return sj.toString();
    }

}
