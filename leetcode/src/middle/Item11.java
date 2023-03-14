package middle;

public class Item11 {

    /*
    盛最多水的容器
    这道题类似“接雨水”问题
     */

    /*
    暴力解法 测试用例通过90%
     */
    public int maxArea(int[] height){
        int max = 0;
        for (int i = 0; i< height.length; i++){
            for (int j = i+1; j<height.length; j++){
                int min = Math.min(height[i], height[j]);
                max = Math.max(max, min * (j - i));
            }
        }
        return max;
    }

    int maxArea2(int[] height){
        int left = 0, right = height.length - 1;
        int res = 0;
        while (left < right){
            int cur_area = Math.min(height[left], height[right])*(right-left);
            res = Math.max(res,cur_area);
            if (height[left] < height[right]){
                left++;
            }else {
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = {1,1};
        Item11 item11 = new Item11();
        int i = item11.maxArea(height);
        System.out.println(i);
    }

}
