package od2023;

import java.util.Scanner;

public class Main18 {

    /*

    递增字符串


     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        // 求出从index= 0到最后一个A中间的B的个数（把B全部替换成A,即严格递增）
        int BinA = 0;
        int lastAIndex = str.lastIndexOf("A");
        for(int i=0; i<lastAIndex; i++){
            if(str.charAt(i) == 'B'){
                BinA ++;
            }
        }

        // 求出从第一个B出现的位置到字符串末尾中间A的个数（把A全部替换成B，即严格递增）
        int AinB = 0;
        int firstBIndex = str.indexOf("B");
        for(int i=firstBIndex+1; i<str.length(); i++){
            if(str.charAt(i) == 'A'){
                AinB ++;
            }
        }

        // 比较两个值，输出最小
        System.out.println(Math.min( BinA, AinB));
    }


}
