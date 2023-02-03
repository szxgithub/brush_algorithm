package od2023;

import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class Main28 {

    /*

    静态代码扫描服务
     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 缓存一个报告的金币
        int M = sc.nextInt();
        sc.nextLine();

        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        // 文件标识序列
        String[] F = str1.split(" ");
        // 文件大小序列
        String[] S = str2.split(" ");

        // 统计每种文件扫描成本之和
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> sizeMap = new HashMap<>();
        for (int i = 0; i<F.length; i++){
            Integer integer = Integer.valueOf(F[i]);
            Integer size = Integer.valueOf(S[i]);
            map.put(integer,map.getOrDefault(integer,0) + size);
            sizeMap.computeIfAbsent(integer, (key) -> sizeMap.put(integer,size));
        }

        int sum = 0;
        for (Integer integer : map.keySet()){
            if (map.get(integer) > M){
                sum += sizeMap.get(integer) + M;
            }else {
                sum += map.get(integer);
            }
        }

        System.out.println(sum);


    }

}
