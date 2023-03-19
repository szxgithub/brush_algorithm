package od2023.onehundred;

import java.util.*;

public class Main44 {

    /*

    预订酒店
    各种价位的酒店（长度为n的数组A）
    小明的心理价位是X元，请筛选出K个最接近X元的酒店，并由低到高打印酒店的价格

    输入描述：
        第一行:n,k,x
        第二行:A[0],A[1],A[2],..A[n-1]
    输出描述：
        从低到高打印酒店的价格

输入：
10 4 6
10 9 8 7 6 5 4 3 2 1
输出：
4 5 6 7


输入：
6 3 1000
30 30 200 500 70 300
输出：
200 300 500

     */

    /*
    逻辑分析 排序
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // n个酒店 酒店价格可能重复
        int n = sc.nextInt();
        // 选出最接近x的k个酒店
        int k = sc.nextInt();
        // 心理价位
        int x = sc.nextInt();

        int[] hotel = new int[n];
        // index ---> [price, diff]
        Map<Integer,List<Integer>> map = new HashMap<>();
        for (int i = 0; i<hotel.length; i++){
            hotel[i] = sc.nextInt();
            List<Integer> orDefault = map.getOrDefault(i, new ArrayList<>());
            orDefault.add(hotel[i]);
            orDefault.add(Math.abs(hotel[i]-x));
            map.put(i,orDefault);
        }
        ArrayList<Map.Entry<Integer, List<Integer>>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> {
            // 按差价从低到高排序
            if (o1.getValue().get(1).equals(o2.getValue().get(1))){
                // 如果差价相同，按价格升序排序
                return o1.getValue().get(0) - o2.getValue().get(0);
            }else {
                return o1.getValue().get(1) - o2.getValue().get(1);
            }
        });

        int[] res = new int[k];
        for (int i =0; i<k; i++){
            res[i] = list.get(i).getValue().get(0);
        }

        // 由低到高打印酒店的价格
        Arrays.sort(res);

        String str = "";
        for (int i : res){
            str += i + " ";
        }

        str = str.substring(0, str.length() - 1);
        System.out.println(str);

    }

}
