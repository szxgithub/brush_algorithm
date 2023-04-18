package practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {



    }

    public int getResult(LinkedList<Integer> arr, int m){

        arr.sort((a,b)->b-a);

        while (m > 0){
            if (canPartition(arr,m)){
                break;
            }
            m--;
        }

        return m;
    }

    private boolean canPartition(LinkedList<Integer> arr, int m) {

        Integer sum = arr.stream().reduce((a, b) -> a + b).get();

        if (sum%m != 0){
            return false;
        }

        int subSum = sum / m;

        if (arr.get(0) > subSum){
            return false;
        }

        while (arr.size() > 0 && arr.get(0) == subSum){
            arr.removeFirst();
            m--;
        }

        int[] buckes = new int[arr.size()-1];
        return partition(arr,0,buckes,subSum);

    }

    private boolean partition(LinkedList<Integer> arr, int index, int[] buckes, int subSum) {

        if (index == arr.size()){
            return true;
        }

        Integer select = arr.get(index);

        for (int i = 0; i < buckes.length; i++){
            if (i > 0 && buckes[i] == buckes[i-1]){
                continue;
            }
            if (select + buckes[i] <= subSum){
                buckes[i] += select;
                if (partition(arr,i+1,buckes,subSum)){
                    return true;
                }
                buckes[i] -= select;
            }
        }

        return false;
    }


}
