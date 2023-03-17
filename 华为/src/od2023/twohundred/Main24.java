package od2023.twohundred;


import java.util.*;

public class Main24 {

    /*

    最多等和不相交连续子序列

    给定一个数组，称其中连续的元素为连续子序列，称这些元素的和为连续子序列的和
    数组中可能存在几组子序列，组内的连续子序列互不相交且有相同的和
    求一组连续子序列，组内子序列的数目最多，输出这个数目

    输入描述：
         第一行输入为数组长度N
         第二行为N个用空格分开的整数
    输出描述：
        一个整数，表示满足要求的最多的组内子序列的数目
输入：
10
8 8 9 1 9 6 3 9 1 0
输出：
4

     */
    /*
    将和相同的连续子区间统计在一起
    求解每个和对应的最大不相交子区间的数量，保留最大一个作为题解
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr= new int[n];
        for (int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        int res = getResult(arr,n);

        System.out.println(res);

    }

    private static int getResult(int[] arr, int n) {

        // 记录相同和的连续子序列的区间
        HashMap<Integer,List<Integer[]>> ranges = new HashMap<>();

        // 前缀和数组
        int[] dp = new int[n];
        dp[0] = arr[0];
        for (int i = 1; i <n; i++){
            dp[i] = dp[i-1] + arr[i];
        }

        for (int i = 0; i <n; i++){
            for (int j = i; j <n; j++){
                if (i == 0){
                    int sum = dp[j];
                    ranges.putIfAbsent(sum,new ArrayList<>());
                    ranges.get(sum).add(new Integer[]{0,j});
                }else {
                    int sum = dp[j] - dp[i-1];
                    ranges.putIfAbsent(sum,new ArrayList<>());
                    ranges.get(sum).add(new Integer[]{i,j});
                }
            }
        }

        int max = 0;
        for (Integer key : ranges.keySet()){
            List<Integer[]> range = ranges.get(key);
            max = Math.max(max,disjoint(range));
        }
        return max;
    }

    /*
    求不相交区间的最大个数
     */
    public static int disjoint(List<Integer[]> ranges){
        int count  =  1;
        // 将区间按右边界升序
        ranges.sort((a,b) -> a[1] - b[1]);
        Integer t = ranges.get(0)[1];
        for (int i = 1; i <ranges.size(); i++){
            Integer[] range = ranges.get(i);
            Integer l = range[0];
            Integer r = range[1];
            if (t < l){
                count++;
                t = r;
            }
        }
        return count;
    }

}


