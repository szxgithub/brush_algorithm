package easy;

import java.util.*;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

public class Item2357 {

    /*

    使数组中所有元素都等于零
     */

    public int minimumOperations(int[] nums){

        List<Integer> list = Arrays.stream(nums).mapToObj(value -> Integer.valueOf(value))
                                                .filter(value -> value != 0)
                                                .sorted()
                                                .collect(Collectors.toList());

        if (list.size() == 0){
            return 0;
        }

        int res = 0;
        while (list.size() > 0){
            Integer tmp = list.get(0);
            for (int i = 0; i<list.size(); i++){
                int i1 = list.get(i) - tmp;
                list.set(i,i1);
            }
            res++;
            list = list.stream().filter(value -> value != 0).collect(Collectors.toList());
        }

        return res;

    }

    public static void main(String[] args) {

         int[] nums = {1,5,0,3,5};
        // int[] nums = {0};

        Item2357 item2357 = new Item2357();
        int i = item2357.minimumOperations(nums);
        System.out.println(i);

    }

}
