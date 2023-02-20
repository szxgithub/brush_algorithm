package od2022I;

import java.util.Scanner;

public class Main23 {

    /**
     *
     * 停车场车辆统计
     *
     * 1,0,1
     * 2
     *
     *1,1,0,0,1,1,1,0,1
     * 3
     *
     * */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        String[] split = str.split(",");

        int left = 0;
        int right = 0;

        int ans = 0;

        while (right < split.length){

            if (split[right].equals("1") && right - left < 3){
                right++;
            }else if (split[left].equals("1") && right - left <= 3){
                ans++;
                left = right;
            }else {
                right++;
                left++;
                continue;
            }
        }

        ans += (right-left);

        System.out.println(ans);

    }

}
