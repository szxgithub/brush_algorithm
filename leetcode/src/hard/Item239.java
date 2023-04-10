package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Item239 {

    /*
    滑动窗口最大值
     */

    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            if (i <k-1){
                //先把窗口的前 k - 1 填满
                window.push(nums[i]);
            }else {
                // 窗口开始向前滑动
                window.push(nums[i]);
                res.add(window.max());
                // nums[i - k + 1] 就是窗口最后的元素
                window.pop(nums[i-k+1]);
            }
        }
        int[] arr = new int[res.size()];
        for (int i = 0; i <res.size(); i++){
            arr[i] = res.get(i);
        }
        return arr;
    }

    class MonotonicQueue{
        // 支持在头部和尾部快速增删元素
        LinkedList<Integer> maxq = new LinkedList<>();

        public void push(int n){
            while (!maxq.isEmpty() && maxq.getLast() < n){
                maxq.pollLast();
            }
            maxq.addLast(n);
        }

        public int max(){
            return maxq.getFirst();
        }

        public void pop(int n){
            if (n == maxq.getFirst()){
                maxq.pollFirst();
            }
        }
    }

    public static void main(String[] args) {

        Item239 item239 = new Item239();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] ints = item239.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(ints));
    }

}
