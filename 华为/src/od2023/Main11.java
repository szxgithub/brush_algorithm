package od2023;

import java.util.Arrays;
import java.util.Scanner;

public class Main11 {

    /*
        贪心的商人

        输入：
        3
        3
        4 5 6
        1 2 3
        4 3 2
        1 5 3
        输出：32
     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 商品的数量
        int number = sc.nextInt();
        // 售货天数
        int days = sc.nextInt();

        // 仓库中每件商品的最大持有量
        int[] item = new int[number];
        for (int i = 0; i<number;i++){
            item[i] = sc.nextInt();
        }

        // 每种商品每天的价格
        int[][] item_price = new int[number][days];
        for (int i = 0; i<item_price.length; i++){
            for (int j = 0; j<item_price[i].length; j++){
                item_price[i][j] = sc.nextInt();
            }
        }

        // 求商人在days天内获取到对的最大利润
        int res =0;
        for (int i =0; i<number; i++){
            for (int j = 0; j <days-1; j++){
                int purchase = item_price[i][j];
                int selling = item_price[i][j+1];
                if (purchase < selling){
                    res += (selling - purchase)*item[i];
                }
            }
        }

        System.out.println(res);

    }

}
