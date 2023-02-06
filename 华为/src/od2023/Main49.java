package od2023;

import java.util.Scanner;

public class Main49 {

    /*
        最优资源分配

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
        int[] chip = new int[N];
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
