package 剑指offer.middle;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Offer45 {

    /*
    把数组排成最小的数
     */

    public String minNumber(int[] nums) {

        List<String> collect = Arrays.stream(nums).boxed().map(String::valueOf).collect(Collectors.toList());

        collect.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });

        String res = collect.stream().collect(Collectors.joining());
        return res;
    }

    public static void main(String[] args) {

        Offer45 offer45 = new Offer45();
        int[] nums = {3,30,34,5,9};
        String s = offer45.minNumber(nums);
        System.out.println(s);
    }

}
