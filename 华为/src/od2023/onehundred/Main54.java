package od2023.onehundred;

import java.util.HashMap;
import java.util.Scanner;

public class Main54 {

    /*

    静态代码扫描服务
    如果文件大小为N，则扫描成本为N个金币
    扫描报告的缓存成本和文件大小无关，每缓存一个报告则需要M个金币
    扫描报告缓存后，后继再碰到则不需要扫描成本

    给出源代码文件标识序列和文件大小序列，求解采用合理的缓存策略，最少需要的金币数




     */

    /*
    简单逻辑 贪心思维
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
            // 如果文件的扫描成本之和 大于 缓存成本，则扫描一次，缓存一次
            if (map.get(integer) > M){
                sum += sizeMap.get(integer) + M;
            }else {
                sum += map.get(integer);
            }
        }

        System.out.println(sum);


    }

}
