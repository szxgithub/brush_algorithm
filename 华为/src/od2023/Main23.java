package od2023;

import sun.nio.ch.SelectorImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main23 {

    /*

    新员工座位安排系统 可以直接暴力模拟

    下面这个解法很巧妙


     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        String[] s = str.split(" ");
        int[] arr = new int[s.length];
        for (int i =0; i < arr.length; i++){
            arr[i] = Integer.parseInt(s[i]);
        }

        // 存放原来的工位序列右边的连续老员工之和， 座位0保持，障碍物设置为-1
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for (int i =0; i<arr.length; i++){
            if (arr[i] == 1){
                count++;
                if (i==arr.length-1){
                    list.add(count);
                }
            }else if (arr[i] == 0){
                if (count != 0){
                    list.add(count);
                    count = 0;
                }
                list.add(0);
            }else {
                if (count != 0){
                    list.add(count);
                    count = 0;
                }
                // 2记作-1
                list.add(-1);
            }
        }

        int max = 0;
        if(list.size() != 1){   //只有一个
            for(int i=0; i<list.size(); i++){
                if(list.get(i) == 0){
                    int nums = 0;
                    if(i == 0){     //空座位在第一个
                        if(list.get(i+1) != -1){    //空座位右侧不是障碍物
                            nums = list.get(i + 1);
                        }
                    }else if(i == list.size() - 1){     //空座位在最后一个
                        if(list.get(i-1) != -1){    //空座位左侧不是障碍物
                            nums = list.get(i - 1);
                        }
                    }else {
                        if(list.get(i-1) != -1){    //空座位左侧不是障碍物
                            nums += list.get(i - 1);
                        }
                        if(list.get(i+1) != -1){    //空座位右侧不是障碍物
                            nums += list.get(i + 1);
                        }
                    }
                    max = Math.max( max, nums);
                }
            }
        }

        System.out.println(max);

    }

}
