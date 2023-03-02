package od2023.onehundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main41 {

    /*
    取出尽量少的球（开放日活动） todo

    某部门开展Family Day开放日活动，其中有个从桶里取球的游戏，游戏规则如下：
    有个N个容量一样的小桶等距排开
    每个桶里都默认装了数量不等的小球
    每个桶的小球数量记录在bucketBallNums中，
    要求所有桶的小球总数不超过SUM，如果超过SUM，则需要对所有桶设置一个统一的容量最大值maxCapacity
    请你根据输入的数据，计算从每个小桶里拿出的小球数量


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
    根据题意模拟  从maxCapacity=1开始
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 所有桶的小球总数不超过SUM
        int sum = sc.nextInt();

        // N个小桶
        int N = sc.nextInt();

        int[] bucketBallNums = new int[N];
        for (int i =0 ;i <bucketBallNums.length; i++){
            bucketBallNums[i] = sc.nextInt();
        }

        // 如果小球总数超过SUM, 设置一个容量最大值maxCapacity，将超过容量最大值的球拿出来，直到小于maxCapacity
        // 计算拿出来的小球数量

        List<Integer> res = new ArrayList<>();
        int total = Arrays.stream(bucketBallNums).sum();

        int remainTotal = 0;
        if (total > sum){
            // 不需要从maxCapacity=0开始，使用sum/bucket.length求得一个理想的值， 然后向后查找
            int maxCapacity = total/N - 1;
            while (remainTotal <= sum){
                remainTotal = 0;
                maxCapacity++;
                for (int i =0; i<bucketBallNums.length; i++){
                    if (bucketBallNums[i] >= maxCapacity){
                        remainTotal += maxCapacity;
                    }else {
                        remainTotal += bucketBallNums[i];
                    }
                }
            }
            maxCapacity--;
            for (int i =0; i < bucketBallNums.length; i++){
                if (maxCapacity >= bucketBallNums[i]){
                    res.add(0);
                }else {
                    res.add(bucketBallNums[i] - maxCapacity);
                }
            }
            System.out.println(res);
        }else {
            System.out.println(res);
        }

    }


}
