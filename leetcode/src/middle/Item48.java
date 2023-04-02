package middle;

public class Item48 {

    public void rotate(int[][] matrix){
        // 先主对角线
        for (int i = 0; i < matrix.length; i++){
            for (int j = i; j < matrix[i].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 再翻转二维矩阵的每一行
        for (int[] row : matrix){
            for (int i = 0, j = row.length-1; i < j; i++,j--){
                int temp = row[i];
                row[i] = row[j];
                row[j] = temp;
            }
        }
    }

}
