package od;

import java.util.*;
import java.util.stream.Collectors;

public class Main36 {

    /**
     *
     * 服务失效判断
     *
     * 输入：
     * a1-a2
     * a2
     * 输出：
     * ,
     *
     *
     * */


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str1 = sc.nextLine();

        HashMap<String, List<String>> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        String[] split = str1.split(",");
        for (int i = 0; i< split.length; i++){
            String[] tmpArr = split[i].split("-");
            List<String> orDefault = map.getOrDefault(tmpArr[1], new ArrayList<>());
            orDefault.add(tmpArr[0]);
            map.put(tmpArr[1],orDefault);

            if (!list.contains(tmpArr[0])){
                list.add(tmpArr[0]);
            }
            if (!list.contains(tmpArr[1])){
                list.add(tmpArr[1]);
            }

        }

        String str2 = sc.nextLine();

        String[] faults = str2.split(",");
        for (int i = 0; i< faults.length; i++){
            list.remove(faults[i]);
            List<String> strings = map.get(faults[i]);
            if (strings != null){
                list.removeAll(strings);
            }
        }

        if (list.isEmpty()){
            System.out.println(",");
        }else {
            String collect = list.stream().collect(Collectors.joining(","));
            System.out.println(collect);
        }

    }

}
