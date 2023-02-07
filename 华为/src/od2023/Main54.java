package od2023;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main54 {

    /*
    去除多余空格

    输入：
    Life is painting a  picture, not doing 'a sum'.
    8 15,20 26,43 45
    输出：
    Life is painting a picture, not doing 'a sum'.
    [8,15][19,25][42,44]

    //todo

     */


    public static String inputStr;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        inputStr = sc.nextLine();
        String[] strings = sc.nextLine().split(",");

        List<int[]> zuobiaoList = new ArrayList<>();
        int count = 0;  //空格个数
        String resStr = inputStr;

        for(String str : strings){

            String[] strs = str.split(" ");

            int start = Integer.parseInt(strs[0]);  //起始坐标
            int end = Integer.parseInt(strs[1]);    //末尾坐标
            int spaceLeft = 0;    //字符串左侧空格数
            int spaceRight = 0;     //字符串右侧空格数
            int[] ints = new int[2];
            if(!isInKuohao(start)){     //在括号内不处理
                spaceLeft = spaceLeft(start);
                spaceRight = spaceRight(end);
            }

            ints[0] = start - count - spaceLeft;    //起始坐标-之前去除的空格总数-当前左侧的空格数
            ints[1] = end - count - spaceLeft;      //末尾坐标-之前去除的空格总数-当前左侧的空格数

            while (resStr.charAt(ints[0]) == ' '){      //起始坐标为空，则进行删除（去除多余的空格）
                resStr = resStr.substring(0, ints[0]) + resStr.substring(ints[0] + 1);
            }

            count += spaceLeft + spaceRight;    //记录总共去除的空格数
            zuobiaoList.add(ints);
        }

        System.out.println(resStr);
        String res = "";
        for(int[] ints : zuobiaoList){
            res += "[" + ints[0] + "," + ints[1] + "]";
        }

        System.out.println(res);
    }

    /**
     * 字符串左侧多余空格数
     * @param index
     * @return
     */
    public static int spaceLeft(int index){

        int count = 0;

        if(index == 0){
            return count;
        }else {
            while (true){
                index --;
                if(index >= 0 && inputStr.charAt(index) == ' '){
                    count ++;
                }else {
                    break;
                }
            }
        }

        return count > 1 ? count - 1 : 0;   //空格数小于等于1时，多余空格数为0
    }

    /**
     * 字符串右侧的多余空格数
     * @param index
     * @return
     */
    public static int spaceRight(int index){

        int count = 0;

        if(index == 0){
            return count;
        }else {
            while (true){
                index ++;
                if(index < inputStr.length() && inputStr.charAt(index) == ' '){
                    count ++;
                }else {
                    break;
                }
            }
        }

        return count > 1 ? count - 1 : 0;   //空格数小于等于1时，多余空格数为0
    }

    /**
     * 是否在括号内（字符左侧的单引号为单数则在括号内，双数则在括号外）
     * @param start     字符串其实坐标
     * @return
     */
    public static boolean isInKuohao( int start){

        String str1 = inputStr.substring( 0, start);

        int count = 0;
        for(int i=0; i<str1.length(); i++){
            if(str1.charAt(i) == '\''){
                count ++;
            }
        }

        return count%2 == 0 ? false : true;
    }

}
