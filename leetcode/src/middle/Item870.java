package middle;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Item870 {

    /*

    优势洗牌  田忌赛马问题的加强版
     */

    public int[] advantageCount(int[] nums1, int[] nums2){

        int n = nums1.length;

        Arrays.sort(nums1);

        // 大顶堆  每次返回nums2中数最大的一个，包含索引和大小
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[1]-a[1]);
        for (int i = 0; i<n; i++){
            pq.offer(new int[]{i,nums2[i]});
        }

        int left = 0, right = n-1;
        int[] res = new int[n];
        while (!pq.isEmpty()){
            int[] poll = pq.poll();
            int i = poll[0], maxVal = poll[1];
            if (maxVal < nums1[right]){
                res[i] = nums1[right];
                right--;
            }else {
                res[i] = nums1[left];
                left++;
            }
        }

        return res;
    }

}
