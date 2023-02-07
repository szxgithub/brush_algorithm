package od2023;

import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main59 {

    /*

    找数字

    给定一个二维数组 ，对于每一个元素num[i]，找出距离最近的值相等的元素，输出横纵坐标差值的绝对值之和，如果没有输出-1

     */


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int row = sc.nextInt();
        int col = sc.nextInt();

        int[][] arr = new int[row][col];
        for (int i =0; i<row; i++){
            for (int j = 0; j<col; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        HashMap<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i <arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                List<int[]> tempList;
                if (map.containsKey(arr[i][j])){
                    tempList = map.get(arr[i][j]);
                }else {
                    tempList = new ArrayList<>();
                }
                tempList.add(new int[]{i,j});
                map.put(arr[i][j],tempList);
            }
        }

        List<List<Integer>> resList = new ArrayList<>();
        for (int i = 0;i <row; i++){
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j<col; j++){
                int num = arr[i][j];
                List<int[]> listInts = map.get(num);
                if (listInts.size() == 1){
                    list.add(-1);
                    continue;
                }

                int min = Integer.MAX_VALUE;
                for (int k = 0; k<listInts.size(); k++){
                    int[] intnum = listInts.get(k);
                    int distance = Math.abs(intnum[0] - i) + Math.abs(intnum[1]-j);
                    if (distance == 0){
                        continue;
                    }
                    min = Math.min(min,distance);
                }
                list.add(min);
            }

            resList.add(list);
        }

        System.out.println(resList);
    }

}
