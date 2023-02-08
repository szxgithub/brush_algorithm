package od2023;

import java.util.*;

public class Main64 {

    /*
    投篮大赛


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
