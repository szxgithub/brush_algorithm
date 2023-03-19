package od2023.onehundred;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main41 {

    /*
    取出尽量少的球（开放日活动）

    某部门开展Family Day开放日活动，其中有个从桶里取球的游戏，游戏规则如下：
    有个N个容量一样的小桶等距排开
    每个桶里都默认装了数量不等的小球
    每个桶的小球数量记录在bucketBallNums中，
    要求所有桶的小球总数不超过SUM，如果超过SUM，则需要对所有桶设置一个统一的容量最大值maxCapacity
    请你根据输入的数据，计算从每个小桶里拿出的小球数量

    输入描述：
        第一行两个数字，第一个数字SUM，第二个数字数组长度
        第二行数组元素
    输出描述：
        找到一个maxCapacity，保证取出的球最少，输出每个桶取出的球组成的数组


输入：
3 3
1 2 3
输出：
[0, 1, 2]

输入：
14 7
2 3 2 5 5 1 4
输出：
[0, 1, 0, 3, 3, 0, 2]

     */

    /*
    二分查找
    根据题意模拟
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int SUM = sc.nextInt();
        int ballNumsLen = sc.nextInt();
        sc.nextLine();
        String[] strings = sc.nextLine().split(" ");

        int[] ballNums = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();
        //球的总数
        BigDecimal ballCount = new BigDecimal(0);
        for( int i=0; i<ballNums.length; i++){
            ballCount = ballCount.add(new BigDecimal(ballNums[i]));
        }
        //球的总数大于SUM时需要处理
        if(ballCount.compareTo(new BigDecimal(SUM)) == 1){

            //maxCapacity的最小值
            int min = SUM/ballNums.length;
            //maxCapacity的最大值
            int max = Arrays.stream(ballNums).max().getAsInt();

            //各个管子移除的球的个数数组
            int[] tempOut = new int[ballNums.length];
            while (min < max){
                //中位数
                int mid = (min + max) / 2;
                //取出的球的总数
                BigDecimal outCount = new BigDecimal(0);
                //每个管子都需要移除mid个球
                for(int i=0; i<ballNums.length; i++){
                    tempOut[i] = ballNums[i] - mid > 0 ? ballNums[i] - mid : 0;
                    outCount = outCount.add(new BigDecimal(tempOut[i]));
                }

                //剩余的球的总数
                BigDecimal remainCount = ballCount.subtract(outCount);

                if(remainCount.compareTo(new BigDecimal(SUM)) == 0){
                    break;
                }else if(remainCount.compareTo(new BigDecimal(SUM)) == 1){
                    //剩下的球大于SUM
                    max = mid;
                }else {
                    min = mid + 1;
                }
            }

            System.out.println( Arrays.toString(tempOut));
        }else {
            System.out.println("[]");
        }

    }

}
