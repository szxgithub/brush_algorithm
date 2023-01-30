package od;

import java.util.Arrays;
import java.util.Scanner;

public class Main58 {

    /*

    快递运输

    输入：
    5,10,2,11
    20
    输出：
    3

     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String weights = sc.nextLine();
        int carMax = sc.nextInt();

        String[] split = weights.split(",");
        int[] weightArr = new int[split.length];
        for (int i =0; i<weightArr.length; i++){
            weightArr[i] = Integer.parseInt(split[i]);
        }

        Arrays.sort(weightArr);

        int ans = 0;
        for (int i =0; i < weightArr.length; i++){
            carMax -= weightArr[i];
            if (carMax >=0){
                ans++;
            }else {
                break;
            }
        }

        System.out.println(ans);



    }

}
