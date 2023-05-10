package hard;

import java.util.HashMap;

public class Item2106 {

    /*
    摘水果

     */

    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int len=fruits.length;
        int[] sum=new int[len+1];
        for(int i=1;i<=len;i++){
            sum[i]=sum[i-1]+fruits[i-1][1];
        }

        int[] pos=new int[len];
        for(int i=0;i<len;i++){
            pos[i]=fruits[i][0];
        }

        int ans=0;
        for(int x=k;x>=0;x--){
            int y=(k-x)/2;

            //向左走x向右走y
            int l=startPos-x;
            int r=startPos+y;
            int pl = lowerBound(pos,0,pos.length-1, l) ;
            int pr = upperBound(pos,0,pos.length-1, r);
            ans=Math.max(ans,sum[pr]-sum[pl]);

            //向左走y向右走x
            l = startPos - y;
            r = startPos + x;
            pl = lowerBound(pos,0,pos.length-1, l) ;
            pr = upperBound(pos,0,pos.length-1, r);
            ans=Math.max(ans,sum[pr]-sum[pl]);

        }
        return ans;
    }

    //二分查找第一个大于target的数组下标
    public int upperBound(int[] nums,int left,int right,int target) {
        int ans=nums.length;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]>target){
                ans=mid;
                right= mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return ans;
    }

    //二分查找第一个大于等于target的数组下标
    public int lowerBound(int[] nums,int left,int right,int target){
        int ans=nums.length;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]>=target){
                ans=mid;
                right= mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return ans;
    }



}
