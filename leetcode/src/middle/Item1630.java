package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Item1630 {

    /*

    等差子数组
     */

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();
        outer:
        for (int i = 0; i < r.length; i++){
            List<Integer> list = new ArrayList<>();
            for (int j = l[i]; j <= r[i]; j++){
                list.add(nums[j]);
            }
            list.sort((a,b)->a-b);
            int tmp = list.get(1) - list.get(0);
            for (int k = 0; k + 1 <list.size(); k++){
                if (list.get(k + 1) - list.get(k) != tmp){
                    ans.add(false);
                    continue outer;
                }
            }
            ans.add(true);
        }
        return ans;
    }

    public static void main(String[] args) {

        Item1630 item1630 = new Item1630();
        int[] nums = {-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10};
        int[] l = {0,1,6,4,8,7};
        int[] r = {4,4,9,7,9,10};
        List<Boolean> booleans = item1630.checkArithmeticSubarrays(nums, l, r);
        System.out.println(booleans);

    }

}
