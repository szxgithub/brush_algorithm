package com.leetcode.hot100.media;

public class Item79 {

    /**
     * 单词搜索
     *
     * 给定一个mxn 二维字符网格board 和 一个字符串单词word
     * 如果word存在于网格中，返回true，否则，返回false
     *
     *
     *
     * @param board
     * @param word
     * @return
     */

    public boolean exist(char[][] board, String word){

        int h = board.length, w = board[0].length;

        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++){
            for (int j = 0; j < w; j++){
                boolean flag = check(board,visited,i,j,word,0);
                if (flag){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * @param board 网格
     * @param visited  标记对应格子是否访问过
     * @param i
     * @param j
     * @param s   目标字符串
     * @param k   从第0个字符开始检查
     * @return
     */
    public boolean check(char[][] board, boolean[][] visited, int i,int j, String s, int k){
        if (board[i][j] != s.charAt(k)){
            return false;
        }else if (k == s.length() - 1){
            return true;
        }

        visited[i][j] = true;

        int[][] directions = {
                {0,1},
                {0,-1},
                {1,0},
                {-1,0}
        };

        boolean result = false;
        for (int[] dir : directions){
            int newi = i + dir[0], newj = j + dir[1];
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                if (!visited[newi][newj]) {
                    boolean flag = check(board, visited, newi, newj, s, k + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }

        visited[i][j] = false;
        return result;

    }

    /**
     *
     * 深度优先遍历、 状态装置
     *
     *
     *
     *
     */

    private static final int[][] DIRECTIONS = {{-1,0},{0,-1},{0,1},{1,0}};
    private int rows;
    private int cols;
    private int len;
    private boolean[][] visited;
    private char[] charArray;
    private char[][] board;

    public boolean exist3(char[][] board, String word){

        rows = board.length;
        if (rows == 0){
            return false;
        }

        cols = board[0].length;
        visited = new boolean[rows][cols];

        this.len = word.length();
        this.charArray = word.toCharArray();
        this.board = board;

        for (int i = 0; i < rows; i++){
            for (int j = 0; j <cols; j++){
                if (dfs(i,j,0)){
                    return true;
                }
            }
        }

        return false;

    }

    private boolean dfs(int x, int y, int begin) {

        if (begin == len - 1){
            return board[x][y] == charArray[begin];
        }

        if (board[x][y] == charArray[begin]){
            visited[x][y] = true;
            for (int[] direction : DIRECTIONS){
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (inArea(newX,newY) && !visited[newX][newY]){
                    if (dfs(newX,newY,begin+1)){
                        return true;
                    }
                }
            }
            visited[x][y] = true;
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

}
