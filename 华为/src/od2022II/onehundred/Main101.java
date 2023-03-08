package od2022II.onehundred;

import java.util.Scanner;

/*

计算面积（绘图机器）
绘图机器的绘图笔初始位置在原点(0,0)，机器启动后其绘笔按下面规则绘制直线
    1、尝试沿着横线坐标正向绘制直线直到给定的终点E
    2、期间可以通过指令在纵坐标轴方向进行偏移，offsetY为正数表示正向偏移，为负数表示负向偏移
    给定横坐标终点E，以及若干条指令
    请计算绘制的直线和横坐标轴以及x=E的直线组成的图形面积

 输入描述：
    首行为两个整数N和E  表示有N条指令，机器运行的横坐标终点值E
    接下来有N行，每行两个整数表示一条绘制指令x offset Y

 输出描述：
    一个整数表示计算得到的面积


 */
public class Main101 {

    /*
    逻辑分析
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int E = sc.nextInt();

        sc.nextLine();

        String[] zhilinArr = new String[N];
        for (int i = 0;i<N;i++){
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
        int lastX = E - x;

        sum+= lastX*Math.abs(lastY);

        System.out.println(sum);

    }
}
