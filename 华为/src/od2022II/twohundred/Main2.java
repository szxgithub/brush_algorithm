package od2022II.twohundred;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main2 {

    /*

    叠积木

    输入为一行，为各个积木的长度，数字为正整数，并由空格分隔，积木的数量和长度都不超过5000

    输出一个数字，为墙的最大层数，如果无法按要求叠成每层长度一致对的墙，则输出-1

     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String[] s = str.split(" ");
        Integer[] ints = Arrays.stream(s).map(value -> Integer.valueOf(value)).toArray(Integer[]::new);

        // 将这个数组划分成k个和相等的子集， 本题目的是求K
        Arrays.sort(ints);

        int sum = 0;
        for (Integer ele : ints){
            sum += ele;
        }

        int m = ints.length;

        while (m > 1) {
            LinkedList<Integer> link = new LinkedList<>();
            Collections.addAll(link, ints);
            if (canPartitionMSubsets(link, sum, m)) {
                System.out.println(m);
                return;
            }
            m--;
        }
        System.out.println(-1);
    }

    public static boolean canPartitionMSubsets(LinkedList<Integer> link, int sum, int m){
        if (sum%m != 0){
            return false;
        }

        int subSum = sum/m;
        if (subSum < link.get(0)){
            return false;
        }

        while (link.size() > 0 && link.get(0) == subSum){
            link.removeFirst();
            m--;
        }

        int[] buckets = new int[m];
        return partition(link,0,buckets,subSum);
    }

    public static boolean partition(LinkedList<Integer> link, int index, int[] buckets, int subSum){
        if (index == link.size()) {
            return true;
        }
        int select = link.get(index);
        for (int i = 0; i<buckets.length; i++){
            if (i > 0 && buckets[i] == buckets[i-1]){
                continue;
            }
            if (select + buckets[i] <= subSum){
                buckets[i] += select;
                if (partition(link,index + 1, buckets, subSum)){
                    return true;
                }
                buckets[i] -= select;
            }
        }
        return false;
    }

}
