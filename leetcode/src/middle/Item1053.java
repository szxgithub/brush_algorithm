package middle;

import java.util.Arrays;

public class Item1053 {

    /*
    交换一次的先前排列

     */
    /*
    贪心思想
    如果遍历完数组都没找到满足条件的下标i，说明数组已经是最小排列，直接返回原数组即可
     */
    public int[] prevPermOpt1(int[] arr) {
        int n = arr.length;
        for (int i = n-1; i > 0; i--){
            if (arr[i-1] > arr[i]){
                for (int j = n-1; j > i-1; --j){
                    if (arr[j] < arr[i-1] && arr[j] != arr[j-1]){
                        int t = arr[i-1];
                        arr[i-1] = arr[j];
                        arr[j] = t;
                        return arr;
                    }
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Item1053 item1053 = new Item1053();
        int[] arr = {1,9,4,6,7};
        int[] ints = item1053.prevPermOpt1(arr);
        System.out.println(Arrays.toString(ints));
    }

}
