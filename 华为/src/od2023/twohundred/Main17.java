package od2023.twohundred;

import java.util.Arrays;
import java.util.Scanner;

public class Main17 {

    /*

    数字加减游戏
    使用加法或者减法，将一个数字s变成数字t
    每个回合可以在当前数字上加上或减去一个数字
    现在有两种数字可以用来加减，分别为a，b，(a != b) ，其中b没有使用次数限制
    请问最少可以用多少次a，才能将数字s变成t

    输入描述：
        四个正整数，s t a b

    输出描述：
        输出一个整数


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
