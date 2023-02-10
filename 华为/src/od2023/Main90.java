package od2023;

import java.util.Scanner;

public class Main90 {

    /*

    不含101的数

    给定区间l、r，请输出区间内整数二进制格式中不包含101字符串的整数个数

     */


    /*
    这种解法部分测试用例会超时 目前没看到满分答案
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
}
