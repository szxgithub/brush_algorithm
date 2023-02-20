package od2022I;

import java.util.Scanner;

public class Main26 {

    /**
     *
     * 找终点
     *
     * 给定一个正整数数组，设为nums，最大为100个成员，求从第一个成员开始，正好走到数组最好一个成员，所使用的最少步骤数
     *
     * 7 5 9 4 2 6 8 3 5 4 3 9
     * 2
     *
     * 1 2 3 7 1 5 9 3 2 1
     * -1
     *
     *
     * */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        String[] s = str.split(" ");

        int length = s.length;

        int ans = Integer.MAX_VALUE;

        if (s.length == 1){
            System.out.println(1);
            return;
        }

        for (int j = 1;  j < length/2; j++){

            // 起步下标
            int index = j;
            int count = 0;
            int step = 0;
            while (index < length){
                step = Integer.parseInt(s[index]);
                count++;
                index = index + step;
            }

            if (index - step == length-1){
                ans = Math.min(ans,count);
            }

        }

        if (ans == Integer.MAX_VALUE){
            System.out.println(-1);
        }else {
            System.out.println(ans);
        }


    }

}
