package od2023.twohundred;

import java.util.Arrays;
import java.util.Scanner;

public class Main29 {
    /*
    不爱施肥的小布（农场施肥）
    输入描述：
        第一行输入m和n， m表示fields中元素的个数，n表示施肥任务必须在n天内完成
        第二行输入fields,fields[i]表示果林i的面积
    输出描述：



     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] fields = new int[m];
        for(int i=0; i<m; i++){
            fields[i] = sc.nextInt();
        }

        int l = 1;  //最低能效
        int r = Arrays.stream(fields).max().getAsInt();     //最高能效
        while(l < r){
            int mid = (l + r) / 2;      //取中位数
            if(check(mid, fields) <= n){    //判断能效施肥满足天数要求
                r = mid;    //满足要求，右边界缩小
            }else{
                l = mid + 1;    //不满足，左边界缩小
            }
        }

        if(check(l, fields) > n){
            System.out.println(-1);
        }else{
            System.out.println(l);
        }
    }

    /**
     * 判断mid能效需要几天完成施肥
     * @param mid       能效
     * @param fields    面积数组
     * @return
     */
    public static int check(int mid, int[] fields){

        int ans = 0;
        for(int i=0; i<fields.length; i++){

            if(fields[i] % mid == 0){  //能整除能效则直接添加，否则需要+1
                ans += fields[i] / mid;
            }else{
                ans += fields[i] / mid + 1;
            }

        }

        return ans;
    }

}
