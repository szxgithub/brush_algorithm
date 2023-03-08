package od2022II.onehundred;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*

 分班问题
 幼儿园的小朋友排队时混在了一起，每位小朋友都知道自己是否与前面一位小朋友同班，帮忙把同班的小朋友找出来
    小朋友的编号是整数，同班用Y表示，不同班用N表示
    学生序号范围是(0,999]，如果输入不合法则打印ERROR

 输入描述：
    输入为空格分开的小朋友编号和是否同班的标志

 输出描述：
    输出为两行，每一行记录一个班的小朋友的编号，用空格分开，且编号升序排列，若只有一个班，第二行为空行

输入：
1/N 2/Y 3/N 4/Y
输出：
1 2
3 4


 */
public class Main84 {

    /*
    逻辑分析题
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String classmates = sc.nextLine();
        /*
        非常好用的正则表达式， \\s+ 匹配任何空白字符，包括空格、制表符、换页符等等
        \n 换行
        \r 回车
        \t 制表符
         */
        String[] mateArr = classmates.split("\\s+");

        List<Integer> list1 = new ArrayList<>(0);
        List<Integer> list2 = new ArrayList<>(0);

        boolean isError = false;
        boolean b = true;

        for (int i = 0; i <mateArr.length; i++){
            String[] split = mateArr[i].split("/");
            if (!Character.isDigit(split[0].charAt(0))){
                isError = true;
                break;
            }
            Integer stu = Integer.valueOf(split[0]);
            if (!split[1].equals("N") && !split[1].equals("Y")
                    || list1.contains(stu)
                    || list2.contains(stu)){
                isError = true;
                break;
            }
            if (list1.size() == 0){
                list1.add(stu);
                continue;
            }
            if (b){
                if (split[1].equals("N")){
                    list2.add(stu);
                    b = false;
                }else {
                    list1.add(stu);
                }
            }else {
                if (split[1].equals("N")){
                    list1.add(stu);
                    b = true;
                }else {
                    list2.add(stu);
                }
            }
        }


        if (isError){
            System.out.println("ERROR");
        }else {
            Collections.sort(list1);
            Collections.sort(list2);
            String collect1 = list1.stream().map(String::valueOf).collect(Collectors.joining(" "));
            String collect2 = list2.stream().map(String::valueOf).collect(Collectors.joining(" "));
            System.out.println(collect1);
            System.out.println(collect2);
        }
    }
}
