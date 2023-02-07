package od2023;

import java.util.Arrays;
import java.util.Scanner;

public class Main57 {

    /*

    数字加减游戏



     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str =  sc.nextLine();
        String[] arr = str.split(" ");
        int[] ints = Arrays.stream(arr).mapToInt(value -> Integer.valueOf(value)).toArray();

        int s = ints[0];
        int t = ints[1];
        int a = ints[2];
        int b = ints[3];

        int res = 0;
        int add = s;
        int sub = s;
        // (t- (s + a*i)) %b == 0
        // (t - (s - a*i))%b == 0
        while (true){
            if ((t-add)%b == 0){
                break;
            }
            if ((t-sub)%b == 0){
                break;
            }
            add += a;
            sub -= a;
            res++;
        }

        System.out.println(res);
    }

}
