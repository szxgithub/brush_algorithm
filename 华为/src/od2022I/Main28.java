package od2022I;

import java.util.*;

public class Main28 {

    /**
     *
     * 按身高和体重排队
     *
     * 4
     * 100 100 120 130
     * 40 30 60 50
     * 2 1 3 4
     *
     * 3
     * 90 110 90
     * 45 60 45
     * 1 3 2
     *
     *
     *
     *
     * */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] height = new int[n];
        int[] weight = new int[n];

        for (int i = 0; i<n;  i++){
            height[i] = scanner.nextInt();
        }

        for (int i = 0; i<n;  i++){
            weight[i] = scanner.nextInt();
        }

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i<n; i++){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(height[i]);
            list.add(weight[i]);
            map.put(i+1,list);
        }

        Set<Map.Entry<Integer, List<Integer>>> entries = map.entrySet();

        ArrayList<Map.Entry<Integer, List<Integer>>> list = new ArrayList<>(entries);

        list.sort((o1, o2) -> {
            if (o1.getValue().get(0) > o2.getValue().get(0)){
                return 1;
            }else if (o1.getValue().get(0) > o2.getValue().get(0)){
                return -1;
            }else {
                return o1.getValue().get(1) - o2.getValue().get(1);
            }
        });

        for (Map.Entry<Integer,List<Integer>> entry : list){
            Integer key = entry.getKey();
            System.out.print(key + " ");
        }


    }

}
