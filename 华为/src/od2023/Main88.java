package od2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main88 {

    /*
    取出尽量少的球

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
            int maxCapacity = 0;
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
