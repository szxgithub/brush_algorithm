package od;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

public class Main19 {

    /*
    *
    *
    * 转骰子
    *
    *  从123456初始状态开始，根据输入的序列，计算最终的状态
    *
    * */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()){

            String str = sc.nextLine();

            int[][] order = {{1,2},{3,4},{5,6}};

            for (int i = 0; i < str.length(); i++){
                if (str.charAt(i) == 'L'){
                    // 56 34 21
                    int temp = order[0][0];
                    order[0][0] = order[0][1];
                    order[0][1] = temp;

                    int[] tmp = order[0];
                    order[0] = order[2];
                    order[2] = tmp;

                }else if (str.charAt(i) == 'R'){
                    // 65 34 12
                    int temp = order[2][0];
                    order[2][0] = order[2][1];
                    order[2][1] = temp;

                    int[] tmp = order[0];
                    order[0] = order[2];
                    order[2] = tmp;

                }else if (str.charAt(i) == 'F'){
                    // 12 56 43
                    int temp = order[1][0];
                    order[1][0] = order[1][1];
                    order[1][1] = temp;

                    int[]tmp = order[1];
                    order[1] = order[2];
                    order[2] = tmp;

                }else if (str.charAt(i) == 'B'){
                    // 12 65 34
                    int temp = order[2][0];
                    order[2][0] = order[2][1];
                    order[2][1] = temp;

                    int[]tmp = order[1];
                    order[1] = order[2];
                    order[2] = tmp;

                }else if (str.charAt(i) == 'A'){
                    // 43 12 56
                    int temp = order[1][0];
                    order[1][0] = order[1][1];
                    order[1][1] = temp;

                    int[] tmp = order[0];
                    order[0] = order[1];
                    order[1] = tmp;

                }else if (str.charAt(i) == 'C'){
                    // 34 21 56
                    int temp = order[0][0];
                    order[0][0] = order[0][1];
                    order[0][1] = temp;

                    int[] tmp = order[0];
                    order[0] = order[1];
                    order[1] = tmp;
                }
            }

            for (int i = 0; i<order.length; i++){
                System.out.print(order[i][0]);
                System.out.print(order[i][1]);
            }
            System.out.println();


        }

    }

}
