package od2023.onehundred;

import java.util.*;

public class Main40 {

    /*
    投篮大赛

    你会得到一个记录操作的字符串列表ops,其中ops[i]是你需要记录的第i项操作，ops遵顼以下规则：
    1、整数x表示本回合获得分数x
    2、+ 表示本回合获得分数是前两次获得分数之和
    3、D 表示本回合获得分数是前一次得分的两倍
    4、C 表示本回合没有得分，并且前一次得分无效，将其从记录中移除

    请你返回记录中所有的得分的总和



     */

    /*
    简单逻辑分析题
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] ops = sc.nextLine().split(" ");

        List<Integer> list = new ArrayList<>();
        boolean isError = false;
        for(int i=0; i<ops.length; i++){
            String s = ops[i];
            if(s.equals("+")){
                if(list.size() < 2){    //集合中没有足够的数据用来相加
                    isError = true;
                    break;
                }
                int before1 = list.get(list.size()-1);    //倒数第一个数
                int before2 = list.get(list.size()-2);    //倒数第二个数
                list.add(before1 + before2);
            }else if(s.equals("C")){
                if(list.size() == 0){    //集合中没有数据用来删除
                    isError = true;
                    break;
                }
                list.remove(list.size()-1);    //移除最后一个数
            }else if(s.equals("D")){
                if(list.size() == 0){    //集合中没有数据用来double
                    isError = true;
                    break;
                }
                int before1 = list.get(list.size()-1);    //倒数第一个数
                list.add(before1 * 2);
            }else {
                list.add(Integer.valueOf(s));
            }
        }

        if(isError){
            System.out.println(-1);
        }else {
            int res = 0;
            for(int i : list){
                res += i;
            }

            System.out.println(res);
        }
    }

}
