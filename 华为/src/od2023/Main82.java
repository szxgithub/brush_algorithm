package od2023;

import java.util.Scanner;

public class Main82 {

    /*

    对称字符串
 输入：
    5
    1 0
    2 1
    3 2
    4 6
    5 8
 输出：
    red
    red
    blue
    blue
    blue

    输入：
    1
    64 73709551616
    输出
    red
     */

    public static void main4(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long[][] arr = new long[N][2];
        for (int i =0; i<arr.length; i++){
            arr[i][0] = sc.nextLong();
            arr[i][1] = sc.nextLong();
        }


        for (int i = 0; i<arr.length; i++){
            long n = arr[i][0];
            long k = arr[i][1];

            String str = getStr(n);
            char c = str.charAt((int) k);
            if (c == 'B'){
                System.out.println("blue");
            }else if (c == 'R'){
                System.out.println("red");
            }
        }


    }

    /*

        n=64时，该方法会超时 报OOM异常

     */
    private static String getStr(long n) {
        if (n == 1){
            return "R";
        }

        String str = getStr(n - 1);

        StringBuffer sb = new StringBuffer();
        for (int i =0; i<str.length(); i++){
            char c = str.charAt(i);
            if (c == 'R'){
                sb.append('B');
            }else if (c == 'B'){
                sb.append('R');
            }
        }
        return sb.toString() + str;
    }

    /*
    该方法所有测试用例可行
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int i=0; i<T; i++){
            int n = sc.nextInt();
            long k = sc.nextLong();

            long charNum = (long) Math.pow(2, n - 1);       //第n行的总字符个数
            int re = doProcess(charNum, k, 0);
            if (re % 2 == 0) {
                System.out.println("red");      //翻转次数为2的倍数
            } else {
                System.out.println("blue");
            }
        }

    }

    /**
     * 翻转次数
     * @param count     总字符的个数
     * @param cur       字符的索引
     * @param reverse       翻转次数
     * @return
     */
    public static int doProcess(long count, long cur, int reverse){

        if (count == 1) {
            return reverse;
        }
        long half = count / 2;
        if (cur < half) {    //小于半数说明是经过翻转的部分
            reverse ++;
            return doProcess(half, cur, reverse);
        } else {
            return doProcess(half, cur - half, reverse);
        }
    }


    public static void main2(String[] args) {
        String str1 = getStr(1);
        String str2 = getStr(2);
        String str3 = getStr(3);
        String str4 = getStr(4);
        String str5 = getStr(64);
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str4);
        System.out.println(str5);
    }

}
