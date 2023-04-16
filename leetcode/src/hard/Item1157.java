package hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Item1157 {

    /*

    子数组中占绝大多数的元素

     */

    class MajorityChecker {

        int n;
        public int[]  count = new int[20002];
        public int[] res;
        public MajorityChecker(int[] arr) {
            n = arr.length;
            res = Arrays.copyOfRange(arr, 0, n);
        }

        public int query(int left, int right, int threshold){
            Arrays.fill(count,0);
            for (int i = left; i <=right; i++) {
                count[res[i]]++;
                if(count[res[i]]>=threshold) return res[i];
            }
            return -1;
        }
    }

}
