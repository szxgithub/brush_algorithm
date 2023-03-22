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

输入：
1 10 5 2
输出：
1

输入：
11 33 4 10
输出：
2


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

        int res;
        res = getResult(s, t, a, b);
        System.out.println(res);
    }

    /*
    这道题有点像数学题

   问题就是求解满足 a*x + b*y = t-s的所有解中绝对值最小的x
   因此可以让x从0开始尝试，1，-1或2，-2，直到找到一个x能够让 (t-s - a*x)%y == 0
   本题1 <= s,t,a,b <= 105

     */
    public static int getResult(int s, int t, int a, int b){
        // 求x的最小值 即a的最少使用次数
        int x = 0;
        int diff = t - s;

        while (true){
            if ((diff - a*x)%b == 0 || (diff + a*x)%b == 0){
                return Math.abs(x);
            }
            x++;
        }
    }

}
