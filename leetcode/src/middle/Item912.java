package middle;

import java.util.Arrays;

public class Item912 {

    /*
    排序数组
     */

    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums;
    }

    private void quickSort(int[] arr, int start, int end) {
        if (start >= end){
            return;
        }
        int middle = partition(arr,start,end);
        quickSort(arr,start,middle-1);
        quickSort(arr,middle+1,end);
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int left = start + 1;
        int right = end;
        while (left < right){
            while (left < right && arr[left] <= pivot){
                left++;
            }
            if (left != right){
                exchange(arr,left,right);
                right--;
            }
        }
        if (left == right && arr[right] > pivot){
            right--;
        }
        if (right != start){
            exchange(arr,start,right);
        }
        return right;
    }

    public void exchange(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Item912 item912 = new Item912();
        int[] nums = {5,2,3,1};
        item912.quickSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

}
