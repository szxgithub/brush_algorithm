package od2023;

import java.util.*;

public class Main38 {

    /*

    预定酒店

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
                // 如果差价相同，按价格排序
                return o1.getValue().get(0) - o2.getValue().get(0);
            }else {
                return o1.getValue().get(1) - o2.getValue().get(1);
            }
        });

        int[] res = new int[k];
        for (int i =0; i<k; i++){
            res[i] = list.get(i).getValue().get(0);
        }

        Arrays.sort(res);

        String str = "";
        for (int i : res){
            str += i + " ";
        }

        str = str.substring(0, str.length() - 1);
        System.out.println(str);

    }

}
