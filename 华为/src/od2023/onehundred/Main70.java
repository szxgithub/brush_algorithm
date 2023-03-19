package od2023.onehundred;

import java.util.Arrays;
import java.util.Scanner;

public class Main70 {

    /*
    日志限流
    由于系统磁盘空间限制，每天可记录保存的日志总数上限为total条
    如果一天产生的日志超出total条，则需要每天进行限流后保存，请计算每单位时间最大可保存日志条数limit，以确保当天总数不超过total条


    输入描述：
        第一行为系统某一天运行的单位时间数N
        第二行为这一天每单位时间产生的日志数量的数组records[]
        第三行为系统一天可以保存的日志总条数total
    输出描述：
        每单位时间内可以保存最大日志条数limit,如果不需要启动限流机制，返回-1

输入：
6
3 3 8 7 10 15
40
输出：
9

     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // 单位时间数
        int N = sc.nextInt();
        sc.nextLine();

        // 每单位时间产生日志数记录
        int[] records = new int[N];
        for (int i = 0; i<records.length; i++){
            records[i] = sc.nextInt();
        }

        // 系统一天可以保持的最大日志总数
        int total = sc.nextInt();

        int result = getResult(N, records, total);
        System.out.println(result);


    }

    /*

    二分查找方法

     */
    private static int getResult(int n, int[] records, int total) {

        int sum = Arrays.stream(records).reduce(Integer::sum).getAsInt();

        if (sum <= total){
            return - 1;
        }

        int max_limit = Arrays.stream(records).max().getAsInt();
        int min_limit = total/n;

        int ans = min_limit;
        while (max_limit - min_limit > 1){
            int limit = (max_limit + min_limit)/2;
            int tmp = 0;
            for (int record : records){
                // 如果record数量小于等于limit，则不做限流，如果大于limit，则限流limit条
                tmp += Math.min(record,limit);
            }

            if (tmp > total){
                max_limit = limit;
            }else if (tmp < total){
                min_limit = limit;
                ans = limit;
            }else {
                return limit;
            }
        }

        return ans;

    }

}
