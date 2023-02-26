package od2023.onehundred;

import java.util.*;

public class Main24 {

    /*

    MVP争夺战（星际篮球争霸赛）
    MVP的条件是单场最高分获得者， 可以并列让更多的队员上场，并且让队员得分都相同

    要求输出有得分的队员都是MVP时，最少得MVP得分
    可以理解为：将一段分钟内的得分划分为K个桶内，使得每个桶的分数相同，同时使得桶的分数最低

    这道题和划分K个子集相等类似



    这道题通过率非常低 只有0.71%

     */

    public static int score = 0;    //MVP得分

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();
        String[] p = sc.nextLine().split(" ");

        LinkedList<Integer> link = new LinkedList<>();

        for(int i=0; i<t; i++){
            link.add(Integer.valueOf(p[i]));
        }

        int result = getResult(link, t);
        System.out.println(result);
    }

    /**
     *
     * @param link
     * @param m  可以划分的子集数量
     * @return
     */
    public static int getResult(LinkedList<Integer> link, int m){

        link.sort((a,b) -> b-a);

        int sum = 0;
        for (Integer ele : link){
            sum += ele;
        }

        while (m >= 1){
            LinkedList<Integer> link_cp = new LinkedList(link);
            if (canPartitionMSubsets(link_cp,sum,m)){
                return sum/m;
            }
            m--;
        }

        return sum;

    }

    /**
     *
     * @param link 待划分的元素数组
     * @param sum  元素总和
     * @param m  元素总个数
     * @return
     */
    public static boolean canPartitionMSubsets(LinkedList<Integer> link, int sum, int m){
        if (sum % m != 0){
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

    /**
     *
     * @param link
     * @param index 索引
     * @param buckes 剩下需要装满的桶
     * @param subSum 每个桶的最大容量
     * @return
     */
    public static boolean partition(LinkedList<Integer> link, int index, int[] buckes, int subSum){
        if (index == link.size()){
            return true;
        }

        int select = link.get(index);
        for (int i = 0; i < buckes.length; i++){
            if (i > 0 && buckes[i] == buckes[i-1]){
                continue;
            }
            if (select + buckes[i] <= subSum){
                buckes[i] += select;
                if (partition(link,index+1,buckes,subSum)){
                    return true;
                }
                buckes[i] -= select;
            }
        }
        return false;
    }


}
