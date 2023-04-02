package middle;

public class Item34 {

    /*

     在排序数组中查找元素的第一个和最后一个位置
     */
    public int[] searchRange(int[] nums, int target) {
        int left = calLeft(nums, target);
        int last = calRight(nums, target);
        return new int[]{left,last};
    }

    public int calLeft(int[] nums, int target){
        int len = nums.length;
        int left = 0;
        int right = len -1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if (nums[mid] > target){
                right = mid -1;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else if (nums[mid] == target){
                right = mid -1;
            }
        }
        int first;
        if (left == nums.length){
            first = -1;
        }else {
            first = nums[left] == target ? left : -1;
        }
        return first;
    }

    public int calRight(int[] nums, int target){
        int len = nums.length;
        int left = 0;
        int right = len -1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if (nums[mid] > target){
                right = mid -1;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else if (nums[mid] == target){
                left = mid + 1;
            }
        }

        int last;
        if (left - 1 < 0){
            last = -1;
        }else {
            last = nums[left-1] == target ? left - 1 : -1;
        }
        return last;
    }

}
