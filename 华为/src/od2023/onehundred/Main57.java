package od2023.onehundred;

import java.util.*;

public class Main57 {

    /*
    快递投放问题

    输入描述：
        输入M、N，
        M个包裹N个道路

    输出描述:
        输出不能送达的包裹，如package2 package4
        如果所有能送达，则输出none
        输出结果按照升序排列
    用例：
    输入：
        4 2
        package1 A C
        package2 A C
        package3 B C
        package4 A C
        A B package1
        A C package2 package4
     输出：
        package2, package4



     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // M条包裹运输路径（从一个站点到另一个站点）
        int M = sc.nextInt();
        // N条路径(两个站点之间)拦截的包裹
        int N = sc.nextInt();
        sc.nextLine();

        Map<String,String> mapPkg = new HashMap<>();
        for (int i =0;i <M; i++){
            String[] s = sc.nextLine().split(" ");
            mapPkg.put(s[0],s[1] + s[2]);
        }

        Map<String, List<String>> mapNo = new HashMap<>();
        for (int i =0; i<N; i++){
            String[] s = sc.nextLine().split(" ");
            // 一条路径可能拦截多个包裹，用list
            List<String> noList = new ArrayList<>();
            for (int j = 2; j < s.length; j++){
                noList.add(s[j]);
            }
            mapNo.put(s[0] + s[1],noList);
        }

        List<String> resList = new ArrayList<>();
        for (Map.Entry<String,List<String>> map :  mapNo.entrySet()){
            String key = map.getKey();
            List<String> value = map.getValue();
            for (String s : value){
                if (key.equals(mapPkg.get(s))){
                    resList.add(s);
                }
            }
        }

        System.out.println(resList);


    }

}
