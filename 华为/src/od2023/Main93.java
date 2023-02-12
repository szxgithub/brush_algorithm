package od2023;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main93 {

    /*

    几何平均值最大子数组

    //todo
     */

    public static double max;
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

        // K个数的几何平均值为K个数的乘积的K次方

        int resIndex = 0;
        int resLen = 0;
        for (int i = L; i <=N; i++){
            if (handle(i,numbers)){
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
    public static boolean handle(int len, double[] doubles){

        double maxInLen = 1;    //len长度数组的最大乘积
        for(int i=0; i<len; i++){
            BigDecimal num1 = new BigDecimal(String.valueOf(maxInLen));
            BigDecimal num2 = new BigDecimal(String.valueOf(doubles[i]));
            maxInLen = num1.multiply(num2).doubleValue();   //初始化maxInLen
        }

        index = 0;      //初始化索引位置
        double count = maxInLen;    //各数组中数字的乘积
        for(int i=len; i<doubles.length; i++){
            count *= doubles[i]/doubles[i - len];
            if(count > maxInLen){       //count大于maxInLen需要更新index和maxInLen
                index = i - len + 1;
                maxInLen = count;
            }
        }

        double CFG = Math.pow( maxInLen, (double) 1/len);   //求出乘积的Len次方根

        if(CFG > max){
            max = CFG;
            return true;
        }
        return false;
    }

}
