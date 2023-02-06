package od2023;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main48 {

    /*
    最少数量线段覆盖

    排序贪心


     */



    public static List<Line> lineList = new ArrayList<>();  //线段集合
    public static int minLeft = Integer.MAX_VALUE; //左边界
    public static int maxRight = 0;     //右边界
    public static int res = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        for(int i=0; i<n; i++){
            String[] strings = sc.nextLine().split(",");
            int l = Integer.valueOf(strings[0]);
            minLeft = Math.min( minLeft, l);    //左边界为左坐标最小值
            int r = Integer.valueOf(strings[1]);
            maxRight = Math.max( maxRight, r);  //右边界为有坐标最大值
            Line line = new Line( l, r);
            lineList.add(line);
        }

        Collections.sort(lineList);
        for(int i=0; i<lineList.size(); i++){
            Line line = lineList.get(i);
            if(line.left == minLeft){   //第一根线段（左坐标等于左边界）
                handle( i+1, line.left, line.right, 1);
            }
        }

        System.out.println(res);
    }

    /**
     *
     * @param index     紧接着的一个线段的索引（因为排过序，前面的线段无需考虑）
     * @param left      前一线段的左坐标
     * @param right     前一线段的右坐标
     * @param count     线段的个数
     */
    public static void handle(int index, int left, int right, int count){

        if(right == maxRight){  //到了右边界，说明覆盖了所有线段
            res = Math.min( res, count);
        }else {
            for(int i=index; i<lineList.size(); i++){
                Line line = lineList.get(i);
                if(line.left > left && line.left <= right && line.right > right){
                    handle( i+1, line.left, line.right, count+1);
                }
            }
        }

    }

    static class Line implements Comparable<Line>{

        int left;
        int right;

        public Line(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Line o) {
            if(o.left == this.left){
                return this.right - o.right;
            }
            return this.left - o.left;
        }
    }

}
