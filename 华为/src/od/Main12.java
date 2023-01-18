package od;

import java.util.Scanner;

public class Main12 {

    /**
     *
     * 求坐标轴上画出图形的面积
     *
     *https://blog.csdn.net/weixin_47243236/article/details/122758715?spm=1001.2101.3001.6650.13&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7ERate-13-122758715-blog-123861737.pc_relevant_default&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7ERate-13-122758715-blog-123861737.pc_relevant_default&utm_relevant_index=20
     *
     * */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){

            int row = sc.nextInt();

            int endX = sc.nextInt();

            int[][] xy = new int[row][2];
            for (int i = 0; i< row; i++){
                for (int j = 0; j<2; j++){
                    xy[i][j] = sc.nextInt();
                }
            }

            int area = 0, preX = 0, preY =0;

            for (int i= 0; i<row; i++){
                area += (xy[i][0] - preX)*preY;
                preX = xy[i][0];
                preY += xy[i][1];
            }

            area += preY*(endX - preX);
            System.out.println(area);

        }

    }

}
