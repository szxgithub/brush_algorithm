package easy;

import java.util.Arrays;

public class Item2335 {

/*

装满杯子需要的最短总时长

 */

    // 每次取最多的两种
    public int fillCups(int[] amount){
        int res = 0;
        while (amount[0] > 0 || amount[1] > 0 || amount[2] > 0){
            Arrays.sort(amount);
            if (amount[2] > 0 && amount[1] > 0){
                amount[2]--;
                amount[1]--;
                res++;
            }else if (amount[2] >0 && amount[0] >0){
                amount[2]--;
                amount[0]--;
                res++;
            }else if (amount[1] > 0 && amount[0] > 0){
                amount[0]--;
                amount[2]--;
                res++;
            }else if (amount[2] > 0){
                amount[2]--;
                res++;
            }else if (amount[1] > 0){
                amount[1]--;
                res++;
            }else if (amount[0] > 0){
                amount[0]--;
                res++;
            }
        }

        return res;

    }

    public int fillCups2(int[] amount) {
        Arrays.sort(amount);
        if (amount[2] > amount[1] + amount[0]) {
            return amount[2];
        }
        return (amount[0] + amount[1] + amount[2] + 1) / 2;
    }

    public static void main(String[] args) {
        Item2335 item2335 = new Item2335();

        //int[] amount = {1,4,2};
        int[] amount2 = {5,4,4};
        // int[] amount3 = {5,0,0};

        int i = item2335.fillCups(amount2);
        System.out.println(i);
    }



}
