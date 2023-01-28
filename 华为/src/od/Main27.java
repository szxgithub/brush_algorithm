package od;

import java.util.*;

public class Main27 {

    /**
     *
     * 最长广播响应
     *
     *
     *
     * */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int n = sc.nextInt();

        sc.nextLine();

        Map<Integer,List<Integer>> map = new HashMap<>();

        for (int i = 0; i<n; i++){
            int i1 = sc.nextInt();
            int i2 = sc.nextInt();
            List<Integer> orDefault = map.getOrDefault(i1, new ArrayList<>());
            orDefault.add(i2);
            map.put(i1,orDefault);
        }

        int seq = sc.nextInt();
        int ans = 0;
        List<Integer> integers = map.get(seq);
        ans += integers.size();
        for (int i = 0; i<integers.size(); i++){
            Integer integer = integers.get(i);
            List<Integer> tmpList = map.get(integer);
            for (int j = 0; tmpList != null && j<tmpList.size(); j++){
                if(integers.contains(tmpList.get(j))){
                    continue;
                }else {
                    integers.add(tmpList.get(j));
                    ans++;
                }
            }
        }

        System.out.println(ans);

    }

}
