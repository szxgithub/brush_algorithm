package od2023.twohundred;

import java.util.*;

public class Main7 {

    /*
    最少数量线段覆盖（区间交叠问题）
    给定坐标轴上的一组线段，线段的起点和终点均为整数，并且长度不小于1，请从中找到最少数量的线段，这些线段可以覆盖所有线段

    排序贪心


     */



    public static List<Line> lineList = new ArrayList<>();  //线段集合
    public static int minLeft = Integer.MAX_VALUE; //左边界
    public static int maxRight = 0;     //右边界
    public static int res = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 线段数量
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

    /*
    贪心排序
     */
    public int getResult(Integer[][] ranges){
        Arrays.sort(ranges,(a,b)->a[0]-b[0]);
        LinkedList<Integer[]> stack = new LinkedList<>();
        stack.add(ranges[0]);
        for (int i = 1; i < ranges.length; i++){
            Integer[] range = ranges[i];
            while (true){
                if (stack.size() == 0){
                    stack.add(range);
                    break;
                }
                Integer[] top = stack.getLast();
                int s0 = top[0];
                int e0 = top[1];

                int s1 = range[0];
                int e1 = range[1];

                if (s1 <= s0){
                    if (e1 <= s0){
                        break;
                    }else if (e1 < e0){
                        break;
                    }else {
                        stack.removeLast();
                    }
                }else if (s1 < e0){
                    if (e1 <= e0){
                        break;
                    }else {
                        stack.add(new Integer[]{e0,e1});
                        break;
                    }
                }else {
                    stack.add(range);
                    break;
                }
            }
        }
        return stack.size();
    }

}
