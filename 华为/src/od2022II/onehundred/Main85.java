package od2022II.onehundred;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

public class Main85 {

    /*

    喊7的次数重排
    编号为1的人从1开始喊数，下一个人喊的数字为上一个人加1，当喊的数字是7的倍数或者数字本身含有7的话，需要喊”过“
    当喊到数字K时，可以统计每个喊”过“的人数

    输入描述：
        输入一行，为空格分隔的喊”过“的次数，注意K并不提供，K不超过200，而数字的个数为N

输入：0 0 0 2 1
输出：0 2 0 1 0

     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] s = str.split(" ");
        int[] ints = Arrays.stream(s).mapToInt(Integer::valueOf).toArray();

        getResult(ints);

    }

    /*
    约瑟夫环
    模拟
        通过输入的字符串，可以知道人数、叫过的次数
     */
    private static void getResult(int[] ints) {

        // 人数
        int length = ints.length;

        // 一共喊了多少次
        int sum = 0;
        for (int i = 0; i<ints.length; i++){
            sum += ints[i];
        }

        int[] arr = new int[length];

        // 从7开始
        int step = 7;
        while (sum > 0){
            if (step%7 == 0 || String.valueOf(step).contains("7")){
                arr[(step-1)%length]++;
                sum--;
            }
            step++;
        }

        StringJoiner sj = new StringJoiner(" ");
        for (int ele : arr){
            sj.add(ele + "");
        }

        System.out.println(sj.toString());

    }

}
