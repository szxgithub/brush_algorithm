package od2023.twohundred;

import java.util.Scanner;

public class Main5 {

    /*

    Excel单元格数值统计

    仿照Excel的功能，对给定表格选中区域中的单元格进行求和统计，并输出统计结果
    单元格内容仅为数字或公式两种
    如果为数字，则是一个非负整数
    如果为公式，则固定以=开头，且仅包含下面三种情况：
        等于单元格的值，如=B12
        两个单元格的双目运算，仅为+或-，如=C1-C2
        单元格和数字的双目运算，形如 =B1+1

    输入描述：
        第一行，输入表格区域的行row和列col
        接下来row行，每行col列个以空格分割的字符串
        最后一行输入的字符串，表示选中的给定区域,形如A1:C2  冒号左侧单元格表示区域的左上角，右侧表示右下角

    输出描述：
        一个整数，表示给定区域各单元格中数字的累加总和

    备注：行号为1-20，列号为A-Z

输入：
5 3
10 12 =C5
15 5 6
7 8 =3+C2
6 =B2-A1 =C2
7 5 3
B2:C4
输出：
29

     */




    /*
    逻辑分析
    复杂字符串处理
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
        // 选中区域的左上角坐标
        int[] start = zuobiao(nums[0]);
        // 选中区域的右下角坐标
        int[] end = zuobiao(nums[1]);

        int sum = 0;
        for( int i=start[0]; i<=end[0]; i++){
            for(int j=start[1]; j<=end[1]; j++){
                String temp = strings[i][j];
                if(temp.contains("=")){
                    // 处理公式
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
