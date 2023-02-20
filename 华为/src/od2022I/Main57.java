package od2022I;

import java.util.Scanner;

public class Main57 {

    /*

    字符串比较

    输入：
    xxcdefg
    cdefghi
    5
    输出
    2

     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        int V = sc.nextInt();

        int len = str1.length();

        int res = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i =0; i <len; i++){
            char a = str1.charAt(i);
            char b = str2.charAt(i);
            sum += Math.abs(a - b);
            if (sum <= V){
                res++;
            }else {
                sum = 0;
                res = 0;
            }
            max = Math.max(res,max);
        }

        System.out.println(max);

    }

}
