package easy;

import com.sun.javafx.binding.StringFormatter;

public class Item2347 {

    /*

    最好的扑克手牌

    ranks.length == suits.length == 5

     */

    public String bestHand(int[] ranks, char[] suits){

        String res =  "";
        boolean flush = true;
        for (int i = 0; i< suits.length - 1 && flush; i++){
            flush = suits[i] == suits[i+1];
        }

        if (flush){
            res = "Flush";
            return res;
        }

        int[] rankCount = new int[14];
        for (int i = 0; i< ranks.length; i++){
            rankCount[ranks[i]]++;
            if (rankCount[ranks[i]] >= 3){
                res = "Three of a Kind";
                break;
            }else if (rankCount[ranks[i]] >= 2){
                res = "Pair";
            }
        }

        if (res.isEmpty()){
            res = "High Card";
        }
        return res;

    }

    public static void main(String[] args) {

        Item2347 item2347 = new Item2347();
        int[] ranks = {10,10,2,12,9};
        char[] suits = {'a','b','c','a','d'};
        String s = item2347.bestHand(ranks, suits);
        System.out.println(s);

    }

}
