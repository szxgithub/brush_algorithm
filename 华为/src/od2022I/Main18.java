package od2022I;

import java.util.*;

public class Main18 {

    /**
     统计射击比赛成绩

     13
     3,3,7,4,4,4,4,7,7,3,5,5,5
     53,80,68,24,39,76,66,16,100,55,53,80,55

     */



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()){

            int N = sc.nextInt();
            sc.nextLine();
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();

            String[] IDArr = str1.split(",");
            String[] scoreArr = str2.split(",");

            HashMap<Integer, List<Integer>> map = new HashMap<>();

            for (int i = 0; i< IDArr.length; i++){
                int id = Integer.parseInt(IDArr[i]);
                List<Integer> orDefault = map.getOrDefault(id, new ArrayList<>());
                orDefault.add(Integer.parseInt(scoreArr[i]));
                map.put(id,orDefault);
            }

            //  存放队员id和最高三个成绩之和
            List<List<Integer>> lists = new ArrayList<>();
            map.forEach((s, integers) -> {
                List<Integer> list = new ArrayList<>();
                if (integers.size() >= 3){
                    Collections.sort(integers);
                    list.add(s);
                    list.add(integers.get(integers.size() - 1) + integers.get(integers.size() - 2) + integers.get(integers.size() - 3));
                    lists.add(list);
                }
            });

            lists.sort((o1, o2) -> {
                if (o1.get(1) < o2.get(1)){
                    return 1;
                }else if (o1.get(1) > o2.get(1)){
                    return -1;
                }else {
                    if (o1.get(0) < o2.get(0)){
                        return 1;
                    }else {
                        return -1;
                    }
                }
            });

            String res = "";
            for (int i =0; i < lists.size() - 1; i++){
                res += lists.get(i).get(0) + ",";
            }

            System.out.println(res + lists.get(lists.size() - 1).get(0));



        }

    }

}
