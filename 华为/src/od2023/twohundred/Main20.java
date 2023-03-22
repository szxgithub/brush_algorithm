package od2023.twohundred;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.*;
import java.util.stream.Collectors;

public class Main20 {

    /*

    分奖金
    通过游戏的方式决定每个人分多少钱，按照工号顺序，每个人抽取一个数字
    遇到第一个数字比自己数字大的，那么前面的员工就可以获得 “距离*数字差值”的奖金
    如果遇不到，就给自己分配随机数量的奖金

    输入描述：
        第一行n表示员工的数量
        第二是每位员工分配的随机数字
    输出描述：
        最终每位员工分到的奖金数量
输入：
3
2 10 3
输出：
8 10 3

     */

    /*
    简单思路  暴力循环
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 员工的数量
        int n = sc.nextInt();

        // 每位员工分配的随机数字
        int[] nums = new int[n];
        for (int i =0; i<nums.length; i++){
            nums[i] = sc.nextInt();
        }

        for (int i =0 ;i<nums.length; i++){
            for (int j =i+1; j < nums.length; j++){
                //找到第一个数字比自己数字大的，那么前面的员工就可以获得 “距离*数字差值”的奖金
                if (nums[j] > nums[i]){
                    nums[i] = (nums[j] - nums[i])*(j-i);
                }
            }
        }

        // 输出每位员工最终分的奖金数量
        String collect = Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(collect);

    }

    /*
    优化时间复杂度解法  时间复杂度O(n)
    利用栈结构找出数组每一个元素的下一个更大值

     */
    public String getResult(int[] arr, int m){
        LinkedList<Integer[]> stack = new LinkedList<>();

        // 数组存放的是每一个位置比它大的元素所在的位置下标
        Integer[] nextBigger = new Integer[m];
        Arrays.fill(nextBigger,-1);

        for (int i = 0; i <arr.length; i++){
            while (stack.size() > 0){
                Integer[] peek = stack.peek();
                int idx = peek[0];
                int val = peek[1];

                if (arr[i] > val){
                    stack.pop();
                    nextBigger[idx] = i;
                }else {
                    break;
                }
            }

            Integer[] ele = {i,arr[i]};
            stack.push(ele);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++){
          Integer idx = nextBigger[i];
          if (idx == -1){
              // 说明前面不存在比它大的元素
              ans.add(arr[i]);
          }else {
              ans.add((idx-i)*(arr[idx] - arr[i]));
          }
        }

        StringJoiner sj = new StringJoiner(" ","","");
        for (Integer an : ans){
            sj.add(an + "");
        }

        return sj.toString();
    }

}
