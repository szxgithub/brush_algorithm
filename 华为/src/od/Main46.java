package od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main46 {

    /**
     *
     * 火星文计算
     *
     * 7#6$5#12
     * 226
     *
     *
     * */

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);

        String str = sc.nextLine();

        List<Integer> nums = new ArrayList<>();

        String[] split = str.split("#");
        for (int i=0; i<split.length; i++){
            if (split[i].contains("$")){
                String[] tmpArr = split[i].split("\\$");
                int res = Integer.parseInt(tmpArr[0]);
                for (int j = 1; j<tmpArr.length; j++){
                    int tmp = Integer.parseInt(tmpArr[j]);
                    res = 3*res + tmp + 2;
                }
                nums.add(res);
            }else {
                nums.add(Integer.parseInt(split[i]));
            }
        }

        int ans = nums.get(0);
        for (int i = 1; i < nums.size(); i++){
            ans = 2*ans + 3*nums.get(i) + 4;
        }

        System.out.println(ans);

    }

}
