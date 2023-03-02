package od2023.onehundred;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main38 {

    /*
        通信误码

        信号传播过程中会出现一些误码，不同的数字表示不同的误码ID，用一个数组记录误码出现的情况，每个误码出现的次数代表误码频度
        请找出记录中包含频度最高误码的最小子数组长度

        输入：
        7
        1 2 2 4 2 1 1
        输出：4
     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] nums = new int[N];
        for (int i =0; i<N; i++){
            nums[i] = sc.nextInt();
        }

        //找出频度最高的最小子数组的长度
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i =0; i <N; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        }

        int max = Integer.MIN_VALUE;
        // 用于记录频度最高的误码，可能存在多个相同频度最高的误码
        List<Integer> ids = new ArrayList<>();
        for (Integer num : map.keySet()){
            if (map.get(num) > max){
                ids.clear();
                max = map.get(num);
                ids.add(num);
            }else if (map.get(num) == max){
                ids.add(num);
            }
        }

        int min = Integer.MAX_VALUE;
        int first = 0;
        // 根据频度最高对应的误码，找出每个误码第一次出现的索引和最后一次出现的索引
        for (int k = 0; k <ids.size(); k++){
            Integer ID = ids.get(k);
            for (int i =0; i<N; i++){
                if (nums[i] == ID){
                    first = i;
                    break;
                }
            }

            int last = 0;
            for (int i = N-1; i>=0; i--){
                if (nums[i] == ID){
                    last = i;
                    break;
                }
            }

            min = Math.min(min,last-first + 1);

        }
        System.out.println(min);


    }

}
