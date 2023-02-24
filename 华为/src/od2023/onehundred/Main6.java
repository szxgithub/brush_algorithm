package od2023.onehundred;

import java.util.Arrays;
import java.util.Scanner;

public class Main6 {

    /*

    不含101的数

    给定区间l、r，请输出区间内整数二进制格式中不包含101字符串的整数个数

    r >= l >= 1
    l<= r <= 10^9

     */


    /*
    这种解法部分测试用例会超时 目前没看到满分答案

    由于l、r范围很大，下面这种O(n)的时间复杂度会超时
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int l = sc.nextInt();
        int r = sc.nextInt();

        int count = 0;
        for (int i =l; i <=r; i++){
            String s = Integer.toBinaryString(i);
            int i1 = s.indexOf("101");
            if (i1 == -1){
                count++;
            }
        }
        System.out.println(count);
    }

    /*

    采用数位DP算法  性能更优

     */
    public static void main2(String[] args) {

        Scanner sc = new Scanner(System.in);

        int l = sc.nextInt();
        int r = sc.nextInt();

        int count = digitSearch(r)  - digitSearch(l);
        System.out.println(count);

    }

    static public int digitSearch(int num){
        Integer[] arr = Arrays.stream(Integer.toBinaryString(num).split("")).map(Integer::parseInt).toArray(Integer[]::new);

        int[][][] f = new int[arr.length][2][2];

        return dfs(0,true,f,arr,0,0);
    }

    static private int dfs(int p, boolean limit, int[][][] f, Integer[] arr, int pre, int prepare) {

        if (p == arr.length){
            return 1;
        }
        if (!limit && f[p][pre][prepare] != 0){
            return f[p][pre][prepare];
        }

        int max = limit ? arr[p] : 1;
        int count = 0;
        for (int i = 0; i <= max; i++){
            if (i == 1 && pre == 0 && prepare == 1){
                continue;
            }
            count += dfs(p+1,limit && i == max,f,arr,i,pre);
        }

        if (!limit){
            f[p][pre][prepare] = count;
        }

        return count;

    }
}
