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

    输入描述：
        第一行缓存一个报告金币数M
        第二行文件标识序列：F1 F2 ...Fn
        第三行文件大小序列：S1,S2,S3...Sn
    输出描述：
        采用合理的缓存策略，需要的最少金币数

输入：
5
1 2 2 1 2 3 4
1 1 1 1 1 1 1
输出：
7


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

        // 统计每种文件出现次数
        HashMap<Integer, Integer> map = new HashMap<>();
        // 统计每种文件扫描成本
        HashMap<Integer, Integer> sizeMap = new HashMap<>();
        for (int i = 0; i<F.length; i++){
            Integer integer = Integer.valueOf(F[i]);
            Integer size = Integer.valueOf(S[i]);
            map.put(integer,map.getOrDefault(integer,0) + 1);
            sizeMap.computeIfAbsent(integer, (key) -> sizeMap.put(integer,size));
        }

        int sum = 0;
        for (Integer integer : map.keySet()){

            int saomiao = map.get(integer) * sizeMap.get(integer);
            int cache = sizeMap.get(integer) + M;

            // 比较扫描成本 和 缓存成本
            sum += Math.min(saomiao,cache);

        }

        System.out.println(sum);


    }

}
