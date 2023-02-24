package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Item1238 {

    /*

    循环码排列

    给你两个整数 n 和 start。你的任务是返回任意 (0,1,2,,...,2^n-1) 的排列 p，并且满足：

    p[0] = start
    p[i] 和 p[i+1] 的二进制表示形式只有一位不同
    p[0] 和 p[2^n -1] 的二进制表示形式也只有一位不同
     */

    /*

    在格雷码的运算中，十进制的0、1、2、3、....每一位的2进制表现形式都只比上一个数字的2进制相差一个数字
     那么第一步先构造一个从0到2^n-1的格雷码形式的数组。 二进制转格雷码为：G = B ^ B >> 1

     */
    public List<Integer> circularPermutation(int n, int start){

        List<Integer> ret = new ArrayList<>();
        ret.add(start);
        for (int i = 1; i <= n; i++){
            int m = ret.size();
            for (int j = m-1; j>= 0; j--){
                int tmp = ((ret.get(j) ^ start) | (1 << (i - 1))) ^ start;
                ret.add(tmp);
            }
        }

        return ret;
    }

    public static void main(String[] args) {

        Item1238 item1238 = new Item1238();
        int n = 3, start = 2;
        List<Integer> integers = item1238.circularPermutation(n, start);
        System.out.printf(Arrays.toString(integers.toArray()));

    }

}
