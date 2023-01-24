package od;

import java.util.Scanner;

public class Main4 {

    /**
     *
     * 分糖果
     *
     * 小明随机抓取一把糖果，随机将一半分给同学
     *
     * 当糖果不能平分时，可以取出一个或者放回一个
     *
     * 请问小明最少多少次将糖果分至一颗
     *
     * */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){

            int num = sc.nextInt();

            int count = 0;

            while (num > 1){
                if (num%2 == 0){
                    num = num/2;
                    count++;
                }else {
                    if ((num -1)/2 == 1 || (num-1)/2%2== 0){
                        num--;
                    }else {
                        num++;
                    }
                    count++;
                }
            }

            System.out.println(count);

        }


    }

}
