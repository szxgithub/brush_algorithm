package od2023.onehundred;

import java.util.Arrays;
import java.util.Scanner;

public class Main26 {

    /*

    日志采集系统(日志首次上报最多积分)

    日志上报策略：
    1、成功上报一条，奖励1分
    2、延迟上报一秒，扣1分
    3、积累日志到100条，必须立即上报

    给出日志序列，根据规则计算首次上报能获得的最多积分数


    输入：3 7 40 10 60
    输出：37


     */

    public static int[] ints;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String[] s = str.split(" ");
        // 按时序产生的日志条数
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
