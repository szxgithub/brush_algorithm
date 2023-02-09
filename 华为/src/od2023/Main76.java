package od2023;

import javafx.scene.chart.ValueAxis;

import java.util.Arrays;
import java.util.Scanner;

public class Main76 {

    /*

    日志采集系统
     */

    public static int[] ints;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String[] s = str.split(" ");
        ints = Arrays.stream(s).mapToInt(value -> Integer.valueOf(value)).toArray();

        // 统计日志总数
        int count = ints[0];
        int max = ints[0];

        if (ints[0] >= 100){
            System.out.println(100);
        }else {
            for (int i= 1; i<ints.length; i++){
                count += ints[i];
                if (count >= 100){
                    max = Math.max(max,100-jisuan(i));
                    break;
                }else {
                    max = Math.max(max,count - jisuan(i));
                }
            }

            System.out.println(max);

        }

    }

    /*
    计算index前日志扣除的分数
     */
    private static int jisuan(int index) {
        int score = 0;
        for (int i = 0; i <index; i++){
            score += ints[i]*(index - i);
        }
        return score;
    }

}
