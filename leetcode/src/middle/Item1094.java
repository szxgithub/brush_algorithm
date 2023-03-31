package middle;

public class Item1094 {

    /*
    拼车
     */

    public boolean carPooling(int[][] trips, int capacity) {

        int[] nums = new int[1001];
        Difference df = new Difference(nums);

        for (int[] trip : trips){
            int val = trip[0];
            int i = trip[1];
            int j = trip[2];
            df.increment(i,j-1,val);
        }

        int[] result = df.result();
        for (int i = 0; i < result.length; i++){
            if (result[i] > capacity){
                return false;
            }
        }
        return true;
    }

    /*
    定义一个差分类
     */
    class Difference{
        private int[] diff;
        public Difference(int[] nums){
            diff = new int[nums.length];
            diff[0] = nums[0];
            for (int i = 1; i < diff.length; i++){
                diff[i] = nums[i] - nums[i-1];
            }
        }

        public void increment(int i, int j, int val){
            diff[i] += val;
            if (j + 1 < diff.length){
                diff[j+1] -= val;
            }
        }

        public int[] result(){
            int[] res = new int[diff.length];
            res[0] = diff[0];
            for (int i = 1; i < res.length; i++){
                res[i] = diff[i] + res[i-1];
            }
            return res;
        }
    }

}
