package hard;

public class Item982 {

    /*
    按位与为零的三元组

     */


    /*
        暴力求解  大部分通过，最后超时, 这里优化了下时间复杂度
     */
    public int countTriplets(int[] nums){
        int[] cnt = new int[1<<16];
        int count = 0;
        for (int i = 0; i< nums.length; i++){
            for (int j = 0; j < nums.length; j++){
                cnt[nums[i]&nums[j]]++;
            }
        }

        for (int k = 0; k <nums.length; k++){
            for (int l = 0; l <cnt.length; l++){
                if ((nums[k]&l) == 0){
                    count += cnt[l];
                }
            }
        }

        return count;

    }

    public static void main(String[] args) {

        Item982 item982 = new Item982();
        int[] nums = {2,1,3};
        // int[] nums = {0,0,0};
        int i = item982.countTriplets(nums);
        System.out.println(i);

    }

}
