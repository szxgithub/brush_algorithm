package od2023;

import java.util.*;

public class Main92 {

    /*

    统一限载货物数最小值

    //todo
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 供货商数量
        int length = sc.nextInt();

        // 供货商供货数量
        int[] goods = new int[length];
        for (int i =0; i<length; i++){
            goods[i] = sc.nextInt();
        }

        // 供货商供货货物类型
        int[] types = new int[length];
        for (int i =0; i<length; i++){
            types[i] = sc.nextInt();
        }

        // 单类中转车数量
        int k = sc.nextInt();

        // 找到干货和湿货限载得最大值
        List<Integer> ganhuo = new ArrayList<>();
        List<Integer> shihuo = new ArrayList<>();

        for (int i =0; i<goods.length; i++){
            if (types[i] == 0){
                ganhuo.add(goods[i]);
            }else if (types[i] == 1){
                shihuo.add(goods[i]);
            }
        }

        if (k == 1){
            Integer ganhuoSum = ganhuo.stream().reduce(Integer::sum).get();
            Integer shihuoSumm = shihuo.stream().reduce(Integer::sum).get();
            int max = Math.max(ganhuoSum, shihuoSumm);
            System.out.println(max);
        }else {
            Integer ganhuoMax = Collections.max(ganhuo);
            Integer shihuoMax = Collections.max(shihuo);
            int max = Math.max(ganhuoMax, shihuoMax);
            System.out.println(max);
        }
    }

}
