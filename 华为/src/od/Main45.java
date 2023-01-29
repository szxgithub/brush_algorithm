package od;

import java.util.Scanner;
import java.util.Stack;

public class Main45 {

    /**
     *
     *
     * 计算堆栈中的剩余数字
     *
     * 5 10 20 50 85 1
     * 1 170
     *
     * 6 7 8 13 9
     * 9 13 8 7 6
     *
     *
     * */


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] strings = sc.nextLine().split(" ");

        int[] nums = new int[strings.length];

        for (int i=0; i<nums.length; i++){
            nums[i] = Integer.parseInt(strings[i]);
        }

        Stack<Integer> stack = new Stack<>();

        for (int i =0; i < nums.length; i++){
            if(!stack.isEmpty()){
                int sum = 0;
                for (int j = 0; j < i; j++){
                    sum += nums[j];
                }
                if (sum == nums[i]){
                    while (!stack.isEmpty()){
                        stack.pop();
                    }
                    stack.push(nums[i]*2);
                    continue;
                }
            }
            stack.push(nums[i]);
        }

        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }

}
