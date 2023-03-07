package middle;

import java.util.Random;

public class Item528 {

    /*

    按权重随机选择

    实现一个函数，它可以随机地从范围[0,w.length-1]内选出并返回一个下标，选取的概率为w[i]/sum(w)

     */

    /*

        思路：
            根据权重数组生成前缀和数组preSum
            生成一个取值在preSum之内的随机数，用二分搜索法搜索大于等于这个随机数的最小元素索引
            最后对这个索引减1，就可以作为权重数组的索引，即最终答案

     */

    private int[] preSum;
    private Random rand = new Random();

    public Item528(int[] w){
        int n = w.length;
        preSum = new int[n + 1];
        preSum[0] = 0;
        for (int i = 1; i <=n; i++){
            preSum[i] = preSum[i-1] + w[i-1];
        }
    }

    public int pickIndex(){

        int n = preSum.length;
        // 在闭区间[1,preSum[n-1]]中随机选择一个数字
        int target = rand.nextInt(preSum[n-1]) + 1;
        return left_bound(preSum,target) - 1;
    }

    // 在preSum中寻找大于等于target的最小元素索引，应该使用搜索左侧边界的二分搜索
    private int left_bound(int[] nums, int target){
        if (nums.length == 0){
            return -1;
        }
        int left = 0,right = nums.length;
        while (left < right){
            int mid = left + (right - left)/2;
            if (nums[mid] == target){
                right = mid;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else if (nums[mid] > target){
                right = mid;
            }
        }
        return left;
    }

}
