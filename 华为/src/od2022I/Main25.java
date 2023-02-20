package od2022I;

import java.util.Scanner;

public class Main25 {

    /**
     *
     *
     * 矩阵最大值
     *
     * 5
     * 1,0,0,0,1
     * 0,0,0,1,1
     * 0,1,0,1,0
     * 1,0,0,1,1
     * 1,0,1,0,1
     * 122
     *
     * */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = Integer.valueOf(sc.nextLine());

        String[] arr = new String[num];
        for (int i = 0; i < num; i++){
            arr[i] = sc.nextLine();
        }

        int ans = 0;

        for (int i = 0; i<arr.length; i++){
            String s = arr[i];
            s = s.replace(",","");
            int tmpNum = Integer.parseInt(s, 2);
            for (int j = 1; j < s.length(); j++){
                // 向左移动
                String tmpStr = s.substring(j) + s.substring(0,j);
                tmpNum = tmpNum > Integer.parseInt(tmpStr, 2) ? tmpNum : Integer.parseInt(tmpStr, 2);
            }

            ans += tmpNum;
        }

        System.out.println(ans);

    }

}
