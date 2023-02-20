package od2022I;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main59 {

    /*

    数字反转打印


     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<List<String>> lists = new ArrayList<>();

        for(int i=1;i<=n;i++){      //为了方便i初始值设为1
            List<String> list = new ArrayList<>();
            int fn = firstNum(i);     //先计算出行头数字
            lists.forEach(x->{
                x.add(0,"    ");        //每加一行，前面的所有行前面都加一个"    "
            });
            for(int j=0;j<i;j++){
                String temp = fn++ + "***";        //每个数后面都加三个*，因为至少一位数，所以只要加三个
                list.add(temp.substring(0,4));     //头数向后递加，只取前面四个字符串
                if(j!=i-1){
                    list.add("    ");       //除了最后一个数，其余全部加上"    "
                }
            }
            if((i)%2==0){
                Collections.reverse(list);      //偶数行进行翻转
            }
            lists.add(list);
        }

        lists.forEach(x->{
            String res = "";        //把所有行转化成字符串类型
            for(int i=0;i<x.size();i++){
                res+=x.get(i);
            }
            System.out.println(res);
        });
    }

    public static int firstNum(int n){
        if(n==1){
            return 1;
        }
        return firstNum(n-1)+n-1;       //根据规律推出第n行的头为n-1的头加上n-1
    }

}
