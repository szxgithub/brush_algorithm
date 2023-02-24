package od2023;

import java.util.*;

public class Main73 {

    /*
        网上商城优惠活动（一）
        有三种优惠券可以用，满减卷，打折卷，和 无门槛卷


     */

    /*
    分情况:
        先满减 后打折
        先打折 后满减
        先满减 后无门槛
        先打折 后无门槛

     */

    public static int manjian;
    public static int dazhe;
    public static int wumenkan;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        manjian = sc.nextInt();
        dazhe = sc.nextInt();
        wumenkan = sc.nextInt();
        sc.nextLine();

        // 表示有n个人购物
        int n = sc.nextInt();
        sc.nextLine();

        List<int[]> list = new ArrayList<>();
        for(int i=0; i<n; i++){

            // 打折之前的商品总价
            double money = sc.nextInt();
            sc.nextLine();

            //首先使用满减的张数
            int quanMJ = money/100 > manjian ? manjian : (int) (money / 100);

            /**
             * key：活动后的价格
             * value：使用优惠券的张数
             */
            Map<Double, Integer> map = new HashMap<>();
            double manjianToDz = Double.MAX_VALUE;
            double dzToManjian = Double.MAX_VALUE;
            double dazheWMK = Double.MAX_VALUE;

            if(dazhe > 0){  //有打折券的情况
                //先满减后打折
                manjianToDz = Manjian(money) * 0.92;
                map.put( manjianToDz, quanMJ + 1);

                //先打折后满减
                dzToManjian = Manjian(money*0.92);
                int quanMJAfterDZ = (int) (money * 0.92 / 100 > manjian ? manjian : money * 0.92 / 100); //先打折后满减的满减券
                if( map.containsKey(dzToManjian)){
                    map.put( dzToManjian, map.get(dzToManjian) > quanMJAfterDZ + 1 ? quanMJAfterDZ + 1 : map.get(dzToManjian));
                }else {
                    map.put( dzToManjian, 1 + quanMJAfterDZ);
                }

                //先打折后无门槛
                dazheWMK = money * 0.92 - wumenkan * 5;
                if( map.containsKey(dazheWMK)){
                    map.put( dazheWMK, map.get(dazheWMK) > wumenkan + 1 ? wumenkan + 1 : map.get(dazheWMK));
                }else {
                    map.put( dazheWMK, 1 + wumenkan);
                }
            }

            //先满减后无门槛
            double manjianWMK = Manjian(money) - wumenkan * 5;
            if( map.containsKey(manjianWMK)){
                map.put( manjianWMK, map.get(manjianWMK) > quanMJ + wumenkan ? quanMJ + wumenkan : map.get(manjianWMK));
            }else {
                map.put( manjianWMK, quanMJ + wumenkan);
            }

            double min = Math.min( Math.min(manjianToDz, dzToManjian), Math.min(manjianWMK, dazheWMK)); //求出最小价格

            list.add(new int[]{(int) Math.floor(min),map.get(min)});
        }

        for (int[] ans : list){
            System.out.println(ans[0] + " " + ans[1]);
        }

    }

    /**
     * 满减后的价格
     * @param money
     * @return
     */
    public static double Manjian(double money){

        if(money/100 >= manjian){
            return money - manjian*10;
        }else {
            return money - (money/100)*10;
        }
    }
}
