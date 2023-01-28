package od;

import java.util.Arrays;
import java.util.Scanner;

public class Main32 {

    /**
     *
     * 检查是否存在满足条件的数字组合
     *
     * 输入一组数字，数字之间用空格隔开，判断输入的数字是否可以满足A=B+2C，每个元素最多只可用一次。
     * 若有满足的数字组合，依次输出A、B、C三个数字，之间用空格隔开；若无满足条件的组合，输出0。
     *
     *
     * */


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // 数组元素均为正整数
        int[] nums = new int[n];

        for (int i =0; i<n; i++){
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);

        int[] res = new int[3];
        Arrays.fill(res,-1);

        // A > B A >C
        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                for (int k = j + 1; k < nums.length; k++){
                    int A = nums[k];
                    int B = nums[j];
                    int C = nums[i];
                    if (A - B == 2*C){
                        res[0] = A;
                        res[1] = B;
                        res[2] = C;
                        break;
                    }
                }
            }
        }

        if (res[0] == -1){
            System.out.println(0);
        }else {
            System.out.println(res[0] + " " + res[1] + " " + res[2]);
        }
    }

}
