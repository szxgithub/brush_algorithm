package od2023.onehundred;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class Main16 {

    /*

    相同数字的积木游戏1（积木最远距离）

    请找到这排积木中数字相同且所处位置最远的2块积木，计算它们的距离， 如果都不相同，输出-1

     */

    /*
    暴力求解  时间复杂度为O(n^2)
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // 积木总数
        int N = sc.nextInt();

        // 拍成一排的积木上的数字
        int[] nums = new int[N];
        for (int i=0;i < nums.length; i++){
            nums[i] = sc.nextInt();
        }

        int ans = 0;
        for (int i = 0; i< nums.length; i++){
            for (int j = i+1; j < nums.length; j++){
                if (nums[j] == nums[i]){
                    ans = Math.max(ans,j-i);
                }
            }
        }
        if (ans == 0){
            System.out.println(-1);
        }else {
            System.out.println(ans);
        }

    }

    /*
    时间复杂度为O(n)  推荐这个方法
     */
    public static int getResult(int[] arr) {
        HashMap<Integer, LinkedList<Integer>> idx = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            idx.putIfAbsent(num, new LinkedList<>());
            idx.get(num).add(i);
        }

        int ans = -1;

        for (Integer k : idx.keySet()) {
            LinkedList<Integer> link = idx.get(k);
            if (link.size() > 1) {
                ans = Math.max(ans, link.getLast() - link.getFirst());
            }
        }

        return ans;
    }

}
