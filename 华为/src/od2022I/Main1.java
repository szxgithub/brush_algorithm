package od2022I;

import java.util.Scanner;

/*

计算面积
绘图机器的绘图笔初始位置在原点(0,0)，机器启动后其绘笔按下面规则绘制直线

 */
public class Main1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int zhilinNum = sc.nextInt();
        int endPointX = sc.nextInt();

        sc.nextLine();

        String[] zhilinArr = new String[zhilinNum];
        for (int i = 0;i<zhilinNum;i++){
            zhilinArr[i] = sc.nextLine();
        }

        long sum = 0;
        for (int i = 0; i< zhilinArr.length-1; i++){
            String[] split1 = zhilinArr[i].split("\\s+");
            String[] split2 = zhilinArr[i + 1].split("\\s+");
            int xKuan = Integer.parseInt(split2[0]) - Integer.parseInt(split1[0]);
            int yGao = 0;
            for (int j = 0;j<i+1;j++){
                String[] split3 = zhilinArr[j].split("\\s+");
                yGao+= Integer.parseInt(split3[1]);
            }
            sum+= xKuan*yGao;
        }

        int lastY = 0 ;
        for (int i = 0 ;i<zhilinArr.length;i++){
            String[] split = zhilinArr[i].split("\\s+");
            lastY += Integer.parseInt(split[1]);
        }
        String[] lastZhilin = zhilinArr[zhilinArr.length - 1].split("\\s+");
        int x = Integer.parseInt(lastZhilin[0]);
        int lastX = endPointX - x;

        sum+= lastX*Math.abs(lastY);

        System.out.println(sum);

    }
}
