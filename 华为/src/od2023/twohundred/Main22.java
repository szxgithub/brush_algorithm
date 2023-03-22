package od2023.twohundred;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main22 {

    /*
    优雅数组
    一个数组中出现次数最多的元素出现大于等于K次，被称为K-优雅数组

    给定一个数组A和K，请求出A有多少子数组是K-优雅数组

    输入描述：
        第一行，A数组的长度  及K值
        第二行A数组元素，以空格隔开
        数组A中的元素满足： 1<=A[i] <= n
    输出描述：
        输出A有多少个子数组是K-优雅数组

输入：
7 2
1 2 3 1 2 3 1
输出：
10

     */

    /*
    滑动窗口的解题思想
    若博豆的题解  似乎不是满分
     */
    public static void main1(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 数组的长度
        int n = sc.nextInt();
        // 优雅阈值
        int k = sc.nextInt();

        int[] nums = new int[n];
        for (int i =0; i<nums.length; i++){
            nums[i] = sc.nextInt();
        }

        // 将数组中的数字作为index 新建一个长度的数组  数组中的数字则是index出现的次数
        int[] lenInts = new int[n+1];
        int res = 0;
        int right = 0;
        for (int i =0; i <n; i++){
            if (i > 0){
                // 相当于左滑
                lenInts[nums[i-1]]--;
            }else {
                lenInts[nums[i]]++;
            }

            // 最大值为数组中元素出现的次数最多
            int max = Arrays.stream(lenInts).max().getAsInt();
            if (max == k){
                res += n -right;
                continue;
            }

            // 相当于右滑
            for (int j = right + 1; j<n; j++){
                lenInts[nums[j]]++;
                max = Arrays.stream(lenInts).max().getAsInt();
                if (max == k){
                    res += n -j;
                    right = j;
                    break;
                }
            }
        }

        System.out.println(res);

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 数组的长度
        int n = sc.nextInt();
        // 优雅阈值
        int k = sc.nextInt();

        Integer[] nums = new Integer[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }

        Integer result = getResult(nums, n, k);
        System.out.println(result);

    }

    /*
    双指针  推荐这个方法
     */
    public static Integer getResult(Integer[] arr, Integer n, Integer k){
        int ans = 0;
        int l = 0;
        int r = 0;
        // 窗口
        HashMap<Integer,Integer> count = new HashMap<>();

        while (l <n && r <n){
            Integer c = arr[r];
            count.put(c,count.getOrDefault(c,0) + 1);
            if (count.get(c) >= k){
                // 从当前r往后到数组末尾，全部符合
                ans += n -r;

                // 左指针移动，同时更新窗口内记录的字符数量
                count.put(arr[l],count.get(arr[l]) - 1);
                l++;

                // 右指针右移前，做一次左移
                count.put(c,count.get(c) - 1);
                r--;
            }
            r++;
        }
        return ans;
    }

}
