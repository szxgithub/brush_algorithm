package od2023.twohundred;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

    /*

    采样过滤
    请实现一个算法，计算给定一组采样值中正常值的最长连续周期

    判断第一个周期的采样数据S0是否正确的规则如下：
        S[i] <= 0
        s[i] < s[i-1]
        s[i] - s[i-1] >= 10

    判断工具是否故障的规则如下：
        在M个周期内，采样数据为错误值的次数为T，则工具故障

    判断故障恢复的条件如下：
        产生故障后的P个周期内，采样数据一直为正常值，则故障恢复

    错误采样数据的处理方式：
        检查到故障后，丢弃从故障开始到故障恢复的采样数据
        在检测到工具故障之前，错误的采样数据则由最近的一个正常值代替，如果前面没有正常值，则丢弃此采样数据

    给定一段周期的采样数据列表S，计算正常值的最长连续周期

    输入描述：
        输入两行
        M T P
        S1 S2 S3...
    输出描述：
        一行，输出正常值的最长连续周期

    输入：
    10 6 3
    -1 1 2 3 100 10 13 9 10
    输出：8

     */

    /*
    这道题 比较麻烦，可能不考了
    逻辑分析
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 故障确认周期M、故障次数门限T、故障恢复周期P
        Integer[] mtp = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        //  一段周期采样数据列表
        Integer[] s = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        int res = getResult(mtp[0],mtp[1],mtp[2],s);

        System.out.println(res);

    }

    /**
     *
     * @param m 故障周期确认数
     * @param t 故障次数门限值
     * @param p 故障恢复周期数
     * @param s 数组，元素为每个周期的采样数据
     * @return
     */
    private static int getResult(Integer m, Integer t, Integer p, Integer[] s) {

        // 起始位置
        int i = 0;
        // m个周期内错误数据的个数
        int fault = 0;
        // 处于m个周期内第几个周期
        int cycle = 0;

        int ans = 0;

        // 如果数据一开始错误，则直接丢弃
        while (s[i] <= 0){
            i++;
            fault++;
            cycle++;

            if (cycle <= m){
                if (cycle == m){
                    cycle = 0;
                    fault = 0;
                }

                // 如果错误次数达到门限值，则工具故障
                if (fault == t){
                    cycle = 0;
                    fault = 0;
                    int p1 = p;
                    // 产生故障后的P个周期内，采样数据一直为正常值，则故障恢复
                    while (i < s.length && p1 > 0){
                        if (isFault(s,i)){
                            p1 = p;
                        }else {
                            p1--;
                        }
                        i++;
                    }
                }
            }
        }

        cycle++;
        int j = i + 1;
        while (j < s.length){
            cycle++;
            if (isFault(s,j)){
                s[j] = s[j-1];
                fault++;
            }
            j++;
            if (fault == t){
                cycle = 0;
                fault = 0;
                ans = Math.max(ans,j-i);
                int p1 = p;
                while (j < s.length && p1 >0){
                    if (isFault(s,j)){
                        p1 = p;
                    }else {
                        p1--;
                    }
                    i = j;
                }
            }
        }

        ans = Math.max(ans,j-i);
        return ans;
    }

    /**
     * 该方法 用于判断数据值是否错误
     * @param s
     * @param j
     * @return
     */
    public static boolean isFault(Integer[] s, int j){
        return s[j] <= 0 || (j >= 1 && (s[j] < s[j-1] || s[j]-s[j-1] >= 10));
    }

}
