package middle;

import java.util.LinkedList;
import java.util.List;

public class Item59 {

    /*
    螺旋矩阵 II
     */

    public int[][] generateMatrix(int n) {
        int upper_bound = 0, lower_bound = n-1;
        int left_bound = 0, right_bound = n-1;

        int[][] matrix = new int[n][n];
        int count = 1;
        while (count <= n*n){
            if (upper_bound <= lower_bound){
                for (int j = left_bound; j <= right_bound; j++){
                    matrix[upper_bound][j] = count;
                    count++;
                }
                upper_bound++;
            }

            if (left_bound <= right_bound){
                for (int i = upper_bound; i <= lower_bound; i++){
                    matrix[i][right_bound] = count;
                    count++;
                }
                right_bound--;
            }

            if (upper_bound <= lower_bound){
                for (int j = right_bound; j >= left_bound; j--){
                    matrix[lower_bound][j] = count;
                    count++;
                }
                lower_bound--;
            }

            if (left_bound <= right_bound){
                for (int i = lower_bound; i >= upper_bound; i--){
                    matrix[i][left_bound] = count;
                    count++;
                }
                left_bound++;
            }
        }
        return matrix;
    }

}
