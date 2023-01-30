package od;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.Scanner;

public class Main50 {

    /*

    非严格递增连续数字序列

    输入：
    abc2234019A334bc
    输出：
    4

    输入：
    abc2234012349A3344556
    输出：
    7

    */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        int n = s.length();
        int max = 0;    //最大长度
        int count = 0;    //符合条件的数字长度

        if(Character.isDigit(s.charAt(0))){ //如果第一个字符为数字则将count置1
            count=1;
        }

        for(int i=1;i<n;i++){
            if(Character.isDigit(s.charAt(i))){ //判断字符是否为数字
                if(count!=0 ){  //count不为0则可以进行比较，反则置为1，下次进行比较
                    if((s.charAt(i)>=s.charAt(i-1))){   //符合条件
                        count++;
                    }else {
                        max = Math.max(max,count);  //不符合条件则抛出最大
                        count = 1;  //因为为数字，所以置1
                    }
                }else {
                    count=1;
                }
            }else if(count!=0){
                max = Math.max(max,count);
                count = 0;
            }
        }

        max = Math.max(max,count);

        System.out.println(max);
    }

}
