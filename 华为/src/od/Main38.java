package od;

import java.util.Scanner;

public class Main38{


    /**
     *
     * 竖直四子棋
     *
     * 算法不复杂，就是实现起来麻烦
     *
     *
     * */

    public static int m;    //棋盘宽
    public static int n;    //棋盘高

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        /**
         * 6 5
         * 2 3 2 4 2 5 3 4 4 2 6 3
         */
        String[] nums = sc.nextLine().split(" ");
        m = Integer.parseInt(nums[0]);
        n = Integer.parseInt(nums[1]);

        String[] strings = sc.nextLine().split(" ");

        int[][] ints = new int[n][m];
        Boolean isOver = false;
        for (int i=0;i<strings.length;i++){
            int index = -1;
            int color = 1;
            int num = Integer.parseInt(strings[i]);
            if(num<=0 || num>m || ints[0][num-1]!=0){
                isOver = true;
                System.out.println(i+1+",error");
                break;
            }
            if(i%2!=0){ //偶数下标为red，用1表示
                color = 2;  //奇数下标为blue，用2表示
            }
            for(int j=n-1;j>=0;j--){
                if(ints[j][num-1]==0){
                    index = j;  //此时棋子横坐标为j，纵坐标为num-1
                    ints[j][num-1] = color;
                    break;
                }
            }
            if(index==-1){
                System.out.println(i+1+",error");
                isOver = true;
                break;
            }
            if(i>=6 &&
                    (isZongXiang(ints,index,num-1)
                            || isHengXiang(ints,index,num-1)
                            || isZuoXie(ints,index,num-1)
                            || isYouXie(ints,index,num-1))){   //第七个棋子才开始符合四棋子的要求
                if(color==1){
                    System.out.println(i+1+",red");
                    isOver = true;
                    break;
                }else {
                    System.out.println(i+1+",blue");
                    isOver = true;
                    break;
                }
            }
        }
        if(!isOver){
            System.out.println("0,draw");
        }

    }

    /**
     *  纵向四子
     */
    public static boolean isZongXiang(int[][] ints,int x,int y){

        if(x < n-3){
            int jishu = 3;
            while (jishu>0 && ints[x][y] == ints[++x][y]){
                jishu--;
            }
            if(jishu==0){
                return true;
            }
        }
        return false;
    }

    /**
     *  横向四子
     */
    public static boolean isHengXiang(int[][] ints,int x,int y){

        int jishu = 3;
        int a = x;
        int b = y;
        while (jishu>0 && b>0 && ints[a][b] == ints[a][--b]){
            jishu--;
        }
        while (jishu>0 && y<m-1 && ints[x][y] == ints[x][++y]){
            jishu--;
        }
        if(jishu==0){
            return true;
        }

        return false;
    }

    /**
     *  左边斜向四子
     */
    public static boolean isZuoXie(int[][] ints,int x,int y){

        int jishu = 3;
        int a = x;
        int b = y;
        while (jishu>0 && (a<n-1 && b>0) && ints[a][b] == ints[++a][--b]){ //左下
            jishu--;
        }
        while (jishu>0 && (x>0 && y<m-1) && ints[x][y] == ints[--x][++y]){   //右上
            jishu--;
        }
        if(jishu==0){
            return true;
        }

        return false;
    }

    /**
     *  右边斜向四子
     */
    public static boolean isYouXie(int[][] ints,int x,int y){

        int jishu = 3;
        int a = x;
        int b = y;
        while (jishu>0 && (a<n-1 && b<m-1) && ints[a][b] == ints[++a][++b]){ //右下
            jishu--;
        }
        while (jishu>0 && (x>0 && y>0) && ints[x][y] == ints[--x][--y]){   //左上
            jishu--;
        }
        if(jishu==0){
            return true;
        }

        return false;
    }
}
