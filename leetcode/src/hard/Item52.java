package hard;

import java.util.Arrays;

public class Item52 {

    /*
         N皇后 II

     */

    public int res = 0;
    public int totalNQueens(int n){

        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard){
            Arrays.fill(c,'.');
        }

        backtrack(n,0,chessboard);

        return res;
    }

    private void backtrack(int n, int row, char[][] chessboard) {

        if (row == n){
            res++;
            return;
        }

        for (int col = 0; col < n; col++){
            if (isValid(row,col,n,chessboard)){
                chessboard[row][col] = 'Q';
                backtrack(n,row+1,chessboard);
                chessboard[row][col] = '.';
            }
        }

    }

    private boolean isValid(int row, int col, int n, char[][] chessboard) {

        // 检查列
        for (int i = 0; i < row; i++){
            if (chessboard[i][col] == 'Q'){
                return false;
            }
        }

        // 检查45度对角线
        for (int i = row -1, j = col - 1; i>=0 && j >=0; i--, j--){
            if (chessboard[i][j] == 'Q'){
                return false;
            }
        }

        // 检查135度对角线
        for (int i=row-1, j=col+1; i>=0 && j<=n-1; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {

        Item52 item52 = new Item52();
        int n = 1;
        int res = item52.totalNQueens(n);
        System.out.println(res);

    }

}
