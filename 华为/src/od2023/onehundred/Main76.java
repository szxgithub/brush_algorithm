package od2023.onehundred;

import java.util.Scanner;

public class Main76 {

    /*

     最快到达医院的方法
     距离自己家的医院有两家，其中：
        医院A和自己的距离是X公里
        医院B和自己的距离是Y公里
     到达医院A只能搭乘计程车，已知车的速度是M米/分钟， 上车平均等待时间为L分钟
     到达医院B只能步行，平均速度为N米/分钟

     给出X、Y、M、L、N的数据，请问大壮到达哪家医院最快


     */

    /*
    这道题简单的有些过分，逻辑分析
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 到达医院A的距离
        int X = sc.nextInt();
        // 到达医院B的距离
        int Y = sc.nextInt();

        // 计程车平均速度
        int M = sc.nextInt();
        // 上车平均等待时间
        int L = sc.nextInt();

        // 步行平均速度
        int N = sc.nextInt();


        // 求大壮到达哪家医院耗时最短
        double timeA = X/M + L;
        double timeB = Y/N;

        if (timeA > timeB){
            System.out.println("Walk");
        }else if (timeA < timeB){
            System.out.println("Taxi");
        }else {
            System.out.println("same");
        }

    }

}
