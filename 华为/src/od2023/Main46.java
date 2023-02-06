package od2023;

import java.util.*;

public class Main46 {

    /*

    找出通过车辆最多颜色

     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        int n = sc.nextInt();

        int res = 0;
        for(int i=0; i<strs.length - n + 1; i++){
            //只有3种颜色，可以转化成长度3的数组
            int[] ints = new int[3];
            for(int j=i; j<i+n; j++){
                int index = Integer.valueOf(strs[j]);
                ints[index] ++;
            }
            int maxCount = Arrays.stream(ints).max().getAsInt();
            res = Math.max(res,maxCount);
        }

        System.out.println(res);

    }

}
