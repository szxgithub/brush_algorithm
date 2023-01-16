package com.nowcoder;

/**
 *
 * 求解立方根
 *
 * 描述
 * 计算一个浮点数的立方根，不使用库函数。
 * 保留一位小数。
 *
 * 输入描述：
 * 待求解参数，为double类型（一个实数）
 *
 * 输出描述：
 * 输入参数的立方根。保留一位小数。
 *
 * 具体做法
 * 做过求平方根的同学应该都知道，这题最先想到的应该就是二分法吧。
 *
 * 如果一个数num>1，那么这个数的立方根一定在1~num之间。
 * 如果一个数num<-1，那么这个数的立方根一定在num~-1
 * 如果一个数-1<num<1，那么这个数的立方根一定在-1~1之间 如num = 2.7
 * 可以设置左边界为min(-1,2.7) = -1 右边界 max(1,2.7) = 2.7
 *
 * 所以left = -1，right = 2.7
 *
 * 执行流程
 *
 * 复制代码
 * left:-1.0 mid:0.8500000000000001right:2.7
 * left:0.8500000000000001 mid:1.7750000000000001right:2.7
 * left:0.8500000000000001 mid:1.3125right:1.7750000000000001
 * left:1.3125 mid:1.5437500000000002right:1.7750000000000001
 * left:1.3125 mid:1.428125right:1.5437500000000002
 * left:1.3125 mid:1.3703125right:1.428125
 * left:1.3703125 mid:1.3992187500000002right:1.428125
 * left:1.3703125 mid:1.384765625right:1.3992187500000002
 * left:1.384765625 mid:1.3919921875right:1.3992187500000002
 * left:1.3919921875 mid:1.3956054687500001right:1.3992187500000002
 * left:1.3919921875 mid:1.393798828125right:1.3956054687500001
 * left:1.3919921875 mid:1.3928955078125right:1.393798828125
 * left:1.3919921875 mid:1.3924438476562502right:1.3928955078125
 * left:1.3924438476562502 mid:1.392669677734375right:1.3928955078125
 * left:1.3924438476562502 mid:1.3925567626953126right:1.392669677734375
 * left:1.3924438476562502 mid:1.3925003051757814right:1.3925567626953126
 * 1.4
 *
 *
 * 方法二：借助牛顿法公式
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo90 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        double num = Double.valueOf(bf.readLine());
        //double  n = getCubeRoot(num);
        double x = Dichotomy(num);
        System.out.printf("%.1f",x);
    }
    //使用类似二分的思路
    public static double Dichotomy(double num) {
        double right , left, mid = 0.0;
        //一定要注意边界条件，输入的num可能是负数  将x<-1的边界范围定为[x,1]，x>1的边界范围定为[-1,x]
        right = Math.max(1.0,num);
        left = Math.min(-1.0,num);
        while (right - left > 0.001) {
            mid = (left + right) / 2;
            //如果乘积大于num，说明立方根在mid的左侧
            if (mid * mid * mid > num) {
                right = mid;
            }
            //如果乘积小于num，说明立方根在mid的右侧
            else if (mid * mid * mid < num) {
                left = mid;
            } else {
                return mid;
            }
        }
        return right;
    }
}


