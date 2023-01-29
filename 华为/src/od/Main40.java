package od;

import java.util.Scanner;

public class Main40{

    /**
     *
     * 猴子爬山
     *
     * 列出每种台阶数的跳跃方式，可以发现 f(n) = f(n-1) + f(n-3)
     * f(1) = 1
     * f(2) = 1
     * f(3) = 2 (1,1,1或者3)
     *
     * */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(pashan(n));
    }

    public static int pashan(int n){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 1;
        }
        if(n==3){
            return 2;
        }
        return pashan(n-1)+pashan(n-3);
    }

}
