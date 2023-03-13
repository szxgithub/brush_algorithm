package od2023.onehundred;

import java.util.Scanner;

public class Main43 {

    /*

    获取最大软件版本号
    题目描述：
    Maven版本号定义，<主版本>.<次版本>.<增量版本>-<里程版本> 举例：3.1.4-beta
    其中主版本、次版本是必须的，增量版本由多位数字组成，可能包含前导0，里程碑版本由字符串组成，

    主、次、增量基于数字比较；
    里程碑，基于字符串比较，采用字典顺序；

    输入两个版本号，输出最大版本号，版本号相同时输出第一个版本号

输入：
1.05.1
1.5.01
输出：
1.05.1

     */

    /*
    逻辑分析
    满分答案
    复杂的字符串进行处理
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();

        String[] splitA = a.split("\\.");
        String[] splitB = b.split("\\.");

        // 先比较主、次版本（主次版本是必须的）
        for (int i = 0; i <2; i++){
            Integer firstOneA = Integer.valueOf(splitA[i]);
            Integer firstOneB = Integer.valueOf(splitB[i]);
            if (firstOneA != firstOneB){
                System.out.println(firstOneA > firstOneB ? a:b);
                return;
            }
        }

        // 再比较增量版本和里程碑版本
        if (splitA.length > 2 && splitB.length > 2){
            String[] splitA2 = splitA[2].split("-");
            String[] splitB2 = splitB[2].split("-");
            Integer firstOneA = Integer.valueOf(splitA2[0]);
            Integer firstOneB = Integer.valueOf(splitA2[0]);

            // 比较增量版本
            if (firstOneA != firstOneB){
                System.out.println(firstOneA > firstOneB ? a:b);
                return;
            }

            // 比较里程碑版本
            if (splitA2.length == 2 && splitB2.length == 2){
                System.out.println(splitA2[1].compareTo(splitB2[1]) >= 0 ? a:b);
            }else {
                System.out.println(splitA2.length >= splitB2.length ? a:b);
            }
        }else {
            System.out.println(splitA.length >= splitB.length ? a:b);
        }

    }

}
