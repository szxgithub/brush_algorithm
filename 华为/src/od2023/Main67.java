package od2023;

import java.util.Scanner;

public class Main67 {

    /*

    Excel单元格数值统计

    复杂字符串处理
    //todo
     */


    public static String[][] strings;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int row = sc.nextInt();
        int col = sc.nextInt();
        sc.nextLine();

        strings = new String[row][col];
        for(int i=0; i<row; i++){
            strings[i] = sc.nextLine().split(" ");
        }

        String[] nums = sc.nextLine().split(":");
        int[] start = zuobiao(nums[0]);
        int[] end = zuobiao(nums[1]);

        int sum = 0;
        for( int i=start[0]; i<=end[0]; i++){
            for(int j=start[1]; j<=end[1]; j++){
                String temp = strings[i][j];
                if(temp.contains("=")){
                    sum += jisuan(temp);
                }else {
                    sum += Integer.valueOf(temp);
                }
            }
        }

        System.out.println(sum);
    }

    // 计算单元格为公式的值
    public static int jisuan(String s){

        s = s.replace("=","");
        boolean jiafa = true;   //是否为加法运算
        boolean isDigit = true;     //是否为纯数字
        int num1 = 0;
        int num2 = 0;
        String temp = "";
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '-' || c == '+'){
                if(c == '-'){
                    jiafa = false;
                }
                if(isDigit){    //纯数字
                    num1 = Integer.valueOf(temp);
                } else {
                    int[] ints = zuobiao(temp); //先求出其坐标位置
                    String str = strings[ints[0]][ints[1]];
                    if(str.contains("=")){  //如果此坐标位置还是一个算式需要继续求值
                        num1 = jisuan(str);
                    }else {
                        num1 = Integer.valueOf(str);
                    }
                }
                temp = "";
                isDigit = true;
            }else {
                if(Character.isLetter(c)){
                    isDigit = false;    //包含字母则非纯数字
                }
                temp += c;
            }
            if(i == s.length()-1){
                if(isDigit){    //纯数字
                    num2 = Integer.valueOf(temp);
                } else {
                    int[] ints = zuobiao(temp); //先求出其坐标位置
                    String str = strings[ints[0]][ints[1]];
                    if(str.contains("=")){  //如果此坐标位置还是一个算式需要继续求值
                        num2 = jisuan(str);
                    }else {
                        num2 = Integer.valueOf(str);
                    }
                }
            }
        }

        return jiafa ? num1 + num2 : num1 - num2;
    }

    // 计算出坐标
    public static int[] zuobiao(String s){

        int y = s.charAt(0) - 'A';
        String num = "";
        for(int i=1; i<s.length(); i++){
            num += s.charAt(i);
        }

        return new int[]{ Integer.valueOf(num) - 1, y};
    }
}
