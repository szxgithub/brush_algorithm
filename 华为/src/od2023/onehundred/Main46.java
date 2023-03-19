package od2023.onehundred;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main46 {

    /*

    找数字、找等值元素

    给定一个二维数组 ，对于每一个元素num[i]，找出距离最近的值相等的元素，输出横纵坐标差值的绝对值之和，如果没有输出-1

    输入描述：
        第一行二维数组的行
        第二行二维数组的列
        输入的数字以空格隔开
    输出描述：
        数组形式返回所有坐标值

输入：
3
5
0 3 5 4 2
2 5 7 8 3
2 5 4 2 4
输出：
[[-1, 4, 2, 3, 3], [1, 1, -1, -1, 4], [1, 1, 2, 3, 2]]

Process finished with exit code 0


     */


    /*
    逻辑分析解决

    时间复杂度O(m*n*k) m、n为数组行列，k为每个元素相同数字的个数

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

        // arr[i][j] ---> [[i1,j1][i2,j2][i3,j3]...]
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i <arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                // 记录每一个元素位置，以及与其相等的元素的位置
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
            // 存放每一个元素的距离最近的且值相等的元素，与其对应的横纵坐标绝对值之和
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j<col; j++){
                int num = arr[i][j];
                List<int[]> listInts = map.get(num);
                if (listInts.size() == 1){
                    list.add(-1);
                    continue;
                }

                int min = Integer.MAX_VALUE;
                // 遍历相同元素的坐标位置，计算横纵坐标差值的绝对值之和
                for (int k = 0; k<listInts.size(); k++){
                    int[] intnum = listInts.get(k);
                    // 距离为横纵坐标绝对值之和
                    int distance = Math.abs(intnum[0] - i) + Math.abs(intnum[1]-j);
                    if (distance == 0){
                        continue;
                    }
                    min = Math.min(min,distance);
                }
                list.add(min);
            }

            // 计算好一行每列的结果，保存
            resList.add(list);
        }

        System.out.println(resList);
    }

}
