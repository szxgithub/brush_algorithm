package middle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Item1015 {

    /*
     可被 K 整除的最小整数
     */
    public int smallestRepunitDivByK(int k){
        HashSet<Integer> set = new HashSet<>();
        int x = 1%k;
        while (x > 0 && set.add(x)){
            x = (x*10 + 1)%k;
        }
        return x > 0 ?  -1 : set.size() + 1;
    }

}
