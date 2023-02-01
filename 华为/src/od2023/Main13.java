package od2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main13 {

    /*

    MVP争夺战

    这道题通过率非常低 只有0.71%

     */

    public static int score = 0;    //MVP得分

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();
        String[] p = sc.nextLine().split(" ");
        int[] ints = new int[t];

        for(int i=0; i<t; i++){
            ints[i] = Integer.valueOf(p[i]);
        }

        int count = Arrays.stream(ints).sum();
        Arrays.sort(ints);      //对数组进行排序，
        int min = ints[t-1];    //求出数组中最大值，为MVP最低得分

        int res = 0;
        for(int i=min; i<count/2; i++){     //以2个人平分的分数为边界
            if(count%i == 0){   //得分总数可以整除得分
                score = i;      //当前平均分
                if(combine(ints, score, new ArrayList<>(), t-1)){   //从最后一位开始计算（否则会出现问题）
                    res = score;
                    break;
                }
            }
        }

        System.out.println(res == 0 ? count : res);     //分数平分不成功则输出总分
    }

    /**
     *
     * @param ints      篮球得分数组
     * @param n         分数
     * @param list      使用过的得分
     * @param index     得分数组的索引
     * @return
     */
    public static boolean combine(int[] ints, int n, List<Integer> list, int index){

        if(n <= 0){   //分配的得分小于等于平均分
            if(n == 0){
                for(int i=0; i<list.size(); i++){   //将分配过的得分清0（此处不能用删除，否则会越界）
                    ints[list.get(i)] = 0;
                }
                return true;
            }
        }
        for(int i=index; i>=0; i--){
            if(n<0 || Arrays.stream(ints).sum()==0){        //得分小于0或者总得分等于0时跳出循环
                break;
            }
            int x = ints[i];
            if(x == 0){     //此得分失效时寻找下一个得分
                continue;
            }
            list.add(i);    //分配过的得分集合
            if(combine(ints, n-x, list, i-1)){      //分数获取成功后继续下一个分数分配
                int count = Arrays.stream(ints).sum();  //当前得分数组中所剩的总得分
                if(count == 0 || count%score != 0){     //剩余总分等于0或不能对得分进行整除则跳出循环
                    break;
                }
                combine(ints, score, new ArrayList<>(), ints.length-1);
            }
            list.remove(list.size()-1);
        }

        return Arrays.stream(ints).sum() == 0;      //如果剩余总分等于0则表示分配成功
    }


}
