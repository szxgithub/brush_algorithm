package middle;

public class Item1144 {

    /*

    递减元素使数组呈锯齿状


     */

    public int movesToMakeZigzag(int[] nums){
      int[] s = new int[2];
      for (int i = 0; i < nums.length; i++){
          int left = i > 0 ? nums[i-1] : Integer.MAX_VALUE;
          int right = i < nums.length-1 ? nums[i+1] : Integer.MAX_VALUE;
          s[i%2] += Math.max(nums[i] - Math.min(left,right) + 1, 0);
      }

      return Math.min(s[0], s[1]);

    }

    public static void main(String[] args) {

        Item1144 item1144 = new Item1144();

        // int[] nums = {1,2,3};
         int[] nums = {9,6,1,6,2};

        int i = item1144.movesToMakeZigzag(nums);
        System.out.println(i);
    }

}
