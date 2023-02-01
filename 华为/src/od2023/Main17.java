package od2023;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main17 {

    /*

    硬件产品销售方案

    输入：
    500
    [100,200,300,500,500]
    输出：
    [[100, 100, 100, 100, 100], [100, 100, 100, 200], [100, 100, 300], [100, 200, 200], [200, 300], [500], [500]]

     */

    public static int[] price;

    public static int amount;

    public static List<List<Integer>> resList = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        amount = sc.nextInt();
        sc.nextLine();

        String str = sc.nextLine();
        str = str.replace("[","");
        str = str.replace("]","");

        String[] split = str.split(",");
        price = new int[split.length];
        for (int i =0; i<price.length; i++){
            price[i] = Integer.valueOf(split[i]);
        }

        handle(0,0,new ArrayList<>());

        System.out.println(resList);
    }

    /**
     * 通过递归求出所有的购买情况
     * @param index  物品价格购买索引
     * @param count  购买物品总价格
     * @param list   购买物品集合
     */
    private static void handle(int index, int count, ArrayList<Integer> list) {

        if (amount <= count){
            List<Integer> tempList = new ArrayList<>();
            tempList.addAll(list);
            if (amount == count){
                resList.add(tempList);
            }
        }else {
            for (int i = index; i<price.length; i++){
                list.add(price[i]);
                handle(i,count + price[i],list);
                list.remove(list.size()-1);
            }
        }

    }

}
