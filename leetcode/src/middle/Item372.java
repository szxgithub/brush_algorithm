package middle;

import java.math.BigDecimal;
import java.util.Arrays;

public class Item372 {
    /*
    超级次方
     */

    int base = 1337;
    public int superPow(int a, int[] b) {
        int len = b.length;
        int ans = indexPow(a, b, len);
        return ans;
    }

    //a的k次方对base取模  首先需要知道这个公式 (a⋅b)modm=[(amodm)⋅(bmodm)]modm
    private int myPow(int a,int k){
        a %=base;
        int ans=1;
        for(int i = 0;i<k;i++){
            ans *= a;
            ans %=base;
        }
        return ans;
    }

    //加入index判断是否需要终止递归
    private int indexPow(int a,int[] b,int index){
        if(index < 1 )return 1;

        int part1 = myPow(a, b[index-1]);
        index -- ;
        int part2 = myPow(indexPow(a, b, index), 10);

        return part1*part2%base;
    }

    public static void main(String[] args) {

        Item372 item372 = new Item372();
        int a = 2147483647;
        int[] b = {2,0,0};

        int i = item372.superPow(a, b);
        System.out.println(i);


    }

    int myPow2(int a, int k){
        if (k == 0){
            return 1;
        }
        a %= base;
        if (k%2==1){
            return a*myPow2(a,k-1)%base;
        }else {
            int sub = myPow(a,k/2);
            return sub*sub%base;
        }
    }

}
