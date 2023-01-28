package od;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main24 {

    /**
     *
     *
     * 数组去重和排序
     *
     *
     *
     * 1,3,3,3,2,4,4,4,5
     * 3,4,1,2,5
     *
     *
     * */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        String[] split = str.split(",");

        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < split.length; i++){
            int n = Integer.parseInt(split[i]);
            map.put(n,map.getOrDefault(n,0) + 1);
        }

        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort((o1, o2) -> o2.getValue() - o1.getValue());

        List<Integer> res = new ArrayList<>();

        for (Map.Entry<Integer,Integer> entry : list){
            res.add(entry.getKey());
        }

        String collect = res.stream().map(String::valueOf).collect(Collectors.joining(","));

        System.out.println(collect);


    }

}
