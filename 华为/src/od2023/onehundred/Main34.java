package od2023.onehundred;

import java.util.Scanner;

public class Main34 {

    /*
        贪心的商人(最大利润)
        有number种商品， 每件商品的最大持有数量item[index]
        每种商品的价格是item-price[item_index][day]

        请给出商人在days天内能获取到的最大利润


        输入：
        3
        3
        4 5 6
        1 2 3
        4 3 2
        1 5 3
        输出：32
     */

    /*
    逻辑分析  双层循环
    只需要找到商品价格走势的上升区间，然后低价买入，高价卖出，即可求得最大利润
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
