package hard;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public class Item1250 {


    /*

    检查「好数组」


     */

    public boolean isGoodArray(int[] nums){
        //  计算数组 nums中的所有元素的最大公约数，根据最大公约数是否为 1， 即可判断是否是好数组
        int asInt = Arrays.stream(nums).reduce(Item1250::gcd).getAsInt();
        if (asInt == 1){
            return true;
        }else {
            return false;
        }
    }

    /*
    欧几里得算法，又叫辗转相除法，是求最大公约数的算法
     */
    public static int gcd(int a, int b){

        if (a > b){
            if (b == 0){
                return a;
            }
            return gcd(b,a%b);
        }else {
            if (a == 0){
                return b;
            }
            return gcd(a,b%a);
        }
    }

    public static void main(String[] args) {

        Item1250 item1250 = new Item1250();

        int[] nums = {3,6};
        boolean goodArray = item1250.isGoodArray(nums);
        System.out.println(goodArray);

    }

}
