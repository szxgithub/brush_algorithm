package od2023.onehundred;

import java.util.Scanner;

public class Main71 {

    /*
        最优资源分配

        芯片最小容量单位为1.25G，总容量为M*1.25
        配置A：1.25*1 = 1.25
        配置B：1.25*2 = 2.5
        配置C：1.25*8 = 10

        芯片上资源如果被占用标记为1，没有被占用标记为0


        输入描述：
            M：每块芯片的容量M*1.25
            N：每块板卡包含的芯片数量
            用户配置序列，例如：ACABA
        输出描述：
            板卡上每块芯片的占用情况

    输入：
      8
      2
      ACABA
    输出：
      11111000
      11111111

     */

    /*
    逻辑分析
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 每块芯片的容量
        int M = Integer.parseInt(sc.nextLine());
        // 每块板块芯片数量
        int N = Integer.parseInt(sc.nextLine());

        // 用户配置序列
        String str = sc.nextLine();

        // 配置所占的容量
        int conf = 0;
        // 每块芯片所占的容量
        int[] chip = new int[N];
        // 遍历每一种配置字符
        for (int i = 0; i<str.length(); i++){
            if (str.charAt(i) == 'A'){
                conf = 1;
            }else if (str.charAt(i) == 'B'){
                conf = 2;
            }else if (str.charAt(i) == 'C'){
                conf = 8;
            }
            for (int j = 0; j<N; j++){
                int used = chip[j];
                if (M - used >= conf){
                    chip[j] += conf;
                    break;
                }
            }
        }

        for (int i =0; i<N; i++){
            StringBuffer sb = new StringBuffer();
            // 芯片占用情况
            int used = chip[i];
            for (int j = 0; j<M; j++){
                if (j < used){
                    // 芯片占用的地方用1
                    sb.append("1");
                }else {
                    // 未占用的地方用0
                    sb.append("0");
                }
            }
            System.out.println(sb);
        }

    }

}
