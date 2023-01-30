package od;

import java.util.Scanner;


/**

  找单词 （返回路径坐标）

 输入：
 4
 A,C,C,F
 C,D,E,D
 B,E,S,S
 F,E,C,A
 ACCESS
 输出：
 0,0,0,1,0,2,1,2,2,2,2,3


 * */

public class Main49{

    public static int n;
    public static int slen;
    public static String res;
    public static String inputS;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        sc.nextLine();
        String[][] strings = new String[n][n];

        for(int i=0;i<n;i++){
            String[] inputStrings = sc.nextLine().split(",");
            for(int j=0;j<n;j++){
                strings[i][j] = inputStrings[j];
            }
        }

        inputS = sc.nextLine();
        slen = inputS.length();
        String first = String.valueOf(inputS.charAt(0));//从第一个值开始
        boolean isSuccess = false;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(strings[i][j].equals(first)){
                    String[][] temp = copy(strings);    //对数组进行复制，否则影响第二次计算
                    res = i + "," + j;
                    temp[i][j] = ""; //已取出的值置空
                    if(nextNum(0,i,j,temp)==1){ //表示已经成功取出数据
                        isSuccess = true;
                        System.out.println(res);
                        break;
                    }
                }
            }
            if(isSuccess){
                break;
            }
        }
        if(!isSuccess){
            System.out.println("N");
        }
    }

    public static String[][] copy(String[][] strings){
        int x = strings.length;
        String[][] copyS = new String[x][x];

        for ( int i=0; i<x; i++) {
            for ( int j=0; j<x; j++) {
                copyS[i][j] = strings[i][j];
            }
        }
        return copyS;
    }

    public static int nextNum(int index, int row, int col, String[][] temp){

        if(index==slen-1){  //递归到最后一位表示已经成功
            return 1;
        }
        index++;    //字符串下标
        String s= String.valueOf(inputS.charAt(index));

        if(row>0 && temp[row-1][col].equals(s)){    //对上边的字符串进行比较
            temp[row-1][col] = "";  //将已经取出的字符串进行置空，防止多次取值
            res += ","+ (row-1)+","+col;    //添加坐标
            if(nextNum(index,row-1,col,temp) == 1){ //值为1表示成功取出
                return 1;
            }else {
                res = res.substring(0,res.length()-4);  //如果失败则进行还原
                temp[row-1][col] = s;
            }
        }
        if(col>0 && temp[row][col-1].equals(s)){  // 左边
            temp[row][col-1] = "";
            res += ","+row+","+(col-1);
            if(nextNum(index,row,col-1,temp) == 1){
                return 1;
            }else {
                res = res.substring(0,res.length()-4);
                temp[row][col-1] = s;
            }
        }
        if(row<n-1 && temp[row+1][col].equals(s)){    //下边
            temp[row+1][col] = "";
            res += ","+(row+1)+","+col;
            if(nextNum(index,row+1,col,temp) == 1){
                return 1;
            }else {
                res = res.substring(0,res.length()-4);
                temp[row+1][col] = s;
            }
        }
        if(col<n-1 && temp[row][col+1].equals(s)){    //右边
            temp[row][col+1] = "";
            res += ","+row+","+(col+1);
            if(nextNum(index,row,col+1,temp) == 1){
                return 1;
            }else {
                res = res.substring(0,res.length()-4);
                temp[row][col+1] = s;
            }
        }

        return 0;
    }

}
