package middle;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Item1792 {

    /*

    最大平均通过率

    给你一个二维数组 classes ，其中 classes[i] = [passi, totali]

    求所有班级的最大平均通过率

    最大平均通过率 == 最大化总通过率

    增加的通过率：x+1/y+1 - x/y
    x+2/y+2 - x+1/y+1 < x+1/y+1 - x/y


     */

    public double maxAverageRatio(int[][] classes, int extraStudents){
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            double b = (o2[0] + 1D) / (o2[1] + 1D) - o2[0] * 1D / o2[1];
            double a = (o1[0] + 1D) / (o1[1] + 1D) - o1[0] * 1D / o1[1];
            int compare = Double.compare(b, a);
            return compare;
        });

        for (int[] a : classes){
            queue.add(a);
        }

        // 每次选择那个可以使得通过率的增加量最大的班级放入一名学生
        for (int i = 0; i<extraStudents; i++){
            int[] a = queue.poll();
            queue.add(new int[]{a[0]+1,a[1] + 1});
        }

        // 求最大总通过率
        double sum = 0;
        for (int[] a : queue){
            sum += a[0]*1D/a[1];
        }

        return sum/classes.length;

    }

    public static void main(String[] args) {

    }

}
