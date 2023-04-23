package middle;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Item1027 {

    /*
    最长等差数列

     */

    /**
     * 回溯暴力解法 通过率50%
     */
    private int max = 2;
    public int longestArithSeqLength(int[] nums) {

        backtracking(nums,0, new ArrayList<>());
        return max;
    }

    private boolean judge(List<Integer> list) {
        int temp = list.get(1) - list.get(0);
        for (int i = 1; i < list.size(); i++){
            if (list.get(i) - list.get(i-1) != temp){
                return false;
            }
        }
        return true;
    }

    private void backtracking(int[] nums, int index, List<Integer> list) {

        if (index == nums.length+1){
            return;
        }

        if (list.size() > 2){
            if (!judge(list)){
                return;
            }else {
                if (list.size() > max){
                    max = list.size();
                }
            }
        }

        for (int i = index; i < nums.length; i++){
            list.add(nums[i]);
            backtracking(nums,i+1, list);
            list.remove(list.size()-1);
        }

    }



    public static void main(String[] args) {
        Item1027 item1027 = new Item1027();
        int[] nums = {12,28,13,6,34,36,53,24,29,2,23,0,22,25,53,34,23,50,35,43,53,11,48,56,44,53,31,6,31,57,46,6,17,42,48,28,5,24,0,14,43,12,21,6,30,37,16,56,19,45,51,10,22,38,39,23,8,29,60,18};
        int i = item1027.longestArithSeqLength(nums);
        System.out.println(i);
    }


    private Map<Integer,Integer>[] maxlen;
    private int[] a;
    private int ans;
    public int longestArithSeqLength2(int[] nums) {
        a = nums;
        int n = a.length;
        maxlen = new HashMap[n];

        for (int i = 1; i < n; i++){
            dfs(i);
        }
        return ans;
    }

    private Map<Integer,Integer> dfs(int i){
        if (maxlen[i] != null){
            return maxlen[i];
        }
        maxlen[i] = new HashMap<>();
        for (int j = i - 1; j >= 0; j--){
            int d = a[i] - a[j];
            if (!maxlen[i].containsKey(d)){
                maxlen[i].put(d,dfs(j).getOrDefault(d,1) + 1);
                ans = Math.max(ans,maxlen[i].get(d));
            }
        }
        return maxlen[i];
    }



}
