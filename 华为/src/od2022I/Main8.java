package od2022I;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main8 {

    /**
     *
     * .输入一个数 返回所有可能的连续自然数和
     *
     * */

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){

            Integer num = sc.nextInt();

            int slow = 1, fast =2;
            int sum = 3;

            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> self = new ArrayList<>();
            self.add(num);
            ans.add(self);

            while (slow < fast){
                if (sum < num){
                    sum += ++fast;
                }else if (sum > num){
                    sum -= slow++;
                }else {
                    List<Integer> tmp = new ArrayList<>();
                    for (int i = slow; i <= fast; i++){
                        tmp.add(i);
                    }
                    ans.add(tmp);
                    sum -= slow++;
                }
            }

            for (List<Integer> list : ans){
                System.out.println(Arrays.toString(list.stream().toArray()));
            }
        }

    }

}
