package 程序员面试经典.middle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Item2 {

    /*
    面试题 17.05. 字母与数字

给定一个放有字母和数字的数组，找到最长的子数组，且包含的字母和数字的个数相同。

     */

    /*
    暴力破解 超时 50%通过
     */
    public String[] findLongestSubarray(String[] array){
        int max = 0;
        String[] res = {};
        for (int i = 0; i < array.length; i++){
            for (int j = i + 1; j < array.length + 1; j++){
                String[] strings = Arrays.copyOfRange(array, i, j);
                boolean handle = handle(strings);
                if (handle){
                    if (strings.length > max){
                        max = strings.length;
                        res = strings;
                    }
                }
            }
        }
        return res;
    }

    private boolean handle(String[] strings) {
        int letterCnt =0;
        int numberCnt = 0;
        for (int i = 0;  i<strings.length; i++){
            if (Character.isLetter(strings[i].charAt(0))){
                letterCnt++;
            }else {
                numberCnt++;
            }
        }
        if (letterCnt == numberCnt){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        Item2 item2 = new Item2();
        String[] array = {"A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"};
        // String[] array = {"A","A"};
        // String[] array = {"A","1"};
        String[] longestSubarray = item2.findLongestSubarray2(array);
        System.out.println(Arrays.toString(longestSubarray));
    }


    /*
    前缀和  +  哈希表

    将字母看着1， 数字看着-1，，数字和字母数量相等，必定数组元素之和为0

     */
    public String[] findLongestSubarray2(String[] array){

       int n = array.length;
       int[] sum = new int[n + 1];

       for (int i = 0; i<n; i++){
           sum[i + 1] = sum[i] + (array[i].charAt(0) >> 6 & 1)*2-1;
       }

       int begin = 0;
       int end = 0;
       HashMap<Integer,Integer> map = new HashMap<>();

       for (int i=0; i <= n; i++){
           Integer j = map.getOrDefault(sum[i], -1);
           if (j < 0){
               map.put(sum[i],i);
           }else if ( i - j > end - begin){
               begin = j;
               end = i;
           }
       }

       String[] res  = new String[end - begin];

       System.arraycopy(array,begin,res,0, res.length);
       return res;

    }

}
