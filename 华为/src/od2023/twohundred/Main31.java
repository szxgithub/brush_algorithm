package od2023.twohundred;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main31 {

    /*

    硬件产品销售方案
    要采购金额为amount元的硬件产品搭建自己的AI基座
    当前库存有N种产品，每种产品库存充足，给定每种产品价格，记为price
    请为合作厂商列出所有可能的产品组合

    输入描述：
        采购金额amount， 和 产品价格列表price，
    输出描述：
        输出为组合列表

    输入：
    500
    [100,200,300,500,500]
    输出：
    [[100, 100, 100, 100, 100], [100, 100, 100, 200], [100, 100, 300], [100, 200, 200], [200, 300], [500], [500]]

     */


    // 产品价格列表
    public static int[] price;
    // 采购金额
    public static int amount;
    // 输出组合列表
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

        dfs(0,0,new ArrayList<>());

        System.out.println(resList);
    }

    /**
     * 通过回溯算法 求出所有的购买情况
     * @param index  物品价格购买索引
     * @param count  购买物品总价格
     * @param list   购买物品集合
     */
    private static void dfs(int index, int count, ArrayList<Integer> list) {

        if (amount <= count){
            List<Integer> tempList = new ArrayList<>();
            tempList.addAll(list);
            if (amount == count){
                resList.add(tempList);
            }
        }else {
            for (int i = index; i<price.length; i++){
                list.add(price[i]);
                dfs(i,count + price[i],list);
                list.remove(list.size()-1);
            }
        }

    }

}
