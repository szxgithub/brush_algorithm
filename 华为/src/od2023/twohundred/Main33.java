package od2023.twohundred;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main33 {

    /*

    几何平均值最大子数组
    从一个长度为N的正数数组numbers中找出长度至少为L且几何平均值最大的子数组，并输出其位置和大小。（K个数的几何平均值为K个数的乘积的K次方）
    若有多个子数组的几何平均值为最大值，则输出长度最小的子数组
    若有多个长度相同的子数组的几何平均值为最大值，则输出最前面的子数组

    输入描述：
        第一行输入N、L，N表示numbers的大小， L表示子数组的最小长度
        之后N行表示数组中的N个数
    输出描述：
        输出子数组的位置和大小，中间用空格隔开

     */


    /*
    若博豆 逻辑分析
    通过率45%
     */
    // 最大几何平均值
    public static double max;
    // 正在处理数据的索引
    public static int index;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // numbers的大小
        int N = sc.nextInt();

        // 子数组的最小长度
        int L = sc.nextInt();

        double[] numbers = new double[N];
        for (int i =0; i<numbers.length; i++){
            numbers[i] = sc.nextDouble();
        }


        int resIndex = 0;
        int resLen = 0;
        // 最小长度为L，最大为N, 遍历L-N之间每一种可能
        for (int i = L; i <=N; i++){
            if (handle(numbers,i)){
                resIndex = index;
                resLen = i;
            }
        }

        System.out.println(resIndex +  " " + resLen);
    }


    /**
     * 是否满足最大几何平均值
     * @param len       子数组长度
     * @param doubles      输入的正数数组
     * @return
     */
    public static boolean handle(double[] doubles, int len){

        //len长度数组的最大乘积
        double maxInLen = 1;
        for(int i=0; i<len; i++){
            BigDecimal num1 = new BigDecimal(String.valueOf(maxInLen));
            BigDecimal num2 = new BigDecimal(String.valueOf(doubles[i]));
            maxInLen = num1.multiply(num2).doubleValue();   //初始化maxInLen
        }

        index = 0;      //初始化索引位置
        double count = maxInLen;    //各数组中数字的乘积
        for(int i=len; i<doubles.length; i++){
            count *= doubles[i]/doubles[i - len];
            if(count > maxInLen){
                //count大于maxInLen需要更新index和maxInLen
                index = i - len + 1;
                maxInLen = count;
            }
        }

        // K个数的几何平均值为K个数的乘积的K次方
        double CFG = Math.pow( maxInLen, (double) 1/len);   //求出乘积的Len次方根

        if(CFG > max){
            max = CFG;
            return true;
        }
        return false;
    }

}
